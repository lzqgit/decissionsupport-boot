package com.phy.decisionsupport.logistics.service;

import com.phy.decisionsupport.logistics.model.Order;
import com.phy.decisionsupport.utils.Page;

public interface IOrderService {

	public void save(Order order);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
