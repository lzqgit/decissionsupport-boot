package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IPublicSecurityForceDao;
import com.phy.decisionsupport.emergency.model.PublicSecurityForce;
import com.phy.decisionsupport.emergency.service.IPublicSecurityForceService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PublicSecurityForceServiceImpl implements IPublicSecurityForceService{
	
	@Resource
	private IPublicSecurityForceDao publicSecurityForceDao;

	@Override
	public void save(PublicSecurityForce publicSecurityForce) {
		// TODO Auto-generated method stub
		publicSecurityForceDao.save(publicSecurityForce);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<PublicSecurityForce> list = publicSecurityForceDao
				.getAll(PublicSecurityForce.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
