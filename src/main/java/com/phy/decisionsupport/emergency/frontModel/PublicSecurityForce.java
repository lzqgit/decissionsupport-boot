package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: PublicSecurityForce
 * @描述: 公安机构实体类
 * @版本:
 * @创建日期: 2017-1-11下午01:58:46
 * @作者: liuyh
 * @JDK: 1.6
 */
public class PublicSecurityForce {
	/**
	 * 机构标志
	 */
	private String pubsecorg_id;

	/**
	 * 机构名称
	 */
	private String pubsecorg_name;
	/**
	 * 机构代码
	 */
	private String pubsecorg_no;

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
	 * 应急车辆数
	 */
	private String rescue_car_num;

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
	private String pubsecorg_addr;

	/**
	 * 机构详细介绍
	 */
	private String pubsecorg_desc;

	public String getPubsecorg_name() {
		return pubsecorg_name;
	}

	public void setPubsecorg_name(String pubsecorg_name) {
		this.pubsecorg_name = pubsecorg_name;
	}

	public String getPubsecorg_no() {
		return pubsecorg_no;
	}

	public void setPubsecorg_no(String pubsecorg_no) {
		this.pubsecorg_no = pubsecorg_no;
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

	public String getPubsecorg_addr() {
		return pubsecorg_addr;
	}

	public void setPubsecorg_addr(String pubsecorg_addr) {
		this.pubsecorg_addr = pubsecorg_addr;
	}

	public String getPubsecorg_desc() {
		return pubsecorg_desc;
	}

	public void setPubsecorg_desc(String pubsecorg_desc) {
		this.pubsecorg_desc = pubsecorg_desc;
	}

	public String getPubsecorg_id() {
		return pubsecorg_id;
	}

	public void setPubsecorg_id(String pubsecorg_id) {
		this.pubsecorg_id = pubsecorg_id;
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
}
