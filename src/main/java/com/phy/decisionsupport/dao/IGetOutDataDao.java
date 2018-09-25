package com.phy.decisionsupport.dao;

import java.util.List;
import java.util.Map;

public interface IGetOutDataDao {
	
	/**
	 * GetDataByClient  使用HttpClient方法
	 * @描述: 通过GET方法访问http接口并返回所有列表数据
	 * @作者: huangzhch
	 * @创建时间: 2016-12-19下午05:05:51
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-19下午05:05:51
	 * @param url   需要访问远程的URL
	 * @param params  访问远程连接参数
	 * @return
	 */
	public String GetDataByClient(String url, Map<String, Object> params);
	
	/**
	 * getComplaintInfoData
	 * @描述: 获取投诉信息数据
	 * @作者: huangzhch
	 * @创建时间: 2016-12-19下午05:11:18
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-19下午05:11:18
	 * @return
	 */
	public List<Map> getOutInfoData(String url, Map params);
}
