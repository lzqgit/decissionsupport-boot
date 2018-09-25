package com.phy.decisionsupport.emergency.service;

import com.phy.decisionsupport.emergency.model.TransportationPower;
import com.phy.decisionsupport.utils.Page;

public interface ITransportationPowerService {

	public void save(TransportationPower transportationPower);

	public Page getAllByPage(Integer pageNum, Integer pageSize);
}
