package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.FireFightingForce;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名: FireFightingForceController
 * @描述: 获取消防接口数据并处理返回到前台显示
 * @版本: 
 * @创建日期: 2017-1-11下午03:29:29
 * @作者: liuyh
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本: 
 * @修改日期: 2017-1-11下午03:29:29
 * @修改人: liuyh
 * @JDK: 1.6
 */
@Controller
public class FireFightingForceController extends BaseController {

	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	/**
	 * list
	 * @描述: 将消防信息转化为列表对象
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午03:30:59
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11下午03:30:59
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * 
	 */	 
	@RequestMapping(value = "/FireFightingForce/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	/**
	 * getAllStatistics
	 * @描述: 根据消防机构名称对其应急救援人员数量进行统计
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午03:33:29
	 * 
	 * @修改描述:无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11下午03:33:29
	 * @return
	 */
	 
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/FireFightingForce/getStatistics")
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
				temp = jsonObj.getString("fireorg_name");
				curCount = Integer.valueOf(jsonObj.getString("emer_psn_num"));
				Integer count = (Integer)map.get(temp);
				map.put(temp, (count == null) ? curCount : count+curCount);
			}
		}
		if(map != null &&map.size()>6){
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
	 * @描述: 获取平台消防机构信息数据
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午03:18:29
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11下午03:18:29
	 * @return 数据格式{"a":[{"b":"2","c":"2"},{"b":"3","c":"3"}]}
	 *  
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("FireFightingForcegetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * findConditionByPage
	 * @描述: 将获取的字符串数据转化成page对象
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午03:25:11
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11下午03:25:11
	 * @param pageNum
	 * @param pageSize
	 * @return
	 *  
	 */	 
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		String result = getOutData();
		if(!(result==null||result.length()<=0)){
			com.alibaba.fastjson.JSONObject T = com.alibaba.fastjson.JSONObject.parseObject(result);
			if(T.get("code").toString().equals("0")){
				com.alibaba.fastjson.JSONArray arr = T.getJSONArray("data");
				String js = com.alibaba.fastjson.JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
				List<FireFightingForce>  list = com.alibaba.fastjson.JSONObject.parseArray(js, FireFightingForce.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
