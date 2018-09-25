package com.phy.decisionsupport.complaint.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

/**
 * @类名：complaintInfo
 * @描述：投诉信息 - 实体类
 * @创建时间：2016-11-28下午05:29:03
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "complaint_info")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ComplaintInfo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	/**
	 * 投诉人
	 */
	@Column(name = "complainter")
	private String complainter;
	
	/**
	 * 电子邮箱
	 */
	@Column(name = "email")
	private String email;
	
	/**
	 * 手机号码
	 */
	@Column(name = "tel_Phone")
	private String telPhone;
	
	/**
	 * 固定电话
	 */
	@Column(name = "tel_Number")
	private String telNumber;
	
	/**
	 * 投诉部门
	 */
	@Column(name = "complaint_Dep")
	private String complaintDep;
	
	/**
	 * 主题
	 */
	@Column(name = "title")
	private String title;
	
	/**
	 * 内容
	 */
	@Column(name = "content")
	private String content;
	
	/**
	 * 家庭地址
	 */
	@Column(name = "home_Address")
	private String homeAddress;

	public ComplaintInfo() {
		super();
	}

	public ComplaintInfo(String complainter, String email, String telPhone,
			String telNumber, String complaintDep, String title,
			String content, String homeAddress) {
		super();
		this.complainter = complainter;
		this.email = email;
		this.telPhone = telPhone;
		this.telNumber = telNumber;
		this.complaintDep = complaintDep;
		this.title = title;
		this.content = content;
		this.homeAddress = homeAddress;
	}

	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplainter() {
		return complainter;
	}

	public void setComplainter(String complainter) {
		this.complainter = complainter;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelPhone() {
		return telPhone;
	}

	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getComplaintDep() {
		return complaintDep;
	}

	public void setComplaintDep(String complaintDep) {
		this.complaintDep = complaintDep;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	
}
