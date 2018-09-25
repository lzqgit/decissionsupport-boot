package com.phy.decisionsupport.emergency.service.impl;

import com.phy.decisionsupport.emergency.dao.IRescueCounterplanDao;
import com.phy.decisionsupport.emergency.model.RescueCounterplan;
import com.phy.decisionsupport.emergency.service.IRescueCounterplanService;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RescueCounterplanServiceImpl implements IRescueCounterplanService {

	@Resource
	private IRescueCounterplanDao rescueCounterplanDao;

	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;

		// TODO 调用接口获取数据
		List<RescueCounterplan> list = rescueCounterplanDao
				.getAll(RescueCounterplan.class);

		// 分页
		if (!list.isEmpty()) {
			page = PageUtil.toPage(list, pageNum, pageSize);
		}
		return page;
	}

	@Override
	public void save(RescueCounterplan rescueCounterplan) {
		rescueCounterplanDao.save(rescueCounterplan);
	}

}
