package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：Refuge
 * @描述：避难场所-实体类
 * @创建时间：2016-11-28下午05:26:28
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "refuge")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Refuge {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	/**
	 * 场所名称
	 */
	@Column(name = "shelter_Name")
	private String shelterName;
	
	/**
	 * 场所类型
	 */
	@Column(name = "shelter_Type")
	private String shelterType;
	
	/**
	 * 所属单位
	 */
	@Column(name = "shelter_Unit")
	private String shelterUnit;
	
	/**
	 * 面积
	 */
	@Column(name = "square")
	private String square;
	
	/**
	 * 可容纳人数
	 */
	@Column(name = "contain_Count")
	private Integer containCount;
	
	/**
	 * 投入使用时间
	 */
	@Column(name = "use_Date")
	private Date useDate;
	
	/**
	 * 设计使用年限
	 */
	@Column(name = "durable_Years")
	private String durableYears;
	
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
	 * 地址
	 */
	@Column(name = "address")
	private String address;
	
	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;

	public Refuge() {
		super();
	}

	public Refuge(String shelterName, String shelterType, String shelterUnit,
			String square, Integer containCount, Date useDate,
			String durableYears, String telName, String telNumber,
			String telPhone, String fax, String longitude, String latitude,
			String address, String remark) {
		super();
		this.shelterName = shelterName;
		this.shelterType = shelterType;
		this.shelterUnit = shelterUnit;
		this.square = square;
		this.containCount = containCount;
		this.useDate = useDate;
		this.durableYears = durableYears;
		this.telName = telName;
		this.telNumber = telNumber;
		this.telPhone = telPhone;
		this.fax = fax;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.remark = remark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShelterName() {
		return shelterName;
	}

	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}

	public String getShelterType() {
		return shelterType;
	}

	public void setShelterType(String shelterType) {
		this.shelterType = shelterType;
	}

	public String getShelterUnit() {
		return shelterUnit;
	}

	public void setShelterUnit(String shelterUnit) {
		this.shelterUnit = shelterUnit;
	}

	public String getSquare() {
		return square;
	}

	public void setSquare(String square) {
		this.square = square;
	}

	public Integer getContainCount() {
		return containCount;
	}

	public void setContainCount(Integer containCount) {
		this.containCount = containCount;
	}

	public Date getUseDate() {
		return useDate;
	}

	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}

	public String getDurableYears() {
		return durableYears;
	}

	public void setDurableYears(String durableYears) {
		this.durableYears = durableYears;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
