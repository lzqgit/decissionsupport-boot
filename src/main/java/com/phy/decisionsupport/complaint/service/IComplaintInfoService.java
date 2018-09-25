package com.phy.decisionsupport.complaint.service;

import com.phy.decisionsupport.complaint.model.ComplaintInfo;
import com.phy.decisionsupport.utils.Page;

public interface IComplaintInfoService {

	
	/**
	 * save
	 * @描述: TODO 保存数据
	 * @作者: huangzhch
	 * @创建时间: 2016-12-20上午08:38:21
	 * 
	 * @修改描述: TODO 请描述修改内容
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-20上午08:38:21
	 * @param complaintInfo
	 */
	public void save(ComplaintInfo complaintInfo);

	/**
	 * getAllByPage
	 * @描述: TODO 得到分页数据(当pageNum==null && pageSize==null时返回所有数据)
	 * @作者: huangzhch
	 * @创建时间: 2016-12-20上午08:39:00
	 * 
	 * @修改描述: TODO 请描述修改内容
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-20上午08:39:00
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
