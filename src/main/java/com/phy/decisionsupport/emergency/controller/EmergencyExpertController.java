package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.EmergencyExpert;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名: EmergencyExpertController
 * @描述: 从平台获取应急专家信息并处理返回给前台
 * @版本: 
 * @创建日期: 2017-1-11下午04:07:04
 * @作者: liuyh
 * @JDK: 1.6
 * 
 * @修改描述:无
 * @版本: 
 * @修改日期: 2017-1-11下午04:07:04
 * @修改人: liuyh
 * @JDK: 1.6
 */
@Controller
public class EmergencyExpertController extends BaseController {
	
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	/**
	 * list
	 * @描述: 获取应急专家信息并封装为list对象返回给前台
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午04:08:31
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11下午04:08:31
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 
	@RequestMapping(value = "/EmergencyExpert/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	/**
	 * getAllStatistics
	 * @描述: 根据专家类别、学历对专家数量进行统计
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午04:09:27
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11下午04:09:27
	 * @return
	 */	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/EmergencyExpert/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		// 当pageSize为null时，则返回所有数据
		Page pageData = findConditionByPage(null, null);
		Map mapType = new HashMap();
		Map mapEducation = new HashMap();
		List allList = new ArrayList();
		List list = null;
		if (pageData != null) {
			list = pageData.getList();
		}
		String tempType = "";
		String tempEducation = "";
		Integer countType = null;
		Integer countEducation = null;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// 根据专家类别对专家数量进行统计
				com.alibaba.fastjson.JSONObject jsonObj = (com.alibaba.fastjson.JSONObject) list.get(i);
				tempType = jsonObj.getString("expert_type");
				countType = (Integer) mapType.get(tempType);
				mapType.put(tempType, (countType == null) ? 1
						: countType + 1);
				// 根据专家学历对专家数量进行统计
				tempEducation = jsonObj.getString("diploma_code");
				countEducation = (Integer) mapEducation.get(tempEducation);
				mapEducation.put(tempEducation, (countEducation == null) ? 1 : countEducation
						+ 1);
			}
		}
		allList.add(mapType);
		allList.add(mapEducation);
		return getResult(allList, StateCode.SUCCESS_DEFAULT);
	}


	/**
	 * getOutData
	 * @描述: 从应急专家库接口调用应急专家信息
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午04:03:11
	 * 
	 * @修改描述:无
	 * @修改人: lzq
	 * @修改时间: 2018-9-13上午10:12:11
	 * @return
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("emergencyExpertgetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}



	/**
	 * findConditionByPage
	 * @描述: 将获取的字符串数据转换成分页数据对象
	 * @作者: liuyh
	 * @创建时间: 2017-1-11下午04:01:53
	 * 
	 * @修改描述: 解决经度和纬度丢失精度问题
	 * @修改人: 刘波
	 * @修改时间: 2017-1-11下午04:01:53
	 * @param pageNum
	 * @param pageSize
	 * @return
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
				List<EmergencyExpert>  list = com.alibaba.fastjson.JSONObject.parseArray(js, EmergencyExpert.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
