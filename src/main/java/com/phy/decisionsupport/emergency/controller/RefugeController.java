package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.Shelter;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;


/**
 * @类名: RefugeController
 * @描述: 避难场所控制层
 * @版本: 
 * @创建日期: 2016-12-12上午09:47:26
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本: 
 * @修改日期: 2016-12-12上午09:47:26
 * @修改人: huangzhch
 * @JDK: 1.6
 */
@Controller
public class RefugeController extends BaseController {
	
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	/**
	 * list
	 * @描述: 获取所以避难场所信息数据
	 * @作者: liub
	 * @创建时间: 2017-1-11下午02:50:16
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-1-11下午02:50:16
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/Refuge/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}

	/**
	 * getAllStatistics
	 * @描述:根据场所名称对场所可容纳人员数量进行统计;根据场所类型对对避难场所数量进行统计;
	 * @作者: liub
	 * @创建时间: 2017-1-11下午03:00:43
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-1-11下午03:00:43
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/Refuge/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		// 当pageSize为null时，则返回所有数据
		Page pageData = findConditionByPage(null, null);
		Map mapName = new HashMap();
		Map mapCount = new HashMap();
		List allList = new ArrayList();
		List list = null;
		if (pageData != null) {
			list = pageData.getList();
		}
		String tempName = "";
		String tempCount = "";
		Integer countName = null;
		Integer countCount = null;
		Integer curCount = null;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				//根据场所名称对场所可容纳人员数量进行统计
				JSONObject jsonObj = (JSONObject) list.get(i);
				tempName = jsonObj.getString("shelter_name");
				curCount =  Integer.valueOf(jsonObj.getString("galleryful"));
				countName = (Integer) mapName.get(tempName);
				mapName.put(tempName, (countName == null) ? curCount
						: countName + curCount);
				//根据场所类型对对避难场所数量进行统计;
				tempCount = jsonObj.getString("shelter_type");
				countCount = (Integer) mapCount.get(tempCount);
				mapCount.put(tempCount, (countCount == null) ? 1 : countCount
						+ 1);
			}
		}
		if(mapName!= null && mapName.size()>6){
			ValueComparator vc = new ValueComparator(mapName);
			TreeMap<String,Integer> sorted_map = new TreeMap<String, Integer>(vc);
			sorted_map.putAll(mapName);
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
			allList.add(newLinkedMap);
		}else{
			allList.add(mapName);
		}
		allList.add(mapCount);
		return getResult(allList, StateCode.SUCCESS_DEFAULT);
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
		//判断接口是否有数据
		if(!(result==null||result.length()<=0)){
			JSONObject T = JSONObject.parseObject(result);
			if(T.get("code").toString().equals("0")){
				com.alibaba.fastjson.JSONArray arr = T.getJSONArray("data");
				String js = JSONObject.toJSONString(arr,SerializerFeature.WriteClassName);
				List<Shelter>  list = JSONObject.parseArray(js, Shelter.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
			}
		}
		return page;
	}
	
	/**
	 * getOutData
	 * 
	 * @描述: 通过webservice获取避难场所信息数据
	 * @作者: liub
	 * @创建时间: 2017-1-9下午06:56:20
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-1-9下午06:56:20
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("RefugegetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
