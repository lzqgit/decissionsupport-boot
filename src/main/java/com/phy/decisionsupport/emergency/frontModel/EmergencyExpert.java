package com.phy.decisionsupport.emergency.frontModel;

/**
 * @类名: EmergencyExpert
 * @描述: 应急专家实体类
 * @版本:
 * @创建日期: 2017-1-11下午03:55:21
 * @作者: liuyh
 * @JDK: 1.6
 */
public class EmergencyExpert {
	/**
	 * 应急专家标志
	 */
	private String expert_id;
	/**
	 * 姓名
	 */
	private String expert_name;

	/**
	 * 性别
	 */
	private String expert_sex;

	/**
	 * 专家类别
	 */
	private String expert_type;

	/**
	 * 健康状况
	 */
	private String health;

	/**
	 * 出生年月
	 */
	private String birth_month;

	/**
	 * 现任职务
	 */
	private String duty;

	/**
	 * 学历
	 */
	private String diploma_code;

	/**
	 * 专业
	 */
	private String major;

	/**
	 * 身份证号
	 */
	private String id_card;

	/**
	 * 手机号码
	 */
	private String mobile_no;

	/**
	 * 办公电话
	 */
	private String tel_no;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 单位地址
	 */
	private String work_address;

	/**
	 * 家庭地址
	 */
	private String home_address;

	/**
	 * 专家简介
	 */
	private String expert_resume;

	public String getExpert_id() {
		return expert_id;
	}

	public void setExpert_id(String expert_id) {
		this.expert_id = expert_id;
	}

	public String getExpert_name() {
		return expert_name;
	}

	public void setExpert_name(String expert_name) {
		this.expert_name = expert_name;
	}

	public String getExpert_sex() {
		return expert_sex;
	}

	public void setExpert_sex(String expert_sex) {
		this.expert_sex = expert_sex;
	}

	public String getExpert_type() {
		return expert_type;
	}

	public void setExpert_type(String expert_type) {
		this.expert_type = expert_type;
	}

	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getBirth_month() {
		return birth_month;
	}

	public void setBirth_month(String birth_month) {
		this.birth_month = birth_month;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getDiploma_code() {
		return diploma_code;
	}

	public void setDiploma_code(String diploma_code) {
		this.diploma_code = diploma_code;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getTel_no() {
		return tel_no;
	}

	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWork_address() {
		return work_address;
	}

	public void setWork_address(String work_address) {
		this.work_address = work_address;
	}

	public String getHome_address() {
		return home_address;
	}

	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}

	public String getExpert_resume() {
		return expert_resume;
	}

	public void setExpert_resume(String expert_resume) {
		this.expert_resume = expert_resume;
	}

	@Override
	public String toString() {
		return "EmergencyExpert{" +
				"expert_id='" + expert_id + '\'' +
				", expert_name='" + expert_name + '\'' +
				", expert_sex='" + expert_sex + '\'' +
				", expert_type='" + expert_type + '\'' +
				", health='" + health + '\'' +
				", birth_month='" + birth_month + '\'' +
				", duty='" + duty + '\'' +
				", diploma_code='" + diploma_code + '\'' +
				", major='" + major + '\'' +
				", id_card='" + id_card + '\'' +
				", mobile_no='" + mobile_no + '\'' +
				", tel_no='" + tel_no + '\'' +
				", email='" + email + '\'' +
				", work_address='" + work_address + '\'' +
				", home_address='" + home_address + '\'' +
				", expert_resume='" + expert_resume + '\'' +
				'}';
	}
}
