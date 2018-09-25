package com.phy.decisionsupport.complaint.controller;

import com.phy.decisionsupport.complaint.frontModel.Complain;
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
 * @类名: ComplaintInfoController
 * @描述: 投诉信息控制层
 * @版本: 
 * @创建日期: 2016-12-14下午01:28:04
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述:无
 * @版本: 
 * @修改日期: 2016-12-14下午01:28:04
 * @修改人: huangzhch
 * @JDK: 1.6
 */

@Controller
public class ComplaintInfoController extends BaseController {
	PropertyResourceBundle res = (PropertyResourceBundle)PropertyResourceBundle.getBundle("outsideInterface");
	
	@RequestMapping(value = "/ComplaintInfo/list")
	public @ResponseBody
    ResultObject list(Integer pageNum, Integer pageSize) {
		Page pageData = findConditionByPage(pageNum, pageSize);
	    return getResult(pageData, StateCode.SUCCESS_DEFAULT);
	}

	
	/**
	 * getAllStatistics
	 * @描述: 根据投诉部门对投诉信息分类统计
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:27:12
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:27:12
	 * @return
	 */
	@RequestMapping(value = "/ComplaintInfo/getStatistics")
	public @ResponseBody
    ResultObject getAllStatistics() {
		ResultObject ro = MergeStaticData();
		return ro;
	}

    /**
     * MergeData
     * @描述: 将公众和企业的投诉信息合并
     * @作者: liuyh
     * @创建时间: 2017-3-20下午02:18:23
     */ 
     
    public JSONArray  MergeData(){
    	String gz = getPublicData();
    	String qy = getEispData();
    	JSONObject object;
    	JSONArray PArray;
    	JSONArray EArray;
    	JSONArray ja = new JSONArray();
    	if(!(gz==null||gz.length()<=0)){
        	object = JSONObject.fromObject(gz);
    		String strs = object.getString("data");
    		PArray = JSONArray.fromObject(strs); 
    		for(Object obj : PArray){
    			ja.add(obj);
    		}
    	}  	   	
    	if(!(qy==null||qy.length()<=0)){
        	object = JSONObject.fromObject(qy);
    		String strs = object.getString("data");
    		EArray = JSONArray.fromObject(strs); 
    		for(Object obj : EArray){
    			ja.add(obj);
    		}   		
    	}
    	System.out.println(ja.toString());
    	return ja;
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public ResultObject MergeStaticData(){
    	String gz = getPublicStaticData();
    	String qy = getEispStaticData();
    	Map map = new HashMap();
    	JSONObject object;
    	JSONArray jsonArray;
		String type;
		int count;
		int i;
    	if(!(gz==null||gz.length()<=0)){
        	object = JSONObject.fromObject(gz);
    		String strs = object.getString("data");
    		jsonArray = JSONArray.fromObject(strs);
    		for(i=0;i<jsonArray.size();i++){
    			type = jsonArray.getJSONObject(i).getString("guestbook_ctg_name");
    			count = Integer.parseInt(jsonArray.getJSONObject(i).get("num").toString());
    			map.put(type, count);
    		}
    	}  	   	
    	if(!(qy==null||qy.length()<=0)){
        	object = JSONObject.fromObject(qy);
    		String strs = object.getString("data");
    		jsonArray = JSONArray.fromObject(strs); 
    		for(i=0;i<jsonArray.size();i++){
    			type = jsonArray.getJSONObject(i).getString("guestbook_ctg_name");
    			if(map.containsKey(type)){
    				count = (Integer)jsonArray.getJSONObject(i).get("num") + (Integer)map.get(type);
    			}else{
    				count = (Integer)jsonArray.getJSONObject(i).get("num");
    			}
    			map.put(type, count);
    		}    		
    	}
    	return getResult(map, StateCode.SUCCESS_DEFAULT);
    }
	/**
	 * getPublicData
	 * @描述: 获取公众信息服务系统投诉信息
	 * @作者: liuyh
	 * @创建时间: 2017-3-20下午02:02:01
	 */	 
	public String getPublicData(){
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("publicComplaingetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * getPublicStaticData
	 * @描述: 获取公众信息服务系统投诉统计
	 * @作者: liuyh
	 * @创建时间: 2017-3-20下午02:44:01
	 */
	 
	public String getPublicStaticData(){
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("publicComplainStatisticsgetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	/**
	 * getEispData
	 * @描述: 获取企业投诉信息
	 * @作者: liuyh
	 * @创建时间: 2017-3-20下午02:13:39
	 */
	 
	public String getEispData(){
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("eispComplaingetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	/**
	 * getEispStaticData
	 * @描述: 获取企业投诉信息统计数据
	 * @作者: liuyh
	 * @创建时间: 2017-3-20下午02:38:43
	 */	 
	public String getEispStaticData(){
		URL url;
		String result = "";
		try {
			url = new URL(res.getString("eispComplainStatisticsgetOutDataURL"));
			result=HttpClientUtils.getResult(url.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}	
	@SuppressWarnings("unchecked")
	public Page findConditionByPage(Integer pageNum, Integer pageSize) {
		    Page page = null;
			JSONArray jsonArray = MergeData();
//			List<Complain> rcs = (List<Complain>) JSONArray
//					.toCollection(jsonArray, Complain.class);
		    List<Complain>  rcs = com.alibaba.fastjson.JSONObject.parseArray(jsonArray.toString(), Complain.class);
			System.out.println(rcs.toString());
			// 分页
			if (!rcs.isEmpty()) {
				page = PageUtil.toPage(rcs, pageNum, pageSize);
			}			
		return page;
	}	
}
