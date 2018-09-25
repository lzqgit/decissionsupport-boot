package com.phy.decisionsupport.logistics.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：Order
 * @描述：订单 - 实体类
 * @创建时间：2016-11-28下午05:28:27
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "order_count")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Order {
	
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
	 * 订单号
	 */
	@Column(name = "order_Number")
	private String orderNumber;

	/**
	 * 货单号
	 */
	@Column(name = "cargo_Number")
	private String cargoNumber;
	
	/**
	 * 订单生产日期
	 */
	@Column(name = "order_Date")
	private Date orderDate;
	
	/**
	 * 订单状态
	 */
	@Column(name = "order_Status")
	private String orderStatus;
	
	/**
	 * 物流企业
	 */
	@Column(name = "logistics_Enterprise")
	private String logisticsEnterprise;
	
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
	 * 创建时间
	 */
	@Column(name = "revise_Date")
	private Date reviseDate;
	
	/**
	 * 逻辑删除
	 */
	@Column(name = "logistics_Delete")
	private String logisticsDelete;
	
	/**
	 * 备注
	 */
	@Column(name = "remark")
	private String remark;

	public Order() {
		super();
	}

	public Order(Integer enterpriseID, String orderNumber, String cargoNumber,
			Date orderDate, String orderStatus, String logisticsEnterprise,
			String creator, Date createDate, String reviser, Date reviseDate,
			String logisticsDelete, String remark) {
		super();
		this.enterpriseID = enterpriseID;
		this.orderNumber = orderNumber;
		this.cargoNumber = cargoNumber;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.logisticsEnterprise = logisticsEnterprise;
		this.creator = creator;
		this.createDate = createDate;
		this.reviser = reviser;
		this.reviseDate = reviseDate;
		this.logisticsDelete = logisticsDelete;
		this.remark = remark;
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCargoNumber() {
		return cargoNumber;
	}

	public void setCargoNumber(String cargoNumber) {
		this.cargoNumber = cargoNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getLogisticsEnterprise() {
		return logisticsEnterprise;
	}

	public void setLogisticsEnterprise(String logisticsEnterprise) {
		this.logisticsEnterprise = logisticsEnterprise;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
