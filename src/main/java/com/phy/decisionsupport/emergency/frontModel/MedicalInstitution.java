package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: MedicalInstitution
 * @描述: 医疗机构数据封装成实体类
 * @版本:
 * @创建日期: 2017-1-11上午10:30:37
 * @作者: liuyh
 * @JDK: 1.6
 */
public class MedicalInstitution {
	/**
	 * 机构名称标志
	 */
	private String mediorg_id;

	/**
	 * 机构名称
	 */
	private String mediorg_name;

	/**
	 * 单位级别
	 */
	private String org_level;

	/**
	 * 所属单位
	 */
	private String belong_org_name;

	/**
	 * 病床数
	 */
	private String sickbed_num;

	/**
	 * 医生数
	 */
	private String doctor_num;

	/**
	 * 护士数
	 */
	private String nurse_num;

	/**
	 * 其他技术人数
	 */
	private String other_tec_num;

	/**
	 * 急救车辆数
	 */
	private String ambulance_num;

	/**
	 * 联系人姓名
	 */
	private String linkman_name;

	/**
	 * 联系人电话
	 */
	private String linkman_mobile;

	/**
	 * 联系人手机
	 */
	private String linkman_tel;

	/**
	 * 传真
	 */
	private String fax_no;

	/**
	 * 经度
	 */
	private String longitude;

	public String getMediorg_id() {
		return mediorg_id;
	}

	public void setMediorg_id(String mediorg_id) {
		this.mediorg_id = mediorg_id;
	}

	public void setSickbed_num(String sickbed_num) {
		this.sickbed_num = sickbed_num;
	}

	public void setDoctor_num(String doctor_num) {
		this.doctor_num = doctor_num;
	}

	public void setNurse_num(String nurse_num) {
		this.nurse_num = nurse_num;
	}

	public void setOther_tec_num(String other_tec_num) {
		this.other_tec_num = other_tec_num;
	}

	public void setAmbulance_num(String ambulance_num) {
		this.ambulance_num = ambulance_num;
	}

	public String getMediorg_name() {
		return mediorg_name;
	}

	public void setMediorg_name(String mediorg_name) {
		this.mediorg_name = mediorg_name;
	}

	public String getOrg_level() {
		return org_level;
	}

	public void setOrg_level(String org_level) {
		this.org_level = org_level;
	}

	public String getBelong_org_name() {
		return belong_org_name;
	}

	public void setBelong_org_name(String belong_org_name) {
		this.belong_org_name = belong_org_name;
	}

	public String getLinkman_name() {
		return linkman_name;
	}

	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}

	public String getLinkman_mobile() {
		return linkman_mobile;
	}

	public void setLinkman_mobile(String linkman_mobile) {
		this.linkman_mobile = linkman_mobile;
	}

	public String getLinkman_tel() {
		return linkman_tel;
	}

	public void setLinkman_tel(String linkman_tel) {
		this.linkman_tel = linkman_tel;
	}

	public String getFax_no() {
		return fax_no;
	}

	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}

	public String getMedi_equip() {
		return medi_equip;
	}

	public void setMedi_equip(String medi_equip) {
		this.medi_equip = medi_equip;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getBase_info() {
		return base_info;
	}

	public void setBase_info(String base_info) {
		this.base_info = base_info;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 纬度
	 */
	private String latitude;

	/**
	 * 主要医疗设备
	 */
	private String medi_equip;

	/**
	 * 地址
	 */
	private String addr;

	/**
	 * 基本情况
	 */
	private String base_info;

	/**
	 * 主要特色
	 */
	private String feature;

	/**
	 * 应急能力描述
	 */
	private String ability;

	/**
	 * 备注
	 */
	private String remark;

	public String getSickbed_num() {
		return sickbed_num;
	}

	public String getDoctor_num() {
		return doctor_num;
	}

	public String getNurse_num() {
		return nurse_num;
	}

	public String getOther_tec_num() {
		return other_tec_num;
	}

	public String getAmbulance_num() {
		return ambulance_num;
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
}
