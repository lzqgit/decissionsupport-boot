package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IMedicalInstitutionDao;
import com.phy.decisionsupport.emergency.model.MedicalInstitution;
import com.phy.decisionsupport.emergency.service.IMedicalInstitutionService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MedicalInstitutionServiceImpl implements
		IMedicalInstitutionService {
	
	@Resource
	private IMedicalInstitutionDao medicalInstitutionDao;

	@Override
	public void save(MedicalInstitution medicalInstitution) {
		// TODO Auto-generated method stub
		medicalInstitutionDao.save(medicalInstitution);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<MedicalInstitution> list = medicalInstitutionDao
				.getAll(MedicalInstitution.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}

}
