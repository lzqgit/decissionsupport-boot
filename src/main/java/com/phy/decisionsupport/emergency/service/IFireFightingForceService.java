package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.FireFightingForce;
import com.phy.decisionsupport.utils.Page;

public interface IFireFightingForceService {

	public void save(FireFightingForce fireFightingForce);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
