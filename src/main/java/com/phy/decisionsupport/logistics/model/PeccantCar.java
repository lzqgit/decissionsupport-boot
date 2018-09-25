package com.phy.decisionsupport.logistics.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：PeccantCar
 * @描述：违章车辆  - 实体类
 * @创建时间：2016-11-28下午05:28:38
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "peccant_car")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class PeccantCar {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	
	/**
	 * 车辆ID
	 */
	@Column(name = "vehicle_ID")
	private Integer vehicleID;
	
	/**
	 * 企业ID
	 */
	@Column(name = "enterprise_ID")
	private Integer enterpriseID;
	
	/**
	 * 违章时间
	 */
	@Column(name = "violation_Date")
	private Date violationDate;
	
	/**
	 * 违章类型
	 */
	@Column(name = "violation_Type")
	private String violationType;
	
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

	public PeccantCar() {
		super();
	}

	public PeccantCar(Integer vehicleID, Integer enterpriseID,
			Date violationDate, String violationType, String creator,
			Date createDate, String reviser, Date reviseDate,
			String logisticsDelete) {
		super();
		this.vehicleID = vehicleID;
		this.enterpriseID = enterpriseID;
		this.violationDate = violationDate;
		this.violationType = violationType;
		this.creator = creator;
		this.createDate = createDate;
		this.reviser = reviser;
		this.reviseDate = reviseDate;
		this.logisticsDelete = logisticsDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(Integer vehicleID) {
		this.vehicleID = vehicleID;
	}

	public Integer getEnterpriseID() {
		return enterpriseID;
	}

	public void setEnterpriseID(Integer enterpriseID) {
		this.enterpriseID = enterpriseID;
	}

	public Date getViolationDate() {
		return violationDate;
	}

	public void setViolationDate(Date violationDate) {
		this.violationDate = violationDate;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
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
	
	
}
