package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: FireFightingForce
 * @描述: 消防机构实体类
 * @版本:
 * @创建日期: 2017-1-11下午03:09:55
 * @作者: liuyh
 * @JDK: 1.6
 */
public class FireFightingForce {

	/**
	 * 消防机构标志
	 */
	private String fireorg_id;

	/**
	 * 消防机构名称
	 */
	private String fireorg_name;

	/**
	 * 消防机构代码
	 */
	private String fireorg_no;

	/**
	 * 负责人姓名
	 */
	private String principal_name;

	/**
	 * 负责人联系方式
	 */
	private String principal_link_mode;

	/**
	 * 联系人姓名
	 */
	private String linkman_name;

	/**
	 * 联系人联系方式
	 */
	private String link_mode;

	/**
	 * 应急人员数
	 */
	private String emer_psn_num;

	/**
	 * 救援车辆数
	 */
	private String rescue_car_num;

	/**
	 * 救援车辆类型
	 */
	private String rescue_car_type;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

	/**
	 * 机构详细地址
	 */
	private String fireorg_addr;

	/**
	 * 机构详细介绍
	 */
	private String fireorg_desc;

	public String getFireorg_id() {
		return fireorg_id;
	}

	public void setFireorg_id(String fireorg_id) {
		this.fireorg_id = fireorg_id;
	}

	public String getFireorg_name() {
		return fireorg_name;
	}

	public void setFireorg_name(String fireorg_name) {
		this.fireorg_name = fireorg_name;
	}

	public String getFireorg_no() {
		return fireorg_no;
	}

	public void setFireorg_no(String fireorg_no) {
		this.fireorg_no = fireorg_no;
	}

	public String getPrincipal_name() {
		return principal_name;
	}

	public void setPrincipal_name(String principal_name) {
		this.principal_name = principal_name;
	}

	public String getPrincipal_link_mode() {
		return principal_link_mode;
	}

	public void setPrincipal_link_mode(String principal_link_mode) {
		this.principal_link_mode = principal_link_mode;
	}

	public String getLinkman_name() {
		return linkman_name;
	}

	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}

	public String getLink_mode() {
		return link_mode;
	}

	public void setLink_mode(String link_mode) {
		this.link_mode = link_mode;
	}

	public String getEmer_psn_num() {
		return emer_psn_num;
	}

	public void setEmer_psn_num(String emer_psn_num) {
		this.emer_psn_num = emer_psn_num;
	}

	public String getRescue_car_num() {
		return rescue_car_num;
	}

	public void setRescue_car_num(String rescue_car_num) {
		this.rescue_car_num = rescue_car_num;
	}

	public String getRescue_car_type() {
		return rescue_car_type;
	}

	public void setRescue_car_type(String rescue_car_type) {
		this.rescue_car_type = rescue_car_type;
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

	public String getFireorg_addr() {
		return fireorg_addr;
	}

	public void setFireorg_addr(String fireorg_addr) {
		this.fireorg_addr = fireorg_addr;
	}

	public String getFireorg_desc() {
		return fireorg_desc;
	}

	public void setFireorg_desc(String fireorg_desc) {
		this.fireorg_desc = fireorg_desc;
	}

}
