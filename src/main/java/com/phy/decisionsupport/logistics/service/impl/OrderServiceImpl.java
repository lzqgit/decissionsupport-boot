package com.phy.decisionsupport.logistics.service.impl;

import com.phy.decisionsupport.logistics.dao.IOrderDao;
import com.phy.decisionsupport.logistics.model.Order;
import com.phy.decisionsupport.logistics.service.IOrderService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Resource
	private IOrderDao orderDao;

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		orderDao.save(order);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<Order> list = orderDao
				.getAll(Order.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
