package com.phy.decisionsupport.dao.impl;

import com.phy.decisionsupport.dao.IGetOutDataDao;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.cookie.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GetOutDataDaoImpl implements IGetOutDataDao {
	
	private static final Logger log = Logger.getLogger(GetOutDataDaoImpl.class);
	
	
	/**
	 * GetDataByClient  使用HttpClient方法
	 * @描述: 通过GET方法访问http接口并返回所有列表数据
	 * @作者: huangzhch
	 * @创建时间: 2016-12-19下午05:05:51
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-19下午05:05:51
	 * @param url   需要访问远程的URL
	 * @param params  访问远程连接参数
	 * @return
	 */
	@Override
	public String GetDataByClient(String url, Map<String, Object> params){
		//尝试重新连接次数
		int retryCount = 10;
		//拼接url
		if(params != null && params.size() > 0){
			String paramStr = "?";
			for (String key : params.keySet()) {
				if(params.get(key) != null){
					paramStr += key + "=" + params.get(key) + "&";
				}
			}
			paramStr = paramStr.substring(0, paramStr.length() - 1);
			url += paramStr;
		}
		
		
		//尝试连接
		String result = null;
		for (int i = 0; i < retryCount; i++) {
			result = tryConnection(url, i);
			if (result != null) {
				return result;
			}
		}
		return null;
	}
	
	/**
	 * tryConnection
	 * @描述: 尝试连接远程链接
	 * @作者: huangzhch
	 * @创建时间: 2016-12-26下午04:22:21
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-26下午04:22:21
	 * @param httpClient
	 * @param url
	 * @param count
	 * @return
	 */
	private String tryConnection(String url, int count){
		// 针对抛出的异常“WARN Cookie rejected”
		CookieSpecFactory csf = new CookieSpecFactory() {
			public CookieSpec newInstance(HttpParams params) {
				return new BrowserCompatSpec() {
					public void validate(Cookie cookie, CookieOrigin origin)
							throws MalformedCookieException {

					}
				};
			}
		};

		DefaultHttpClient httpClient = new DefaultHttpClient();
		// 针对抛出的异常“WARN Cookie rejected”
		httpClient.getCookieSpecs().register("easy", csf);
		httpClient.getParams().setParameter(ClientPNames.COOKIE_POLICY, "easy");
		HttpGet httpGet = new HttpGet(url);
		try{
			HttpResponse response = httpClient.execute(httpGet);
			// 获取状态码
			int stateCode = response.getStatusLine().getStatusCode();
			if (stateCode == 200) {
				return EntityUtils.toString(response.getEntity(), "UTF-8");
			} else {
				log.error("连接远程端口：" + url + "，第" + (count + 1) + "次失败！连接错误码："
						+ stateCode);
			}
		}catch(ClientProtocolException e){
			log.error("连接远程端口：" + url + ", 连接"+ (count+1) + "次失败！错误提示：" + e.getMessage());
		}catch(IOException e){
			log.error("连接远程端口：" + url + ", 连接"+ (count+1) + "次失败！错误提示：" + e.getMessage());
		}catch(Exception e){
			log.error("连接远程端口：" + url + ", 连接"+ (count+1) + "次失败！错误提示：" + e.getMessage());
		}finally{
			httpClient.getConnectionManager().shutdown();
		}
		return null;
	}
	
	/**
	 * getComplaintInfoData
	 * @描述: 获取远程接口数据
	 * @作者: huangzhch
	 * @创建时间: 2016-12-19下午05:11:18
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-19下午05:11:18
	 * @return
	 */
	@Override
	public List<Map> getOutInfoData(String url, Map params) {
		String resultStr = "";
		
		resultStr = GetDataByClient(url, params);
		return strToListMap(resultStr);
	}
	
	/**
	 * changeFormat
	 * @描述: 将String类型转换为List<Map>
	 * @作者: huangzhch
	 * @创建时间: 2016-12-19下午03:36:51
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-19下午03:36:51
	 * @param str
	 * @return
	 */
	private List<Map> strToListMap(String str){
		if(str == null || str.isEmpty()){
			return null;
		}
		String[] maps = str.split("},");
		String temp = "";
		String[] mapStr;
		List<Map> list = new ArrayList();
		for(int i = 0; i < maps.length; i++){
			Map map = new HashMap();
			temp = maps[i];
			if(i == 0){
				temp = temp.substring(2);
			}else{
				temp = temp.substring(1);
			}
			//将其中的双引号去掉
			temp = temp.replace("\"", "");
			mapStr = temp.split(",");
			for(int j = 0; j < mapStr.length; j++){
				String[] keyValue = mapStr[j].split(":");
				if(keyValue.length > 1){
					map.put(keyValue[0], keyValue[1]);
				}else{
					map.put(keyValue[0], null);
				}
			}
			list.add(map);
		}
		return list;
	}
}
