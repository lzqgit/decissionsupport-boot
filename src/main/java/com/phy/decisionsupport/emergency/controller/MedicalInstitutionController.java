package com.phy.decisionsupport.emergency.controller;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.phy.decisionsupport.core.controller.BaseController;
import com.phy.decisionsupport.emergency.frontModel.MedicalInstitution;
import com.phy.decisionsupport.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URL;
import java.util.*;


/**
 * @类名: MedicalInstitutionController
 * @描述: 从平台获取医疗机构的数据并处理返回到前台界面
 * @版本: 
 * @创建日期: 2016-12-8上午11:18:24
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述: TODO 请描述修改内容
 * @版本: 
 * @修改日期: 2016-12-8上午11:18:24
 * @修改人: huangzhch
 * @JDK: 1.6
 */
@Controller
public class MedicalInstitutionController extends BaseController {
	
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	/**
	 * list
	 * @描述: 返回分页列表数据
	 * @作者: liuyh
	 * @创建时间: 2017-1-11上午11:15:03
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11上午11:15:03
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * 
	 */ 
	 
	@RequestMapping(value = "/MedicalInstitution/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
		return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}
	//统计医疗机构两个类别
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/MedicalInstitution/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		// 当pageSize为null时，则返回所有数据
		Page pageData = findConditionByPage(null, null);
		Map mapLevel = new HashMap();
		Map mapBed = new HashMap();
		List allList = new ArrayList();
		List list = null;
		if(pageData != null){
			list = pageData.getList();
		}
		String tempLevel = "";
		String tempBed = "";
		Integer countLevel = null;
		Integer countBed = null;
		Integer curCount = null;
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				//根据医疗机构级别对医疗机构的组成进行统计
				com.alibaba.fastjson.JSONObject jsonObj = (com.alibaba.fastjson.JSONObject) list.get(i);
				tempLevel = jsonObj.getString("org_level");
				countLevel = (Integer) mapLevel.get(tempLevel);
				mapLevel.put(tempLevel, (countLevel == null) ? 1
						: countLevel + 1);
				//根据医疗机构名称对医疗机构床位进行统计
				tempBed = jsonObj.getString("mediorg_name");
				curCount =  Integer.valueOf(jsonObj.getString("sickbed_num"));
				countBed = (Integer) mapBed.get(tempBed);
				mapBed.put(tempBed, (countBed == null) ? curCount : countBed + curCount);
			}
		}
		allList.add(mapLevel);
		//如果类别多余6类，剩下的类都统一放在其他类里面
		if(mapBed!=null && mapBed.size()>6){
			ValueComparator vc = new ValueComparator(mapBed);
			TreeMap<String,Integer> sorted_map = new TreeMap<String, Integer>(vc);
			sorted_map.putAll(mapBed);
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
				}
			}
			newLinkedMap.put("其他", count);
			allList.add(newLinkedMap);
			return getResult(allList, StateCode.SUCCESS_DEFAULT);
		}else{
			allList.add(mapBed);
			return getResult(allList, StateCode.SUCCESS_DEFAULT);
		}
	}

	/**
	 * getOutData
	 * @描述: 获取平台医疗机构数据
	 * @作者: liuyh
	 * @创建时间: 2017-1-11上午11:05:39
	 * 
	 * @修改描述: 无
	 * @修改人: liuyh
	 * @修改时间: 2017-1-11上午11:05:39
	 * @return
	 *  
	 */
	public String getOutData() {
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("MedicalInstitutiongetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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
		if(!(result==null||result.length()<=0)){
			com.alibaba.fastjson.JSONObject T = com.alibaba.fastjson.JSONObject.parseObject(result);
			if(T.get("code").toString().equals("0")){
				com.alibaba.fastjson.JSONArray arr = T.getJSONArray("data");
				String js = com.alibaba.fastjson.JSONObject.toJSONString(arr, SerializerFeature.WriteClassName);
				List<MedicalInstitution>  list = com.alibaba.fastjson.JSONObject.parseArray(js, MedicalInstitution.class);//把字符串转换成集合
				if(!list.isEmpty()){
					page = PageUtil.toPage(list, pageNum, pageSize);
				}
			}
		}
		return page;
	}
}
