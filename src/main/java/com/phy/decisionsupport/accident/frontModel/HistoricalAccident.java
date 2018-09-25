package com.phy.decisionsupport.accident.frontModel;

/**
 * @类名: HistoricalAccident
 * @描述: 历史事故实体类
 * @版本:
 * @创建日期: 2017-3-9上午10:12:51
 * @作者: liuyh
 * @JDK: 1.6
 */
public class HistoricalAccident {
	/**
	 * 事故id
	 */
	private String emeracc_id;
	/**
	 * 事故企业名称
	 */
	private String enterprise_name;

	/**
	 * 报警人
	 */
	private String alert_psn_name;

	/**
	 * 联系方式
	 */
	private String alert_psn_contact;

	/**
	 * 事故类型
	 */
	private String accident_type;

	/**
	 * 事故发生时间
	 */
	private String happen_time;

	/**
	 * 企业地址
	 */
	private String reg_address;

	/**
	 * 报警记录
	 */
	private String alert_content;
	/**
	 * 报警记录
	 */
	private String emeracc_status;

	public String getEmeracc_id() {
		return emeracc_id;
	}

	public void setEmeracc_id(String emeracc_id) {
		this.emeracc_id = emeracc_id;
	}

	public String getEnterprise_name() {
		return enterprise_name;
	}

	public void setEnterprise_name(String enterprise_name) {
		this.enterprise_name = enterprise_name;
	}

	public String getAlert_psn_name() {
		return alert_psn_name;
	}

	public void setAlert_psn_name(String alert_psn_name) {
		this.alert_psn_name = alert_psn_name;
	}

	public String getAlert_psn_contact() {
		return alert_psn_contact;
	}

	public void setAlert_psn_contact(String alert_psn_contact) {
		this.alert_psn_contact = alert_psn_contact;
	}

	public String getAccident_type() {
		return accident_type;
	}

	public void setAccident_type(String accident_type) {
		this.accident_type = accident_type;
	}

	public String getHappen_time() {
		return happen_time;
	}

	public void setHappen_time(String happen_time) {
		this.happen_time = happen_time;
	}

	public String getReg_address() {
		return reg_address;
	}

	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}

	public String getAlert_content() {
		return alert_content;
	}

	public void setAlert_content(String alert_content) {
		this.alert_content = alert_content;
	}

	public String getEmeracc_status() {
		return emeracc_status;
	}

	public void setEmeracc_status(String emeracc_status) {
		this.emeracc_status = emeracc_status;
	}
}
