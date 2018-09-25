package com.phy.decisionsupport.logistics.controller;

import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.logistics.frontModel.VehicleType;
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
 * @类名: CarController
 * @描述: 车辆类型统计
 * @版本: 
 * @创建日期: 2016-12-12下午05:24:56
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述: TODO 请描述修改内容
 * @版本: 
 * @修改日期: 2016-12-12下午05:24:56
 * @修改人: huangzhch
 * @JDK: 1.6
 */
@Controller
public class CarController extends BaseController {
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	@RequestMapping(value = "/Car/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	//根据车辆类型对园区危化品车辆进行统计
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@RequestMapping(value = "/Car/getStatistics")
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
		Integer curCount;
		if(list!= null){
			for(int i = 0; i < list.size(); i++){
				temp = ((VehicleType)list.get(i)).getVehicle_type();
				Integer count = (Integer)map.get(temp);
				map.put(temp, (count == null) ? 1 : count+1);
			}
		}
		return getResult(map, StateCode.SUCCESS_DEFAULT);
	}
	/**
	 * getOutData
	 * @描述: 获取车辆类型接口数据
	 * @作者: liuyh
	 * @创建时间: 2017-3-17下午03:49:29
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("vehicleTypegetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

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
				List<VehicleType> rcs = (List<VehicleType>) JSONArray
						.toCollection(jsonArray, VehicleType.class);
				// 分页
				if (!rcs.isEmpty()) {
					page = PageUtil.toPage(rcs, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
