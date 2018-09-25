package com.phy.decisionsupport.logistics.service;

import com.phy.decisionsupport.logistics.model.Car;
import com.phy.decisionsupport.utils.Page;

public interface ICarService {

	public void save(Car car);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
