package com.phy.decisionsupport.logistics.controller;

import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.logistics.frontModel.Order;
import com.phy.decisionsupport.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名: OrderController
 * @描述: 获取订单信息
 * @版本: 
 * @创建日期: 2017-3-8上午10:27:59
 * @作者: liuyh
 * @JDK: 1.6
 */
@Controller
public class OrderController extends BaseController {
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	@RequestMapping(value = "/Order/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	/**
	 * getAllStatistics
	 * @描述: 按月对园区总体订单数量以及各家物流企业订单数量进行统计
	 * @作者: liuyh
	 * @创建时间: 2017-3-8上午10:25:35
	 */
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/Order/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		// 当pageSize为null时，则返回所有数据
		Page pageData = findConditionByPage(null, null);
		Integer[] arrayTotal = new Integer[12];
		Map mapEnterprise = new HashMap();
		List allList = new ArrayList();
		List list = null;
		if (pageData != null) {
			list = pageData.getList();
		}
		int month;
		String tempEnterprise = null;
		Integer countEnterprise = null;
		Date date;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				//按月对园区总体订单数量进行统计
				Calendar cal = Calendar.getInstance();				
				String dateStr = ((Order)list.get(i)).getFoundation_date();
				//Long time = Long.parseLong(dateStr);
				date = StringHelper.toDate(dateStr);
				 cal.setTime(date);	
				month = cal.get(Calendar.MONTH);
				arrayTotal[month] = (arrayTotal[month] == null) ? 1 : arrayTotal[month] + 1;
				
				//各家物流企业订单数量进行统计
				tempEnterprise = ((Order) list.get(i)).getEnterprise_name();
				countEnterprise = (Integer) mapEnterprise.get(tempEnterprise);
				mapEnterprise.put(tempEnterprise, (countEnterprise == null) ? 1 : countEnterprise
						+ 1);
			}
		}
		allList.add(arrayTotal);
		allList.add(mapEnterprise);
		return getResult(allList, StateCode.SUCCESS_DEFAULT);
	}

	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("OrderInfoOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	/**
	 * findConditionByPage
	 * @描述: 按分页查找数据
	 * @作者: liuyh
	 * @创建时间: 2017-3-8上午10:05:28
	 */	 
	@SuppressWarnings("unchecked")
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		String result = getOutData();
		if(!(result==null||result.length()<=0)){
			JSONObject object = JSONObject.fromObject(result);
			if(object.get("code").toString().equals("0")){
				String strs = object.getString("data");
				JSONArray jsonArray = JSONArray.fromObject(strs);
				List<Order> rcs = (List<Order>) JSONArray
						.toCollection(jsonArray, Order.class);
				// 分页
				if (!rcs.isEmpty()) {
					page = PageUtil.toPage(rcs, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
