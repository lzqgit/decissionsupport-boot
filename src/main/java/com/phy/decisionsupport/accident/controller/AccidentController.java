package com.phy.decisionsupport.accident.controller;

import com.phy.decisionsupport.accident.frontModel.HistoricalAccident;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;

/**
 * @类名: AccidentController
 * @描述: 历史事故控制层
 * @版本: 
 * @创建日期: 2017-3-9上午10:21:59
 * @作者: liuyh
 * @JDK: 1.6
 */
@Controller
public class AccidentController extends BaseController {

	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");

	@RequestMapping(value = "/Accident/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
	    return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	//根据事故类型对事故发生次数进行统计
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/Accident/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		// 当pageSize为null时，则返回所有数据
		Page pageData = findConditionByPage(null, null);
		Map map = new HashMap();
		List list = null;
		if(pageData != null){
			list = pageData.getList();
		}
		String temp;
		if(list!= null){
			for(int i = 0; i < list.size(); i++){
				temp = ((HistoricalAccident)list.get(i)).getAccident_type();
				Integer count = (Integer)map.get(temp);
				map.put(temp, (count == null) ? 1 : count+1);
			}
		}
		return getResult(map, StateCode.SUCCESS_DEFAULT);
	} 
	/**
	 * getOutData
	 * @描述: 获取历史事故信息
	 * @作者: liuyh
	 * @创建时间: 2017-3-9上午10:19:45
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("HistoricalAccidentgetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * findConditionByPage
	 * @描述: 获取历史事故信息的分页信息
	 * @作者: liuyh
	 * @创建时间: 2017-3-9上午10:14:22
	 */
	@SuppressWarnings("unchecked")
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		String result = getOutData();
		//判断接口是否有数据
		if(!(result==null||result.length()<=0)){
			JSONObject object = JSONObject.fromObject(result);
			if(object.get("code").toString().equals("0")){
				String strs = object.getString("data");
				JSONArray jsonArray = JSONArray.fromObject(strs);
				List<HistoricalAccident> rcs = (List<HistoricalAccident>) JSONArray
						.toCollection(jsonArray, HistoricalAccident.class);
				// 分页
				if (!rcs.isEmpty()) {
					page = PageUtil.toPage(rcs, pageNum, pageSize);
				}
			}
		}
		return page;
	}	
}
