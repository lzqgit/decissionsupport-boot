package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.Refuge;
import com.phy.decisionsupport.utils.Page;

public interface IRefugeService {

	public void save(Refuge refuge);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
