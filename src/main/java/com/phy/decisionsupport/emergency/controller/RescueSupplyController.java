package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.RescueSupply;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名: RescueSupplyController
 * @描述: 分页获取应急救援物资信息
 * @版本: 
 * @创建日期: 2017-3-9上午09:44:24
 * @作者: liuyh
 * @JDK: 1.6
 */


@Controller
public class RescueSupplyController extends BaseController {
    
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");

	@RequestMapping(value = "/RescueSupply/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	
	/**
	 * getStatistics
	 * @描述: 分别统计不同名称应急救援物资的数量
	 * @作者: liuyh
	 * @创建时间: 2017-3-9上午09:41:31
	 * 当pageSize为null时，则返回所有数据
	 */
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/RescueSupply/getStatistics")
	public @ResponseBody
    ResultObject getStatistics(){
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
				temp = jsonObj.getString("emermate_name");
				curCount =  Integer.valueOf(jsonObj.getString("quanity"));
				Integer count = (Integer)map.get(temp);
				map.put(temp, (count == null) ? curCount : count+curCount);
			}
		}
		if( map != null && map.size()>6){
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
	/**
	 * getOutData
	 * @描述: 获取应急救援物资接口数据
	 * @作者: liuyh
	 * @创建时间: 2017-3-9上午08:42:07
	 */

	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("emergencySupplygetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	

	/**
	 * findConditionByPage
	 * @描述: 分页查找数据
	 * @作者: liuyh
	 * @创建时间: 2017-3-9上午08:45:45
	 */
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		String result = getOutData();
		//判断接口是否有数据
		if(!(result==null||result.length()<=0)){
			com.alibaba.fastjson.JSONObject T = com.alibaba.fastjson.JSONObject.parseObject(result);
			if(T.get("code").toString().equals("0")){
				com.alibaba.fastjson.JSONArray arr = T.getJSONArray("data");
				String js = com.alibaba.fastjson.JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
				List<RescueSupply>  list = com.alibaba.fastjson.JSONObject.parseArray(js, RescueSupply.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
