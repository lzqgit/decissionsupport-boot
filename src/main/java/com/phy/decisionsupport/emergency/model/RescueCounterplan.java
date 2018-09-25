package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：RescueCounterplan
 * @描述：救援预案 - 实体类
 * @创建时间：2016-11-28下午05:27:07
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "rescue_counterplan")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RescueCounterplan {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	/**
	 * 名字
	 */
	@Column(name = "planName")
	private String planName;

	/**
	 * 发布单位
	 */
	@Column(name = "releaseDep")
	private String releaseDep;

	/**
	 * 预案备案编号
	 */
	@Column(name = "planNo")
	private String planNo;

	/**
	 * 类型
	 */
	@Column(name = "planType")
	private String planType;

	/**
	 * 级别
	 */
	@Column(name = "planLevel")
	private String planLevel;

	/**
	 * 签发人
	 */
	@Column(name = "issuer")
	private String issuer;

	/**
	 * 适用领域
	 */
	@Column(name = "applicationArea")
	private String applicationArea;

	/**
	 * 发布文号
	 */
	@Column(name = "releaseNumber")
	private String releaseNumber;

	/**
	 * 主管单位
	 */
	@Column(name = "chargeDep")
	private String chargeDep;

	/**
	 * 发布日期
	 */
	@Column(name = "releaseDate")
	private Date releaseDate;

	/**
	 * 修订日期
	 */
	@Column(name = "reviseDate")
	private Date reviseDate;

	/**
	 * 危险目标
	 */
	@Column(name = "dangerTarget")
	private String dangerTarget;

	/**
	 * 编制依据
	 */
	@Column(name = "reference")
	private String reference;

	/**
	 * 相关事件
	 */
	@Column(name = "relevanceIncident")
	private String relevanceIncident;

	/**
	 * 摘要
	 */
	@Column(name = "planAbstract")
	private String planAbstract;

	/**
	 * 备注
	 */
	@Column(name = "notes")
	private String notes;

	/**
	 * 附件
	 */
	@Column(name = "attachments")
	private String attachments;

	public RescueCounterplan() {

	}

	public RescueCounterplan(String planName, String releaseDep, String planNo,
			String planType, String planLevel, String issuer,
			String applicationArea, String chargeDep, String DangerTarget,
			String attachments) {
		this.planName = planName;
		this.releaseDep = releaseDep;
		this.planNo = planNo;
		this.planType = planType;
		this.planLevel = planLevel;
		this.issuer = issuer;
		this.applicationArea = applicationArea;
		this.chargeDep = chargeDep;
		this.dangerTarget = DangerTarget;
		this.attachments = attachments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getReleaseDep() {
		return releaseDep;
	}

	public void setReleaseDep(String releaseDep) {
		this.releaseDep = releaseDep;
	}

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanLevel() {
		return planLevel;
	}

	public void setPlanLevel(String planLevel) {
		this.planLevel = planLevel;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public String getApplicationArea() {
		return applicationArea;
	}

	public void setApplicationArea(String applications) {
		this.applicationArea = applications;
	}

	public String getReleaseNumber() {
		return releaseNumber;
	}

	public void setReleaseNumber(String releaseNumber) {
		this.releaseNumber = releaseNumber;
	}

	public String getChargeDep() {
		return chargeDep;
	}

	public void setChargeDep(String chargeDep) {
		this.chargeDep = chargeDep;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getReviseDate() {
		return reviseDate;
	}

	public void setReviseDate(Date reviseDate) {
		this.reviseDate = reviseDate;
	}

	public String getDangerTarget() {
		return dangerTarget;
	}

	public void setDangerTarget(String dangerTarget) {
		this.dangerTarget = dangerTarget;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getRelevanceIncident() {
		return relevanceIncident;
	}

	public void setRelevanceIncident(String relevanceIncident) {
		this.relevanceIncident = relevanceIncident;
	}

	public String getPlanAbstract() {
		return planAbstract;
	}

	public void setPlanAbstract(String planAbstract) {
		this.planAbstract = planAbstract;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

}
