package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IRefugeDao;
import com.phy.decisionsupport.emergency.model.Refuge;
import com.phy.decisionsupport.emergency.service.IRefugeService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RefugeServiceImpl implements IRefugeService {

	@Resource
	private IRefugeDao refugeDao;

	@Override
	public void save(Refuge refuge) {
		// TODO Auto-generated method stub
		refugeDao.save(refuge);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<Refuge> list = refugeDao
				.getAll(Refuge.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
