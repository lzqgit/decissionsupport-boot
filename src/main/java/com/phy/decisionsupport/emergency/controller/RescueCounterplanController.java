package com.phy.decisionsupport.emergency.controller;

import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.RescueCounterPlan;
import com.phy.decisionsupport.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名：RescueCounterplanController
 * @描述：应急救援预案 - Controller类
 * @创建时间：2016-11-29上午10:43:11
 * @author liaow
 * @JDK：1.7
 */
@Controller
public class RescueCounterplanController extends BaseController {
	
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
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
	@SuppressWarnings("unchecked")
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		String result = getOutData();
		if(!(result == null || result.length()<=0)){
			JSONObject object = JSONObject.fromObject(result);
			if(object.get("code").toString().equals("0")){
				String strs = object.getString("data");
				JSONArray jsonArray = JSONArray.fromObject(strs);
				List<RescueCounterPlan> rcs = (List<RescueCounterPlan>) JSONArray
						.toCollection(jsonArray, RescueCounterPlan.class);
				// 分页
				if (!rcs.isEmpty()) {
					page = PageUtil.toPage(rcs, pageNum, pageSize);
				}
			}
		}
		return page;
	}
	/**
	 * list
	 * 
	 * @描述: 分页获取预案信息数据
	 * @作者: liub
	 * @创建时间: 2017-1-11上午09:34:56
	 * 
	 * @修改描述:无
	 * @修改人: liub
	 * @修改时间: 2017-1-11上午09:34:56
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/RescueCounterplan/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		return getResult(findConditionByPage(pageNum, pageSize),
				StateCode.SUCCESS_DEFAULT);
	}

	/**
	 * getStatistics
	 * 
	 * @描述: 根据预案级别(1)或预案类别(2)或预案领域(3)统计
	 * @作者: liub
	 * @创建时间: 2017-1-11上午09:35:19
	 * 
	 * @修改描述:无
	 * @修改人: liub
	 * @修改时间: 2017-1-11上午09:35:19
	 * @param index
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/RescueCounterplan/getSingleStatistics")
	public @ResponseBody
    ResultObject getStatistics(int index) {
		// 当pageSize为null时，则返回所有数据
		Page pageData = findConditionByPage(null, null);
		Map map = new HashMap();
		List list = null;
		if (pageData != null) {
			list = pageData.getList();
		}
		String temp;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (index == 1) { // 预案级别统计
					temp = ((RescueCounterPlan) list.get(i)).getPlan_grade();
				} else if (index == 2) { // 预案类别统计
					temp = ((RescueCounterPlan) list.get(i)).getPlan_type();
				} else if (index == 3) { // 预案领域统计
					temp = ((RescueCounterPlan) list.get(i)).getApply_field();
				} else {
					break;
				}
				Integer count = (Integer) map.get(temp);
				map.put(temp, (count == null) ? 1 : count + 1);
			}
		}
		return getResult(map, StateCode.SUCCESS_DEFAULT);
	}

	
	/**
	 * getAllStatistics
	 * @描述: 统计预案三个类别
	 * @作者: liub
	 * @创建时间: 2017-1-11上午09:48:55
	 * 
	 * @修改描述: 無
	 * @修改人: liub
	 * @修改时间: 2017-1-11上午09:48:55
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/RescueCounterplan/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		Page page = findConditionByPage(null, null);
		Map mapLevel = new HashMap();
		Map mapType = new HashMap();
		Map mapArea = new HashMap();
		List allList = new ArrayList();
		List list = null;
		if (page != null) {
			list = page.getList();
		}
		String tempLevel = "";
		String tempType = "";
		String tempArea = "";
		Integer countLevel = null;
		Integer countType = null;
		Integer countArea = null;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// 预案级别统计
				tempLevel = ((RescueCounterPlan) list.get(i)).getPlan_grade();
				countLevel = (Integer) mapLevel.get(tempLevel);
				mapLevel.put(tempLevel, (countLevel == null) ? 1
						: countLevel + 1);
				// 预案类别统计
				tempType = ((RescueCounterPlan) list.get(i)).getPlan_type();
				countType = (Integer) mapType.get(tempType);
				mapType.put(tempType, (countType == null) ? 1 : countType + 1);
				// 预案领域统计
				tempArea = ((RescueCounterPlan) list.get(i)).getApply_field();
				countArea = (Integer) mapArea.get(tempArea);
				mapArea.put(tempArea, (countArea == null) ? 1 : countArea + 1);
			}
		}
		allList.add(mapLevel);
		allList.add(mapType);
		allList.add(mapArea);
		return getResult(allList, StateCode.SUCCESS_DEFAULT);
	}

	/**
	 * getOutData
	 * 
	 * @描述: 通过webservice获取应急预案信息数据
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
			url = new URL(res.getString("RescueCounterplangetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
