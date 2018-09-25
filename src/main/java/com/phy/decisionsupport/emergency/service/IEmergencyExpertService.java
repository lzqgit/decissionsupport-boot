package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.EmergencyExpert;
import com.phy.decisionsupport.utils.Page;

public interface IEmergencyExpertService {

	public void save(EmergencyExpert emergencyExpert);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
