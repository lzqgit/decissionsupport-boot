package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.MedicalInstitution;
import com.phy.decisionsupport.utils.Page;

public interface IMedicalInstitutionService {
	
	public void save(MedicalInstitution medicalInstitution);

	public Page getAllByPage(Integer pageNum, Integer pageSize);

}
