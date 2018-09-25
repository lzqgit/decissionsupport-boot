package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.ITransportationPowerDao;
import com.phy.decisionsupport.emergency.model.TransportationPower;
import com.phy.decisionsupport.emergency.service.ITransportationPowerService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TransportationPowerServiceImpl implements ITransportationPowerService{

	@Resource
	private ITransportationPowerDao transportationPowerDao;

	@Override
	public void save(TransportationPower transportationPower) {
		// TODO Auto-generated method stub
		transportationPowerDao.save(transportationPower);
	}

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<TransportationPower> list = transportationPowerDao
				.getAll(TransportationPower.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}
}
