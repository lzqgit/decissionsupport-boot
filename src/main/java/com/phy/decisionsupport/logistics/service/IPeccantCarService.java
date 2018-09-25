package com.phy.decisionsupport.logistics.service;

import com.phy.decisionsupport.logistics.model.PeccantCar;
import com.phy.decisionsupport.utils.Page;

public interface IPeccantCarService {

	public void save(PeccantCar peccantCar);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
