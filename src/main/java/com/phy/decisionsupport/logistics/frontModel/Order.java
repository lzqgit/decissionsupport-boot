package com.phy.decisionsupport.logistics.frontModel;
public class Order {
	private String id;
	
	/**
	 * 物流企业ID
	 */
	private String enterprise_id;
	
	/**
	 * 订单号
	 */
	private String order_no;

	/**
	 * 货单号
	 */
	private String invoice_no;
	
	/**
	 * 订单生产日期
	 */
	private String order_creation_date;
	
	/**
	 * 订单状态
	 */
	private String transaction_status;
	
	/**
	 * 物流企业
	 */
	private String enterprise_name;
	
	/**
	 * 创建人
	 */
	private String founder;
	
	/**
	 * 创建时间
	 */
	private String foundation_date;
	
	/**
	 * 修改人
	 */
	private String modifier;
	
	/**
	 * 修改时间
	 */
	private String modify_date;
	
	/**
	 * 逻辑删除
	 */
	private String logically_deleted;
	
	/**
	 * String lgt_legal_person_code  法人代码
	 */
	private String lgt_legal_person_code;
	
	/**
	 * String register_no  工商注册号
	 */
	private  String register_no;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEnterprise_id() {
		return enterprise_id;
	}

	public void setEnterprise_id(String enterprise_id) {
		this.enterprise_id = enterprise_id;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public String getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getOrder_creation_date() {
		return order_creation_date;
	}

	public void setOrder_creation_date(String order_creation_date) {
		this.order_creation_date = order_creation_date;
	}

	public String getTransaction_status() {
		return transaction_status;
	}

	public void setTransaction_status(String transaction_status) {
		this.transaction_status = transaction_status;
	}

	public String getEnterprise_name() {
		return enterprise_name;
	}

	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getFoundation_date() {
		return foundation_date;
	}

	public void setFoundation_date(String foundation_date) {
		this.foundation_date = foundation_date;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModify_date() {
		return modify_date;
	}

	public void setModify_date(String modify_date) {
		this.modify_date = modify_date;
	}

	public String getLogically_deleted() {
		return logically_deleted;
	}

	public void setLogically_deleted(String logically_deleted) {
		this.logically_deleted = logically_deleted;
	}

	public String getLgt_legal_person_code() {
		return lgt_legal_person_code;
	}

	public void setLgt_legal_person_code(String lgt_legal_person_code) {
		this.lgt_legal_person_code = lgt_legal_person_code;
	}

	public String getRegister_no() {
		return register_no;
	}

	public void setRegister_no(String register_no) {
		this.register_no = register_no;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id='" + id + '\'' +
				", enterprise_id='" + enterprise_id + '\'' +
				", order_no='" + order_no + '\'' +
				", invoice_no='" + invoice_no + '\'' +
				", order_creation_date='" + order_creation_date + '\'' +
				", transaction_status='" + transaction_status + '\'' +
				", enterprise_name='" + enterprise_name + '\'' +
				", founder='" + founder + '\'' +
				", foundation_date='" + foundation_date + '\'' +
				", modifier='" + modifier + '\'' +
				", modify_date='" + modify_date + '\'' +
				", logically_deleted='" + logically_deleted + '\'' +
				", lgt_legal_person_code='" + lgt_legal_person_code + '\'' +
				", register_no='" + register_no + '\'' +
				'}';
	}
}

