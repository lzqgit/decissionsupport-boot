package com.phy.decisionsupport.accident.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：Accident
 * @描述：历史事故  - 实体类
 * @创建时间：2016-11-28下午05:29:17
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "accident")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Accident {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	/**
	 * 事故企业名称
	 */
	@Column(name = "accident_Enterprise_Name")
	private String accidentEnterpriseName;
	
	/**
	 * 报警人
	 */
	@Column(name = "crime_Reporter")
	private String crimeReporter;
	
	/**
	 * 联系方式
	 */
	@Column(name = "tel_Phone")
	private String telPhone;
	
	/**
	 * 事故类型
	 */
	@Column(name = "accident_Type")
	private String accidentType;
	
	/**
	 * 事故发生时间
	 */
	@Column(name = "accident_Date")
	private Date accidentDate;
	
	/**
	 * 企业地址
	 */
	@Column(name = "enterprise_Address")
	private String enterpriseAddress;
	
	/**
	 * 报警记录
	 */
	@Column(name = "police_Records")
	private String policeRecords;

	public Accident() {
		super();
	}

	public Accident(String accidentEnterpriseName, String crimeReporter,
			String telPhone, String accidentType, Date accidentDate,
			String enterpriseAddress, String policeRecords) {
		super();
		this.accidentEnterpriseName = accidentEnterpriseName;
		this.crimeReporter = crimeReporter;
		this.telPhone = telPhone;
		this.accidentType = accidentType;
		this.accidentDate = accidentDate;
		this.enterpriseAddress = enterpriseAddress;
		this.policeRecords = policeRecords;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccidentEnterpriseName() {
		return accidentEnterpriseName;
	}

	public void setAccidentEnterpriseName(String accidentEnterpriseName) {
		this.accidentEnterpriseName = accidentEnterpriseName;
	}

	public String getCrimeReporter() {
		return crimeReporter;
	}

	public void setCrimeReporter(String crimeReporter) {
		this.crimeReporter = crimeReporter;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	public Date getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getEnterpriseAddress() {
		return enterpriseAddress;
	}

	public void setEnterpriseAddress(String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}

	public String getPoliceRecords() {
		return policeRecords;
	}

	public void setPoliceRecords(String policeRecords) {
		this.policeRecords = policeRecords;
	}
	
	
}
