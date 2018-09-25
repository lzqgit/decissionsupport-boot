package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: Shelter
 * @描述:避难场所实体类
 * @版本:
 * @创建日期: 2017-1-11下午02:07:25
 * @作者: liub
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本:
 * @修改日期: 2017-1-11下午02:07:25
 * @修改人: liub
 * @JDK: 1.6
 */
public class Shelter {

	/**
	 * String shelter_id 避难场所标识
	 */
	private String shelter_id;

	/**
	 * String shelter_name 避难场所名称
	 */
	private String shelter_name;

	/**
	 * String shelter_type 场所类型
	 */
	private String shelter_type;

	/**
	 * String district_id 所属行政区域标识ID
	 */
	private String district_id;

	/**
	 * String belong_org_name 所属单位名称
	 */
	private String belong_org_name;

	/**
	 * String area 面积（平方米）
	 */
	private String area;

	/**
	 * String galleryful 可容纳人数
	 */
	private String galleryful;

	/**
	 * String service_date 投入使用时间
	 */
	private String service_date;

	/**
	 * String design_limit_years 设计使用年限
	 */
	private String design_limit_years;

	/**
	 * String linkman_name 联系人姓名
	 */
	private String linkman_name;

	/**
	 * String LINKMAN_TEL 联系人电话
	 */
	private String linkman_tel;

	/**
	 * String LINKMAN_MOBILE 联系人移动电话
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

	public String getShelter_id() {
		return shelter_id;
	}

	public void setShelter_id(String shelter_id) {
		this.shelter_id = shelter_id;
	}

	public String getShelter_name() {
		return shelter_name;
	}

	public void setShelter_name(String shelter_name) {
		this.shelter_name = shelter_name;
	}

	public String getShelter_type() {
		return shelter_type;
	}

	public void setShelter_type(String shelter_type) {
		this.shelter_type = shelter_type;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getService_date() {
		return service_date;
	}

	public void setService_date(String service_date) {
		this.service_date = service_date;
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

	public String getGalleryful() {
		return galleryful;
	}

	public void setGalleryful(String galleryful) {
		this.galleryful = galleryful;
	}

	public String getDesign_limit_years() {
		return design_limit_years;
	}

	public void setDesign_limit_years(String design_limit_years) {
		this.design_limit_years = design_limit_years;
	}
}
