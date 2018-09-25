package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.RescueSupply;
import com.phy.decisionsupport.utils.Page;

public interface IRescueSupplyService {
	
	public void save(RescueSupply rescueSupply);

	public Page getAllByPage(Integer pageNum, Integer pageSize);

}
