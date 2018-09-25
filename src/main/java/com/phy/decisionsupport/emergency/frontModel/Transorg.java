package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: Transorg
 * @描述：运输机构实体类
 * @版本:
 * @创建日期: 2017-1-11下午03:24:29
 * @作者: liub
 * @JDK: 1.6
 * 
 * @修改描述:无
 * @版本:
 * @修改日期: 2017-1-11下午03:24:29
 * @修改人: liub
 * @JDK: 1.6
 */
public class Transorg {

	/**
	 * String TRANSORG_ID 运输机构标识
	 */
	private String transorg_id;

	/**
	 * String TRANSORG_NAME 运输机构名称
	 */
	private String transorg_name;

	/**
	 * String DISTRICT_ID 所属行政区划标识
	 */
	private String district_id;

	/**
	 * String belong_org_name 所属单位名称
	 */
	private String belong_org_name;

	/**
	 * String BELONG_ORG_LEVEL 所属单位级别
	 */
	private String belong_org_level;

	/**
	 * String PASSENGER_TRANS 客运能力（人）
	 */
	private String passenger_trans;

	/**
	 * String GOODS_TRANS 货运能力（吨）
	 */
	private String goods_trans;

	/**
	 * String LINKMAN_NAME 联系人姓名
	 */
	private String linkman_name;

	/**
	 * String linkman_tel 联系人电话
	 */
	private String linkman_tel;

	/**
	 * String linkman_mobile 联系人移动电话
	 */
	private String linkman_mobile;

	/**
	 * String fax_no 传真
	 */
	private String fax_no;

	/**
	 * String addr 地址
	 */
	private String addr;

	/**
	 * String TRANS_EQUIP_TYPE 运输设备类型
	 */
	private String trans_equip_type;

	/**
	 * String BASE_INFO 基本情况
	 */
	private String base_info;

	/**
	 * String EMER_ABILITY 应急能力描述
	 */
	private String emer_ability;

	/**
	 * String REMARK 备注
	 */
	private String remark;

	/**
	 * String longitude 经度（度）
	 */
	private String longitude;

	/**
	 * String latitude 纬度（度）
	 */
	private String latitude;

	/**
	 * String enter_dept_id 录入部门标识
	 */
	private String enter_dept_id;

	/**
	 * String is_active 是否有效
	 */
	private String is_active;

	/**
	 * String CREATOR 创建人
	 */
	private String creator;

	/**
	 * String CREATE_TIME 创建日期
	 */
	private String create_time;

	/**
	 * String UPDATOR 修改人
	 */
	private String updator;

	/**
	 * String update_time 修改日期
	 */
	private String update_time;

	public String getTransorg_id() {
		return transorg_id;
	}

	public void setTransorg_id(String transorg_id) {
		this.transorg_id = transorg_id;
	}

	public String getTransorg_name() {
		return transorg_name;
	}

	public void setTransorg_name(String transorg_name) {
		this.transorg_name = transorg_name;
	}

	public String getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(String district_id) {
		this.district_id = district_id;
	}

	public String getBelong_org_name() {
		return belong_org_name;
	}

	public void setBelong_org_name(String belong_org_name) {
		this.belong_org_name = belong_org_name;
	}

	public String getBelong_org_level() {
		return belong_org_level;
	}

	public void setBelong_org_level(String belong_org_level) {
		this.belong_org_level = belong_org_level;
	}

	public String getLinkman_name() {
		return linkman_name;
	}

	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}

	public String getLinkman_tel() {
		return linkman_tel;
	}

	public void setLinkman_tel(String linkman_tel) {
		this.linkman_tel = linkman_tel;
	}

	public String getLinkman_mobile() {
		return linkman_mobile;
	}

	public void setLinkman_mobile(String linkman_mobile) {
		this.linkman_mobile = linkman_mobile;
	}

	public String getFax_no() {
		return fax_no;
	}

	public void setFax_no(String fax_no) {
		this.fax_no = fax_no;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTrans_equip_type() {
		return trans_equip_type;
	}

	public void setTrans_equip_type(String trans_equip_type) {
		this.trans_equip_type = trans_equip_type;
	}

	public String getBase_info() {
		return base_info;
	}

	public void setBase_info(String base_info) {
		this.base_info = base_info;
	}

	public String getEmer_ability() {
		return emer_ability;
	}

	public void setEmer_ability(String emer_ability) {
		this.emer_ability = emer_ability;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getEnter_dept_id() {
		return enter_dept_id;
	}

	public void setEnter_dept_id(String enter_dept_id) {
		this.enter_dept_id = enter_dept_id;
	}

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getPassenger_trans() {
		return passenger_trans;
	}

	public void setPassenger_trans(String passenger_trans) {
		this.passenger_trans = passenger_trans;
	}

	public String getGoods_trans() {
		return goods_trans;
	}

	public void setGoods_trans(String goods_trans) {
		this.goods_trans = goods_trans;
	}

	@Override
	public String toString() {
		return "Transorg{" +
				"transorg_id='" + transorg_id + '\'' +
				", transorg_name='" + transorg_name + '\'' +
				", district_id='" + district_id + '\'' +
				", belong_org_name='" + belong_org_name + '\'' +
				", belong_org_level='" + belong_org_level + '\'' +
				", passenger_trans='" + passenger_trans + '\'' +
				", goods_trans='" + goods_trans + '\'' +
				", linkman_name='" + linkman_name + '\'' +
				", linkman_tel='" + linkman_tel + '\'' +
				", linkman_mobile='" + linkman_mobile + '\'' +
				", fax_no='" + fax_no + '\'' +
				", addr='" + addr + '\'' +
				", trans_equip_type='" + trans_equip_type + '\'' +
				", base_info='" + base_info + '\'' +
				", emer_ability='" + emer_ability + '\'' +
				", remark='" + remark + '\'' +
				", longitude='" + longitude + '\'' +
				", latitude='" + latitude + '\'' +
				", enter_dept_id='" + enter_dept_id + '\'' +
				", is_active='" + is_active + '\'' +
				", creator='" + creator + '\'' +
				", create_time='" + create_time + '\'' +
				", updator='" + updator + '\'' +
				", update_time='" + update_time + '\'' +
				'}';
	}
}
