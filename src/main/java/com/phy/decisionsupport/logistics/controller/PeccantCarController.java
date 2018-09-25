package com.phy.decisionsupport.logistics.controller;

import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.logistics.frontModel.VehicleViolation;
import com.phy.decisionsupport.utils.HttpClientUtils;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.List;
import java.util.PropertyResourceBundle;

/**
 * @类名: PeccantCarController
 * @描述: 车辆违章统计以及查询控制层
 * @版本: 
 * @创建日期: 2016-12-13下午03:13:07
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述:无
 * @版本: 
 * @修改日期: 2016-12-13下午03:13:07
 * @修改人: huangzhch
 * @JDK: 1.6
 */
@Controller
public class PeccantCarController extends BaseController {

	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	/**
	 * list
	 * @描述: 分页显示违章信息
	 * @作者: liub
	 * @创建时间: 2017-4-18上午10:45:43
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-4-18上午10:45:43
	 * @param pageNum  当前页
	 * @param pageSize 页大小
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/PeccantCar/list")
	public @ResponseBody
	List<VehicleViolation> list(Integer pageNum, Integer pageSize) {
		int starWith=(pageNum-1)*pageSize;
		int endWith=starWith+pageSize;
		Page page=null;
		String pagenow = pageNum.toString();
		String pagesize = pageSize.toString();
		String result = getOutData();
		//判断接口是否有数据
		if(!("".equals(result))){
			JSONObject object = JSONObject.fromObject(result);
			String strs = object.getString("data");
			JSONArray jsonArray = JSONArray.fromObject(strs);
			List<VehicleViolation> rcs = (List<VehicleViolation>) JSONArray
					.toCollection(jsonArray, VehicleViolation.class);
			page=PageUtil.toPage(rcs,pageNum,pageSize);
			rcs=page.getList();
			return rcs;
		}else{
			return null;			
		}
	}
	
	/**
	 * getAllStatistics
	 * @描述: 以物流公司为单位对物流车辆违章情况进行统计
	 * @作者: liub
	 * @创建时间: 2017-4-18上午10:46:38
	 * 
	 * @修改描述:无
	 * @修改人: liub
	 * @修改时间: 2017-4-18上午10:46:38
	 * @return
	 */
	@RequestMapping(value = "/PeccantCar/getStatistics")
	public @ResponseBody
	JSONArray getAllStatistics() {
		//判断接口是否有数据
		String result = getVehiclesViolationStatistic();
		if(!(result==null||result.length()<=0)){
			JSONObject object = JSONObject.fromObject(result);
			String strs = object.getString("data");
			JSONArray jsonArray = JSONArray.fromObject(strs);
			return jsonArray;
		}else{
			return null;			
		}
	}
	
    /**
     * getVehiclesViolationStatistic
     * @描述:通过webservice接口获取车辆违章统计数据
     * @作者: liub
     * @创建时间: 2017-4-18上午10:47:15
     * 
     * @修改描述: 添加注释
     * @修改人: liub
     * @修改时间: 2017-4-18上午10:47:15
     * @return
     */
    public String getVehiclesViolationStatistic(){
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("vehicleViolationStatisticgetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }

	/**
	 * getOutData
	 * @描述: 获取车辆违章信息接口数据
	 * @作者: liuyh
	 * @创建时间: 2017-3-17下午03:49:29
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("vehicleViolationgetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
