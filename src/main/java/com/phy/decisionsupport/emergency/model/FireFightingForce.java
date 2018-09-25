package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @类名：FireFightingForce
 * @描述：消防力量-实体类
 * @创建时间：2016-11-28下午05:26:05
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "fire_fighting_force")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FireFightingForce {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	/**
	 * 机构名称
	 */
	@Column(name = "institution_Name")
	private String institutionName;

	/**
	 * 机构代码
	 */
	@Column(name = "institution_Num")
	private String institutionNum;

	/**
	 * 负责人姓名
	 */
	@Column(name = "responsible_Name")
	private String responsibleName;

	/**
	 * 负责人联系方式
	 */
	@Column(name = "responsible_Phone")
	private String responsiblePhone;

	/**
	 * 联系人姓名
	 */
	@Column(name = "tel_Name")
	private String telName;

	/**
	 * 联系人联系方式
	 */
	@Column(name = "tel_Phone")
	private String telPhone;

	/**
	 * 应急人员数
	 */
	@Column(name = "emergency_Count")
	private Integer emergencyCount;

	/**
	 * 救援车辆数
	 */
	@Column(name = "ambulance_Count")
	private Integer ambulanceCount;

	/**
	 * 救援车辆类型
	 */
	@Column(name = "ambulance_Type")
	private String ambulanceType;

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
	 * 机构详细地址
	 */
	@Column(name = "institution_Address")
	private String institutionAddress;

	/**
	 * 机构详细介绍
	 */
	@Column(name = "institution_Info")
	private String institutionInfo;

	public FireFightingForce() {
		super();
	}

	public FireFightingForce(String institutionName, String institutionNum,
			String responsibleName, String responsiblePhone, String telName,
			String telPhone, Integer emergencyCount, Integer ambulanceCount,
			String ambulanceType, String longitude, String latitude,
			String institutionAddress, String institutionInfo) {
		super();
		this.institutionName = institutionName;
		this.institutionNum = institutionNum;
		this.responsibleName = responsibleName;
		this.responsiblePhone = responsiblePhone;
		this.telName = telName;
		this.telPhone = telPhone;
		this.emergencyCount = emergencyCount;
		this.ambulanceCount = ambulanceCount;
		this.ambulanceType = ambulanceType;
		this.longitude = longitude;
		this.latitude = latitude;
		this.institutionAddress = institutionAddress;
		this.institutionInfo = institutionInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInstitutionNum() {
		return institutionNum;
	}

	public void setInstitutionNum(String institutionNum) {
		this.institutionNum = institutionNum;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getResponsiblePhone() {
		return responsiblePhone;
	}

	public void setResponsiblePhone(String responsiblePhone) {
		this.responsiblePhone = responsiblePhone;
	}

	public String getTelName() {
		return telName;
	}

	public void setTelName(String telName) {
		this.telName = telName;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public Integer getEmergencyCount() {
		return emergencyCount;
	}

	public void setEmergencyCount(Integer emergencyCount) {
		this.emergencyCount = emergencyCount;
	}

	public Integer getAmbulanceCount() {
		return ambulanceCount;
	}

	public void setAmbulanceCount(Integer ambulanceCount) {
		this.ambulanceCount = ambulanceCount;
	}

	public String getAmbulanceType() {
		return ambulanceType;
	}

	public void setAmbulanceType(String ambulanceType) {
		this.ambulanceType = ambulanceType;
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

	public String getInstitutionAddress() {
		return institutionAddress;
	}

	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}

	public String getInstitutionInfo() {
		return institutionInfo;
	}

	public void setInstitutionInfo(String institutionInfo) {
		this.institutionInfo = institutionInfo;
	}

}
