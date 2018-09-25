package com.phy.decisionsupport.accident.service;

import com.phy.decisionsupport.accident.model.Accident;
import com.phy.decisionsupport.utils.Page;

/**
 * @类名: IAccidentService
 * @描述: 历史事故service层接口
 * @版本: 
 * @创建日期: 2016-12-16下午03:22:16
 * @作者: liub
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本: 
 * @修改日期: 2016-12-16下午03:22:16
 * @修改人: liub
 * @JDK: 1.6
 */

public interface IAccidentService {

	/**
	 * save
	 * @描述: 添加历史事故（用于添加测试数据）
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:23:46
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:23:46
	 * @param accident
	 */
	 
	public void save(Accident accident);

	/**
	 * getAllByPage
	 * @描述: 分页获取所有的历史事故
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:23:49
	 * 
	 * @修改描述: TODO 请描述修改内容
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:23:49
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */ 
	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
