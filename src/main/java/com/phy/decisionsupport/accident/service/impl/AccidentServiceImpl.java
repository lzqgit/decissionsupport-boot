package com.phy.decisionsupport.accident.service.impl;

import com.phy.decisionsupport.accident.dao.IAccidentDao;
import com.phy.decisionsupport.accident.model.Accident;
import com.phy.decisionsupport.accident.service.IAccidentService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @类名: AccidentServiceImpl
 * @描述: 历史事故service层实现
 * @版本: 
 * @创建日期: 2016-12-16下午03:25:37
 * @作者: liub
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本: 
 * @修改日期: 2016-12-16下午03:25:37
 * @修改人: liub
 * @JDK: 1.6
 */
@Service
public class AccidentServiceImpl implements IAccidentService{
	
	@Resource
	private IAccidentDao accidentDao;

	@Override
	public void save(Accident accident) {
		accidentDao.save(accident);
	}

	/* (non-Javadoc)
	 * @see com.phy.decisionsupport.accident.service.IAccidentService#getAllByPage(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		List<Accident> list = accidentDao
				.getAll(Accident.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
