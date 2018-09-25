package com.phy.decisionsupport.logistics.service.impl;

import com.phy.decisionsupport.logistics.dao.ICarDao;
import com.phy.decisionsupport.logistics.model.Car;
import com.phy.decisionsupport.logistics.service.ICarService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

	@Resource
	private ICarDao carDao;

	@Override
	public void save(Car car) {
		// TODO Auto-generated method stub
		carDao.save(car);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<Car> list = carDao
				.getAll(Car.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
