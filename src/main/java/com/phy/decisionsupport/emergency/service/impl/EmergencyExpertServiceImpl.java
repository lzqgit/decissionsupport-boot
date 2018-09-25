package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IEmergencyExpertDao;
import com.phy.decisionsupport.emergency.model.EmergencyExpert;
import com.phy.decisionsupport.emergency.service.IEmergencyExpertService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmergencyExpertServiceImpl implements IEmergencyExpertService {

	@Resource
	private IEmergencyExpertDao emergencyExpertDao;

	@Override
	public void save(EmergencyExpert emergencyExpert) {
		// TODO Auto-generated method stub
		emergencyExpertDao.save(emergencyExpert);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<EmergencyExpert> list = emergencyExpertDao
				.getAll(EmergencyExpert.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
