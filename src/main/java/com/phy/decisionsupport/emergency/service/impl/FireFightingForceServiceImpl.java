package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IFireFightingForceDao;
import com.phy.decisionsupport.emergency.model.FireFightingForce;
import com.phy.decisionsupport.emergency.service.IFireFightingForceService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FireFightingForceServiceImpl implements IFireFightingForceService{

	@Resource
	private IFireFightingForceDao fireFightingForceDao;

	@Override
	public void save(FireFightingForce fireFightingForce) {
		// TODO Auto-generated method stub
		fireFightingForceDao.save(fireFightingForce);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<FireFightingForce> list = fireFightingForceDao
				.getAll(FireFightingForce.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
