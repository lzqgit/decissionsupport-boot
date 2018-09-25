package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.PublicSecurityForce;
import com.phy.decisionsupport.utils.Page;

public interface IPublicSecurityForceService {
	
	public void save(PublicSecurityForce publicSecurityForce);

	public Page getAllByPage(Integer pageNum, Integer pageSize);

}
