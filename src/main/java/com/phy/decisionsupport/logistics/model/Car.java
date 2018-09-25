package com.phy.decisionsupport.logistics.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;


/**
 * @类名: Car
 * @描述: 车辆类型——实体类
 * @版本: 
 * @创建日期: 2016-12-12下午05:10:08
 * @作者: huangzhch
 * @JDK: 1.6
 * 
 * @修改描述: TODO 请描述修改内容
 * @版本: 
 * @修改日期: 2016-12-12下午05:10:08
 * @修改人: huangzhch
 * @JDK: 1.6
 */
/*
* 类的横向关系：TODO 说明与其它类的关联、调用或依赖等关系。
*/
@Entity
@Table(name = "car")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Car {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	/**
	 * 企业ID
	 */
	@Column(name = "enterprise_ID")
	private Integer enterpriseID;
	
	/**
	 * 车辆编号
	 */
	@Column(name = "vehicle_Number")
	private String vehicleNumber;
	
	/**
	 * 车牌号
	 */
	@Column(name = "plate_Number")
	private String plateNumber;
	
	/**
	 * 车辆类型
	 */
	@Column(name = "vehicle_Level")
	private String vehicleLevel;
	
	/**
	 * 终端通讯状态
	 */
	@Column(name = "terminal_Status")
	private String terminalStatus;
	
	/**
	 * 移动APP通讯状态
	 */
	@Column(name = "APP_Status")
	private String APPStatus;
	
	/**
	 * 适用领域
	 */
	@Column(name = "application_Area")
	private String applicationArea;
	
	/**
	 * 车辆审核
	 */
	@Column(name = "vehicle_Verify")
	private String vehicleVerify;
	
	/**
	 * 车辆状态
	 */
	@Column(name = "vehicle_Status")
	private String vehicleStatus;
	
	/**
	 * 限制区域ID
	 */
	@Column(name = "limit_Area_ID")
	private String limitAreaID;
	
	/**
	 * 创建人
	 */
	@Column(name = "creator")
	private String creator;
	
	/**
	 * 创建时间
	 */
	@Column(name = "create_Date")
	private Date createDate;
	
	/**
	 * 修改人
	 */
	@Column(name = "reviser")
	private String reviser;
	
	/**
	 * 修改时间
	 */
	@Column(name = "revise_Date")
	private Date reviseDate;
	
	/**
	 * 逻辑删除
	 */
	@Column(name = "logistics_Delete")
	private String logisticsDelete;
	
	/**
	 * 终端通讯记录
	 */
	@Column(name = "terminal_Records")
	private String terminalRecords;
	
	/**
	 * APP通讯记录
	 */
	@Column(name = "APP_Records")
	private String APPRecords;

	public Car() {
		super();
	}

	public Car(Integer enterpriseID, String vehicleNumber, String plateNumber,
			String vehicleLevel, String terminalStatus, String aPPStatus,
			String applicationArea, String vehicleVerify, String vehicleStatus,
			String limitAreaID, String creator, Date createDate,
			String reviser, Date reviseDate, String logisticsDelete,
			String terminalRecords, String aPPRecords) {
		super();
		this.enterpriseID = enterpriseID;
		this.vehicleNumber = vehicleNumber;
		this.plateNumber = plateNumber;
		this.vehicleLevel = vehicleLevel;
		this.terminalStatus = terminalStatus;
		APPStatus = aPPStatus;
		this.applicationArea = applicationArea;
		this.vehicleVerify = vehicleVerify;
		this.vehicleStatus = vehicleStatus;
		this.limitAreaID = limitAreaID;
		this.creator = creator;
		this.createDate = createDate;
		this.reviser = reviser;
		this.reviseDate = reviseDate;
		this.logisticsDelete = logisticsDelete;
		this.terminalRecords = terminalRecords;
		APPRecords = aPPRecords;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(Integer enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getVehicleLevel() {
		return vehicleLevel;
	}

	public void setVehicleLevel(String vehicleLevel) {
		this.vehicleLevel = vehicleLevel;
	}

	public String getTerminalStatus() {
		return terminalStatus;
	}

	public void setTerminalStatus(String terminalStatus) {
		this.terminalStatus = terminalStatus;
	}

	public String getAPPStatus() {
		return APPStatus;
	}

	public void setAPPStatus(String aPPStatus) {
		APPStatus = aPPStatus;
	}

	public String getApplicationArea() {
		return applicationArea;
	}

	public void setApplicationArea(String applicationArea) {
		this.applicationArea = applicationArea;
	}

	public String getVehicleVerify() {
		return vehicleVerify;
	}

	public void setVehicleVerify(String vehicleVerify) {
		this.vehicleVerify = vehicleVerify;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public String getLimitAreaID() {
		return limitAreaID;
	}

	public void setLimitAreaID(String limitAreaID) {
		this.limitAreaID = limitAreaID;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getReviser() {
		return reviser;
	}

	public void setReviser(String reviser) {
		this.reviser = reviser;
	}

	public Date getReviseDate() {
		return reviseDate;
	}

	public void setReviseDate(Date reviseDate) {
		this.reviseDate = reviseDate;
	}

	public String getLogisticsDelete() {
		return logisticsDelete;
	}

	public void setLogisticsDelete(String logisticsDelete) {
		this.logisticsDelete = logisticsDelete;
	}

	public String getTerminalRecords() {
		return terminalRecords;
	}

	public void setTerminalRecords(String terminalRecords) {
		this.terminalRecords = terminalRecords;
	}

	public String getAPPRecords() {
		return APPRecords;
	}

	public void setAPPRecords(String aPPRecords) {
		APPRecords = aPPRecords;
	}
	
	
}
