package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.Transorg;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;

/**
 * @类名: TransportationController
 * @描述: 运输机构统计控制层
 * @版本:
 * @创建日期: 2016-12-12上午11:27:21
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本:
 * @修改日期: 2016-12-12上午11:27:21
 * @修改人: huangzhch
 * @JDK: 1.6
 */
@Controller
public class TransportationPowerController extends BaseController {

	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	/**
	 * list
	 * 
	 * @描述: 分页显示所有运输机构信息
	 * @作者: liub
	 * @创建时间: 2017-1-11下午03:34:59
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-1-11下午03:34:59
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/TransportationPower/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}

	/**
	 * getAllStatistics
	 * 
	 * @描述:根据运输机构客运能力和货运能力进行统计
	 * @作者: liub
	 * @创建时间: 2017-1-11下午03:35:30
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2017-1-11下午03:35:30
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/TransportationPower/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		// 当pageSize为null时，则返回所有数据

		Page pageData = findConditionByPage(null, null);
		Map mapPassenger = new HashMap();
		Map mapFreight = new HashMap();
		List allList = new ArrayList();
		List list = null;
		if (pageData != null) {
			list = pageData.getList();
		}
		String tempPassenger = "";
		String tempFreight = "";
		Integer countPassenger = null;
		Double countFreight = null;
		Integer curCount = null;
		Double curDouble = null;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				// 根据运输机构客运能力进行统计
				com.alibaba.fastjson.JSONObject jsonObj = (com.alibaba.fastjson.JSONObject) list.get(i);
				tempPassenger = jsonObj.getString("transorg_name");
				countPassenger = (Integer) mapPassenger.get(tempPassenger);
				curCount = Integer.valueOf(jsonObj.getString("passenger_trans"));
				mapPassenger.put(tempPassenger,
						(countPassenger == null) ? curCount : countPassenger
								+ curCount);
				// 根据运输机构货运能力进行统计
				tempFreight = jsonObj.getString("transorg_name");
				countFreight = (Double) mapFreight.get(tempFreight);
				curDouble = Double.valueOf(jsonObj.getString("goods_trans"));
				mapFreight.put(tempFreight, (countFreight == null) ? curDouble
						: countFreight + curDouble);
			}
		}
		if(mapPassenger!= null && mapPassenger.size()>6){
			ValueComparator vc = new ValueComparator(mapPassenger);
			TreeMap<String,Integer> sorted_map = new TreeMap<String, Integer>(vc);
			sorted_map.putAll(mapPassenger);
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
			allList.add(mapPassenger);
		}
		
		if(mapFreight != null && mapFreight.size()>6){
			ValueComparator vc = new ValueComparator(mapFreight);
			TreeMap<String,Integer> sorted_map = new TreeMap<String, Integer>(vc);
			sorted_map.putAll(mapFreight);
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
			allList.add(mapFreight);
		}
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
			com.alibaba.fastjson.JSONObject T = com.alibaba.fastjson.JSONObject.parseObject(result);
			if(T.get("code").toString().equals("0")){
				com.alibaba.fastjson.JSONArray arr = T.getJSONArray("data");
				String js = com.alibaba.fastjson.JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
				List<Transorg>  list = com.alibaba.fastjson.JSONObject.parseArray(js, Transorg.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
				System.out.println(page.getList().get(0));
			}
		}
		return page;
	}

	/**
	 * getOutData
	 * 
	 * @描述: 通过webservice获取运输机构信息数据
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
			url = new URL(res.getString("TransportationPowergetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
