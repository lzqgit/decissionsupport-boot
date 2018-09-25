package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: RescueCounterPlan
 * @描述:应急救援预案的实体类
 * @版本: 
 * @创建日期: 2017-3-9上午09:48:10
 * @作者: liuyh
 * @JDK: 1.6
 */
public class RescueCounterPlan { 
	/**
	 * 预案标志
	 */	
	private String plan_id;

	/**
	 * 预案名称
	 */
	private String plan_name;

	/**
	 * 发布单位名称
	 */
	private String pub_dept_name;

	/**
	 * 预案备案编号
	 */
	private String plan_bak_number;

	/**
	 * 预案类别
	 */
	private String plan_type;

	/**
	 * 预案级别
	 */
	private String plan_grade;

	/**
	 * 签发人
	 */
	private String issuer_name;

	/**
	 * 适用领域
	 */
	private String apply_field;

	/**
	 * 发布文号
	 */
	private String publish_number;

	/**
	 * 主管单位
	 */
	private String safety_agencies_name;

	/**
	 * 发布日期
	 */
	private String publish_date;

	/**
	 * 修订日期
	 */
	private String revision_date;

	/**
	 * 危险目标
	 */
	private String danger_target;

	/**
	 * 编制依据
	 */
	private String compilation_basis;

	/**
	 * 相关事件
	 */
	private String link_event;

	/**
	 * 摘要
	 */
	private String main_content;

	/**
	 * 备注
	 */
	private String note;

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public String getPub_dept_name() {
		return pub_dept_name;
	}

	public void setPub_dept_name(String pub_dept_name) {
		this.pub_dept_name = pub_dept_name;
	}

	public String getPlan_bak_number() {
		return plan_bak_number;
	}

	public void setPlan_bak_number(String plan_bak_number) {
		this.plan_bak_number = plan_bak_number;
	}

	public String getPlan_type() {
		return plan_type;
	}

	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}

	public String getPlan_grade() {
		return plan_grade;
	}

	public void setPlan_grade(String plan_grade) {
		this.plan_grade = plan_grade;
	}

	public String getIssuer_name() {
		return issuer_name;
	}

	public void setIssuer_name(String issuer_name) {
		this.issuer_name = issuer_name;
	}

	public String getApply_field() {
		return apply_field;
	}

	public void setApply_field(String apply_field) {
		this.apply_field = apply_field;
	}

	public String getPublish_number() {
		return publish_number;
	}

	public void setPublish_number(String publish_number) {
		this.publish_number = publish_number;
	}

	public String getSafety_agencies_name() {
		return safety_agencies_name;
	}

	public void setSafety_agencies_name(String safety_agencies_name) {
		this.safety_agencies_name = safety_agencies_name;
	}
	
	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getRevision_date() {
		return revision_date;
	}

	public void setRevision_date(String revision_date) {
		this.revision_date = revision_date;
	}
	
	public String getDanger_target() {
		return danger_target;
	}

	public void setDanger_target(String danger_target) {
		this.danger_target = danger_target;
	}

	public String getCompilation_basis() {
		return compilation_basis;
	}

	public void setCompilation_basis(String compilation_basis) {
		this.compilation_basis = compilation_basis;
	}

	public String getLink_event() {
		return link_event;
	}

	public void setLink_event(String link_event) {
		this.link_event = link_event;
	}

	public String getMain_content() {
		return main_content;
	}

	public void setMain_content(String main_content) {
		this.main_content = main_content;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}	
}

