package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: RescueSupply
 * @描述: 应急救援物资的model
 * @版本:
 * @创建日期: 2017-3-9上午09:46:33
 * @作者: liuyh
 * @JDK: 1.6
 */
public class RescueSupply {

	/**
	 * 物资装备标志
	 */
	private String emermate_id;

	/**
	 * 物资装备名称
	 */
	private String emermate_name;

	/**
	 * 所属单位名称
	 */
	private String dept_name;

	/**
	 * 所属队伍名称
	 */
	private String team_name;

	/**
	 * 装备类型
	 */
	private String equip_material_type;

	/**
	 * 装备类别
	 */
	private String equip_material_category;

	/**
	 * 装备来源
	 */
	private String source_code;

	/**
	 * 行政区域名称
	 */
	private String full_name;

	/**
	 * 规格型号字段
	 */
	private String specification;

	/**
	 * 单价（元）
	 */
	private String price;

	/**
	 * 数量
	 */
	private String quanity;

	/**
	 * 计量单位字段不明
	 */
	private String unit_code;

	/**
	 * 用途
	 */
	private String use;

	/**
	 * 购买日期
	 */
	private String purc_date;

	/**
	 * 存放场所
	 */
	private String storage_place;

	/**
	 * 生产厂家类型
	 */
	private String manufacuturer;

	/**
	 * 出厂日期
	 */
	private String pabr_date;

	/**
	 * 使用年限
	 */
	private String useful_life;

	/**
	 * 资产编号
	 */
	private String asset_no;

	/**
	 * 联系人
	 */
	private String linkman_name;

	/**
	 * 联系方式
	 */
	private String link_mode;

	/**
	 * 经度
	 */
	private String longitude;

	/**
	 * 纬度
	 */
	private String latitude;

	public String getEmermate_id() {
		return emermate_id;
	}

	public void setEmermate_id(String emermate_id) {
		this.emermate_id = emermate_id;
	}

	public String getEmermate_name() {
		return emermate_name;
	}

	public void setEmermate_name(String emermate_name) {
		this.emermate_name = emermate_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getEquip_material_type() {
		return equip_material_type;
	}

	public void setEquip_material_type(String equip_material_type) {
		this.equip_material_type = equip_material_type;
	}

	public String getSource_code() {
		return source_code;
	}

	public void setSource_code(String source_code) {
		this.source_code = source_code;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuanity() {
		return quanity;
	}

	public void setQuanity(String quanity) {
		this.quanity = quanity;
	}

	public String getStorage_place() {
		return storage_place;
	}

	public void setStorage_place(String storage_place) {
		this.storage_place = storage_place;
	}

	public String getUseful_life() {
		return useful_life;
	}

	public void setUseful_life(String useful_life) {
		this.useful_life = useful_life;
	}

	public String getAsset_no() {
		return asset_no;
	}

	public void setAsset_no(String asset_no) {
		this.asset_no = asset_no;
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

	public String getUnit_code() {
		return unit_code;
	}

	public void setUnit_code(String unit_code) {
		this.unit_code = unit_code;
	}

	public String getManufacuturer() {
		return manufacuturer;
	}

	public void setManufacuturer(String manufacuturer) {
		this.manufacuturer = manufacuturer;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getEquip_material_category() {
		return equip_material_category;
	}

	public void setEquip_material_category(String equip_material_category) {
		this.equip_material_category = equip_material_category;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getPurc_date() {
		return purc_date;
	}

	public void setPurc_date(String purc_date) {
		this.purc_date = purc_date;
	}

	public String getPabr_date() {
		return pabr_date;
	}

	public void setPabr_date(String pabr_date) {
		this.pabr_date = pabr_date;
	}
}
