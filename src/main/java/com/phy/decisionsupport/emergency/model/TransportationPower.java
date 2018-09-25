package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @类名：TransportationPower
 * @描述：运输力量 - 实体类
 * @创建时间：2016-11-28下午05:27:48
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "transportation_power")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TransportationPower {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	/**
	 * 机构名称
	 */
	@Column(name = "transportation_Name")
	private String transportationName;
	
	/**
	 * 所属单位
	 */
	@Column(name = "transportation_Unit")
	private String transportationUnit;
	
	/**
	 * 单位级别
	 */
	@Column(name = "transportation_Level")
	private String transportationLevel;
	
	/**
	 * 客运能力（人）
	 */
	@Column(name = "passenger_Capacity")
	private Integer passengerCapacity;
	
	/**
	 * 货运能力（吨）
	 */
	@Column(name = "freight_Capacity")
	private Double freightCapacity;
	
	/**
	 * 联系人姓名
	 */
	@Column(name = "tel_Name")
	private String telName;
	
	/**
	 * 联系人电话
	 */
	@Column(name = "tel_Number")
	private String telNumber;
	
	/**
	 * 联系人手机
	 */
	@Column(name = "tel_Phone")
	private String telPhone;
	
	/**
	 * 传真
	 */
	@Column(name = "fax")
	private String fax;
	
	/**
	 * 运输设备类型
	 */
	@Column(name = "transportation_Type")
	private String transportationType;
	
	/**
	 * 经度
	 */
	@Column(name = "longitude")
	private String longitude;
	
	/**
	 * 纬度
	 */
	@Column(name = "latitude")
	private String latitude;
	
	/**
	 * 地址
	 */
	@Column(name = "address")
	private String address;
	
	/**
	 * 基本情况
	 */
	@Column(name = "basis_Info")
	private String basisInfo;
	
	/**
	 * 应急能力描述
	 */
	@Column(name = "emergency_Describe")
	private String emergencyDescribe;
	
	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;

	public TransportationPower() {
		super();
	}

	public TransportationPower(String transportationName,
			String transportationUnit, String transportationLevel,
			Integer passengerCapacity, Double freightCapacity, String telName,
			String telNumber, String telPhone, String fax,
			String transportationType, String longitude, String latitude,
			String address, String basisInfo, String emergencyDescribe,
			String remark) {
		super();
		this.transportationName = transportationName;
		this.transportationUnit = transportationUnit;
		this.transportationLevel = transportationLevel;
		this.passengerCapacity = passengerCapacity;
		this.freightCapacity = freightCapacity;
		this.telName = telName;
		this.telNumber = telNumber;
		this.telPhone = telPhone;
		this.fax = fax;
		this.transportationType = transportationType;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.basisInfo = basisInfo;
		this.emergencyDescribe = emergencyDescribe;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransportationName() {
		return transportationName;
	}

	public void setTransportationName(String transportationName) {
		this.transportationName = transportationName;
	}

	public String getTransportationUnit() {
		return transportationUnit;
	}

	public void setTransportationUnit(String transportationUnit) {
		this.transportationUnit = transportationUnit;
	}

	public String getTransportationLevel() {
		return transportationLevel;
	}

	public void setTransportationLevel(String transportationLevel) {
		this.transportationLevel = transportationLevel;
	}

	public Integer getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public Double getFreightCapacity() {
		return freightCapacity;
	}

	public void setFreightCapacity(Double freightCapacity) {
		this.freightCapacity = freightCapacity;
	}

	public String getTelName() {
		return telName;
	}

	public void setTelName(String telName) {
		this.telName = telName;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(String transportationType) {
		this.transportationType = transportationType;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBasisInfo() {
		return basisInfo;
	}

	public void setBasisInfo(String basisInfo) {
		this.basisInfo = basisInfo;
	}

	public String getEmergencyDescribe() {
		return emergencyDescribe;
	}

	public void setEmergencyDescribe(String emergencyDescribe) {
		this.emergencyDescribe = emergencyDescribe;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
