package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.RescueCounterplan;
import com.phy.decisionsupport.utils.Page;

public interface IRescueCounterplanService {

	public void save(RescueCounterplan rescueCounterplan);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
