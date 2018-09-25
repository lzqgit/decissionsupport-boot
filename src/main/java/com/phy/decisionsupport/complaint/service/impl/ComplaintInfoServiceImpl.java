package com.phy.decisionsupport.complaint.service.impl;

import com.phy.decisionsupport.common.ReadProperties;
import com.phy.decisionsupport.complaint.dao.IComplaintInfoDao;
import com.phy.decisionsupport.complaint.model.ComplaintInfo;
import com.phy.decisionsupport.complaint.service.IComplaintInfoService;
import com.phy.decisionsupport.dao.IGetOutDataDao;
import com.phy.decisionsupport.utils.Page;
import com.phy.decisionsupport.utils.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComplaintInfoServiceImpl implements IComplaintInfoService{

	@Resource
	private IComplaintInfoDao complaintInfoDao;
	@Resource
	private IGetOutDataDao getOutDataDao;

	@Override
	public void save(ComplaintInfo complaintInfo) {
		complaintInfoDao.save(complaintInfo);
	}
	
	
	/**
	 * getAllByPage
	 * @描述: 得到分页数据(当pageNum==null && pageSize==null时返回所有数据)
	 * @作者: huangzhch
	 * @创建时间: 2016-12-20上午08:39:00
	 * 
	 * @修改描述: 无
	 * @修改人: huangzhch
	 * @修改时间: 2016-12-20上午08:39:00
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public Page getAllByPage(Integer pageNum, Integer pageSize) {
		Page page = null;
		//从配置文件outsideInterface.properties文件中读取url和参数
		List<String> keys = new ArrayList<String>();
		keys.add("gongZhongComplaintURL");
		keys.add("gongZhongComplaintURLParams");
		keys.add("qiYeComplaintURL");
		List<String> valueStr = ReadProperties.getProperties("/outsideInterface.properties", keys);
		if(valueStr != null && valueStr.size() == keys.size()){
			// 设置参数
			Map params = new HashMap();
			String[] str = valueStr.get(1).split(",");
			if (str.length > 0) {
				params.put(str[0], null); // 留言类型id
				params.put(str[1], null); // 留言类型是否为推荐
				params.put(str[2], null); // 留言类别是否审核
				params.put(str[3], true); // 留言类别是否排序
				params.put(str[4], 0);// 请求的当前页数
				params.put(str[5], 0);// 每页条数(当currentPage==0 && pageSize==0
										// 则返回所有数据(不分页))
			}
			// 获取公众信息服务系统——投诉信息
			List<Map> listGZ = getOutDataDao.getOutInfoData(
					valueStr.get(0), params);
			// 获取企业信息服务系统——投诉信息
			List<Map> listQY = getOutDataDao.getOutInfoData(
					valueStr.get(2), params);
			// 合并两个list并对其中的id进行重新编号
			List<Map> list = new ArrayList<Map>();
			if (listGZ != null && listGZ.size() != 0) {
				list.addAll(listGZ);
			}
			if (listQY != null && listQY.size() != 0) {
				list.addAll(listQY);
			}

			// 分页
			if (list != null && !list.isEmpty()) {
				page = PageUtil.toPage(list, pageNum, pageSize);
			}
		}
		return page;
	}
}
