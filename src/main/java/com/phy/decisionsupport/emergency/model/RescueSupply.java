package com.phy.decisionsupport.emergency.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * @类名：RescueSupply
 * @描述：救援物资 - 实体类
 * @创建时间：2016-11-28下午05:27:22
 * @author liaow
 * @JDK：1.7
 */
@Entity
@Table(name = "rescue_supply")
@Cache(region = "all", usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RescueSupply {

	@Id
	@GeneratedValue
	@Column(name = "emermate_id")
	private Integer emermate_id;

	/**
	 * 物资装备名称
	 */
	@Column(name = "emermate_name")
	private String emermate_name;

	/**
	 * 所属单位
	 */
	@Column(name = "dept_name")
	private String dept_name;

	/**
	 * 所属队伍
	 */
	@Column(name = "team_name")
	private String team_name;

	/**
	 * 装备类型
	 */
	@Column(name = "equip_material_type")
	private String equip_material_type;

	/**
	 * 装备类别
	 */
	@Column(name = "equip_material_category")
	private String equip_material_category;

	/**
	 * 装备来源
	 */
	@Column(name = "source_code")
	private String source_code;

	/**
	 * 行政区域名称
	 */
	@Column(name = "full_name")
	private String full_name;

	/**
	 * 规格型号
	 */
	@Column(name = "specification")
	private String specification;

	/**
	 * 单价（元）
	 */
	@Column(name = "price")
	private String price;

	/**
	 * 数量
	 */
	@Column(name = "quanity")
	private Integer quanity;

	/**
	 * 计量单位
	 */
	@Column(name = "unit_code")
	private String unit_code;

	/**
	 * 用途
	 */
	@Column(name = "use")
	private String use;

	/**
	 * 购买日期
	 */
	@Column(name = "purc_date")
	private String purc_date;

	/**
	 * 存放场所
	 */
	@Column(name = "storage_place")
	private String storage_place;

	/**
	 * 生产厂家
	 */
	@Column(name = "manufacuturer")
	private String manufacuturer;

	/**
	 * 出厂日期
	 */
	@Column(name = "pabr_date")
	private Date pabr_date;

	/**
	 * 试用年限
	 */
	@Column(name = "useful_life")
	private String useful_life;

	/**
	 * 资产编号
	 */
	@Column(name = "asset_no")
	private String asset_no;

	/**
	 * 联系人
	 */
	@Column(name = "linkman_name")
	private String linkman_name;

	/**
	 * 联系方式
	 */
	@Column(name = "link_mode")
	private String link_mode;

	/**
	 * 经度
	 */
	@Column(name = "longitude")
	private String longitude;

	/**
	 * 纬度
	 */
	@Column(name = "latitude")
	private String latitude;

	public RescueSupply() {

	}

	public Integer getEmermate_id() {
		return emermate_id;
	}

	public void setEmermate_id(Integer emermate_id) {
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

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getEquip_material_type() {
		return equip_material_type;
	}

	public void setEquip_material_type(String equip_material_type) {
		this.equip_material_type = equip_material_type;
	}

	public String getEquip_material_category() {
		return equip_material_category;
	}

	public void setEquip_material_category(String equip_material_category) {
		this.equip_material_category = equip_material_category;
	}

	public String getSource_code() {
		return source_code;
	}

	public void setSource_code(String source_code) {
		this.source_code = source_code;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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

	public Integer getQuanity() {
		return quanity;
	}

	public void setQuanity(Integer quanity) {
		this.quanity = quanity;
	}

	public String getUnit_code() {
		return unit_code;
	}

	public void setUnit_code(String unit_code) {
		this.unit_code = unit_code;
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

	public String getStorage_place() {
		return storage_place;
	}

	public void setStorage_place(String storage_place) {
		this.storage_place = storage_place;
	}

	public String getManufacuturer() {
		return manufacuturer;
	}

	public void setManufacuturer(String manufacuturer) {
		this.manufacuturer = manufacuturer;
	}

	public Date getPabr_date() {
		return pabr_date;
	}

	public void setPabr_date(Date pabr_date) {
		this.pabr_date = pabr_date;
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

	@Override
	public String toString() {
		return "RescueSupply{" +
				"emermate_id=" + emermate_id +
				", emermate_name='" + emermate_name + '\'' +
				", dept_name='" + dept_name + '\'' +
				", team_name='" + team_name + '\'' +
				", equip_material_type='" + equip_material_type + '\'' +
				", equip_material_category='" + equip_material_category + '\'' +
				", source_code='" + source_code + '\'' +
				", full_name='" + full_name + '\'' +
				", specification='" + specification + '\'' +
				", price='" + price + '\'' +
				", quanity=" + quanity +
				", unit_code='" + unit_code + '\'' +
				", use='" + use + '\'' +
				", purc_date='" + purc_date + '\'' +
				", storage_place='" + storage_place + '\'' +
				", manufacuturer='" + manufacuturer + '\'' +
				", pabr_date=" + pabr_date +
				", useful_life='" + useful_life + '\'' +
				", asset_no='" + asset_no + '\'' +
				", linkman_name='" + linkman_name + '\'' +
				", link_mode='" + link_mode + '\'' +
				", longitude='" + longitude + '\'' +
				", latitude='" + latitude + '\'' +
				'}';
	}
}
