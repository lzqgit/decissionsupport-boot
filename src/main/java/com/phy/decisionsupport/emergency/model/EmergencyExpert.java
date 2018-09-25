package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：EmergencyExpert
 * @描述：应急专家-实体类
 * @创建时间：2016-11-28下午05:26:16
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "emergency_expert")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EmergencyExpert {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	/**
	 * 姓名
	 */
	@Column(name = "expert_Name")
	private String expertName;
	
	/**
	 * 性别
	 */
	@Column(name = "expert_Sex")
	private String expertSex; 
	
	/**
	 * 专家类别
	 */
	@Column(name = "expert_Type")
	private String expertType;
	
	/**
	 * 健康状况
	 */
	@Column(name = "health")
	private String health; 
	
	/**
	 * 出生年月
	 */
	@Column(name = "birth_Date")
	private Date birthDate;
	
	/**
	 * 现任职务
	 */
	@Column(name = "present_Duty")
	private String presentDuty; 
	
	/**
	 * 学历
	 */
	@Column(name = "education")
	private String education;
	
	/**
	 * 专业
	 */
	@Column(name = "major")
	private String major; 
	
	/**
	 * 身份证号
	 */
	@Column(name = "ID_Number")
	private String IDNumber; 
	
	/**
	 * 手机号码
	 */
	@Column(name = "phone")
	private String phone;
	
	/**
	 * 办公电话
	 */
	@Column(name = "tel_Number")
	private String telNumber;
	
	/**
	 * 电子邮箱
	 */
	@Column(name = "email")
	private String email;
	
	/**
	 * 单位地址
	 */
	@Column(name = "unit_Address")
	private String unitAddress;
	
	/**
	 * 家庭地址
	 */
	@Column(name = "home_Address")
	private String homeAddress; 
	
	/**
	 * 专家简介
	 */
	@Column(name = "expert_Info")
	private String expertInfo;

	public EmergencyExpert() {
		super();
	}

	public EmergencyExpert(String expertName, String expertSex,
			String expertType, String health, Date birthDate,
			String presentDuty, String education, String major,
			String iDNumber, String phone, String telNumber, String email,
			String unitAddress, String homeAddress, String expertInfo) {
		super();
		this.expertName = expertName;
		this.expertSex = expertSex;
		this.expertType = expertType;
		this.health = health;
		this.birthDate = birthDate;
		this.presentDuty = presentDuty;
		this.education = education;
		this.major = major;
		this.IDNumber = iDNumber;
		this.phone = phone;
		this.telNumber = telNumber;
		this.email = email;
		this.unitAddress = unitAddress;
		this.homeAddress = homeAddress;
		this.expertInfo = expertInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getExpertSex() {
		return expertSex;
	}

	public void setExpertSex(String expertSex) {
		this.expertSex = expertSex;
	}

	public String getExpertType() {
		return expertType;
	}

	public void setExpertType(String expertType) {
		this.expertType = expertType;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPresentDuty() {
		return presentDuty;
	}

	public void setPresentDuty(String presentDuty) {
		this.presentDuty = presentDuty;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnitAddress() {
		return unitAddress;
	}

	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getExpertInfo() {
		return expertInfo;
	}

	public void setExpertInfo(String expertInfo) {
		this.expertInfo = expertInfo;
	}
	
}
