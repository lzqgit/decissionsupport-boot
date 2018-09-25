package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IRescueSupplyDao;
import com.phy.decisionsupport.emergency.model.RescueSupply;
import com.phy.decisionsupport.emergency.service.IRescueSupplyService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RescueSupplyServiceImpl implements IRescueSupplyService {
	@Resource
	private IRescueSupplyDao rescueSupplyDao;

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<RescueSupply> list = rescueSupplyDao
				.getAll(RescueSupply.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}

	@Override
	public void save(RescueSupply rescueSupply) {
		rescueSupplyDao.save(rescueSupply);
	}

}
