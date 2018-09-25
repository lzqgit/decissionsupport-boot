package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.PublicSecurityForce;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名: PublicSecurityForceController
 * @描述: 获取平台公安机构数据信息并进行处理返回到前台显示
 * @版本: 
 * @创建日期: 2017-1-11下午02:12:23
 * @作者: liuyh
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本: 
 * @修改日期: 2017-1-11下午02:12:23
 * @修改人: liuyh
 * @JDK: 1.6
 */
@Controller
public class PublicSecurityForceController extends BaseController {
		
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	@RequestMapping(value = "/PublicSecurityForce/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	//根据公安机构名称对其应急救援人员数量进行统计
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/PublicSecurityForce/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		Page pageData = findConditionByPage(null, null);
		Map map = new HashMap();
		List list = null;
		if(pageData != null){
			list = pageData.getList();
		}
		String temp;
		Integer curCount;
		if(list!= null){
			for(int i = 0; i < list.size(); i++){
				com.alibaba.fastjson.JSONObject jsonObj = (com.alibaba.fastjson.JSONObject) list.get(i);
				   temp = jsonObj.getString("pubsecorg_name");
				   curCount = Integer.valueOf(jsonObj.getString("emer_psn_num"));
			/*	temp = ((PublicSecurityForce)list.get(i)).getPubsecorg_name();
				curCount =  Integer.valueOf(((PublicSecurityForce)list.get(i)).getEmer_psn_num());*/
				Integer count = (Integer)map.get(temp);
				map.put(temp, (count == null) ? curCount : count+curCount);
			}
		}
		
		if(map != null && map.size()>6){
			ValueComparator vc = new ValueComparator(map);
			TreeMap<String,Integer> sorted_map = new TreeMap<String, Integer>(vc);
			sorted_map.putAll(map);
			//
			int i=0;
			int count=0;
			LinkedHashMap<String,Integer> newLinkedMap =new LinkedHashMap<String, Integer>();
			for(Map.Entry<String, Integer> entry : sorted_map.entrySet()){
				if(i<6){
					newLinkedMap.put(entry.getKey(), entry.getValue());
					i++;
					continue;
				}else{//
					count +=entry.getValue();
					i++;
					continue;
				}
			}
			newLinkedMap.put("其他", count);
			return getResult(newLinkedMap, StateCode.SUCCESS_DEFAULT);
		}else{
			return getResult(map, StateCode.SUCCESS_DEFAULT);
		}
	}

	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("PublicSecurityForcegetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * findConditionByPage
	 * 
	 * @描述: 按条件分页查找数据
	 * @作者: liub
	 * @创建时间: 2017-1-11上午09:46:42
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-1-11上午09:46:42
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		String result = getOutData();
		if(!(result==null||result.length()<=0)){
			com.alibaba.fastjson.JSONObject T = com.alibaba.fastjson.JSONObject.parseObject(result);
			if(T.get("code").toString().equals("0")){
				com.alibaba.fastjson.JSONArray arr = T.getJSONArray("data");
				String js = com.alibaba.fastjson.JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
				List<PublicSecurityForce>  list = com.alibaba.fastjson.JSONObject.parseArray(js, PublicSecurityForce.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
