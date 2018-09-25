package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @类名：MedicalInstitution
 * @描述：医疗机构 - 实体类
 * @创建时间：2016-11-28下午05:26:39
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "medical_institution")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class MedicalInstitution {

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
	 * 单位级别
	 */
	@Column(name = "unit_Level")
	private String unitLevel;

	/**
	 * 所属单位
	 */
	@Column(name = "institution_Unit")
	private String institutionUnit;

	/**
	 * 病床数
	 */
	@Column(name = "bed_Count")
	private Integer bedCount;

	/**
	 * 医生数
	 */
	@Column(name = "doctor_Count")
	private Integer doctorCount;

	/**
	 * 护士数
	 */
	@Column(name = "nurse_Count")
	private Integer nurseCount;

	/**
	 * 其他技术人数
	 */
	@Column(name = "other_Count")
	private Integer otherCount;

	/**
	 * 急救车辆数
	 */
	@Column(name = "ambulance_Count")
	private Integer ambulanceCount;

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
	 * 主要医疗设备
	 */
	@Column(name = "medical_Equip")
	private String medicalEquip;

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
	 * 主要特色
	 */
	@Column(name = "feature")
	private String feature;

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

	public MedicalInstitution() {
		super();
	}

	public MedicalInstitution(String institutionName, String unitLevel,
			String institutionUnit, Integer bedCount, Integer doctorCount,
			Integer nurseCount, Integer otherCount, Integer ambulanceCount,
			String telName, String telNumber, String telPhone, String fax,
			String longitude, String latitude, String medicalEquip,
			String address, String basisInfo, String feature,
			String emergencyDescribe, String remark) {
		super();
		this.institutionName = institutionName;
		this.unitLevel = unitLevel;
		this.institutionUnit = institutionUnit;
		this.bedCount = bedCount;
		this.doctorCount = doctorCount;
		this.nurseCount = nurseCount;
		this.otherCount = otherCount;
		this.ambulanceCount = ambulanceCount;
		this.telName = telName;
		this.telNumber = telNumber;
		this.telPhone = telPhone;
		this.fax = fax;
		this.medicalEquip = medicalEquip;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.basisInfo = basisInfo;
		this.feature = feature;
		this.emergencyDescribe = emergencyDescribe;
		this.remark = remark;
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

	public String getUnitLevel() {
		return unitLevel;
	}

	public void setUnitLevel(String unitLevel) {
		this.unitLevel = unitLevel;
	}

	public String getInstitutionUnit() {
		return institutionUnit;
	}

	public void setInstitutionUnit(String institutionUnit) {
		this.institutionUnit = institutionUnit;
	}

	public Integer getBedCount() {
		return bedCount;
	}

	public void setBedCount(Integer bedCount) {
		this.bedCount = bedCount;
	}

	public Integer getDoctorCount() {
		return doctorCount;
	}

	public void setDoctorCount(Integer doctorCount) {
		this.doctorCount = doctorCount;
	}

	public Integer getNurseCount() {
		return nurseCount;
	}

	public void setNurseCount(Integer nurseCount) {
		this.nurseCount = nurseCount;
	}

	public Integer getOtherCount() {
		return otherCount;
	}

	public void setOtherCount(Integer otherCount) {
		this.otherCount = otherCount;
	}

	public Integer getAmbulanceCount() {
		return ambulanceCount;
	}

	public void setAmbulanceCount(Integer ambulanceCount) {
		this.ambulanceCount = ambulanceCount;
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

	public String getMedicalEquip() {
		return medicalEquip;
	}

	public void setMedicalEquip(String medicalEquip) {
		this.medicalEquip = medicalEquip;
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

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
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
