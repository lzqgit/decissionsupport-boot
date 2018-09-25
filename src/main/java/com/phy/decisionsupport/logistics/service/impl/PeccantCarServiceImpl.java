package com.phy.decisionsupport.logistics.service.impl;

import com.phy.decisionsupport.logistics.dao.IPeccantCarDao;
import com.phy.decisionsupport.logistics.model.PeccantCar;
import com.phy.decisionsupport.logistics.service.IPeccantCarService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PeccantCarServiceImpl implements IPeccantCarService{

	@Resource
	private IPeccantCarDao peccantCarDao;

	@Override
	public void save(PeccantCar peccantCar) {
		// TODO Auto-generated method stub
		peccantCarDao.save(peccantCar);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<PeccantCar> list = peccantCarDao
				.getAll(PeccantCar.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
