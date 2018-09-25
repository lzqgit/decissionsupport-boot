package com.phy.decisionsupport.complaint.frontModel;

public class Complain {
		/**
		 * String guestbookext_id
		 * 留言投诉扩展表ID
		 */
		private String guestbookext_id;	
		/**
		 * String guestbookext_content
		 * 投诉、留言内容	
		 */
		private String guestbookext_content;
		/**
		 * String guestbookext_email
		 * 邮箱
		 */
		private String guestbookext_email;
		/**
		 * String guestbookext_phone
		 * 电话号码
		 */
		private String guestbookext_phone;
		/**
		 * String guestbookext_title
		 * 标题（主题）
		 */
		private String guestbookext_title;
		/**
		 * String guestbook_id
		 * 投诉留言实体ID
		 */
		private String guestbook_id;
		/**
		 * String guestbook
		 * 投诉留言
		 */
		private String guestbook;
		/**
		 * String guestbookext_contactaddress
		 * 投诉留言地址
		 */
		private String guestbookext_contactaddress;
		/**
		 * String guestbookext_landlinetel
		 * 固定电话
		 */
		private String guestbookext_landlinetel;
		/**
		 * String guestbookext_messageobj
		 * 投诉或者留言部门
		 */
		private String guestbookext_messageobj;
		/**
		 * String guestbookext_name
		 * 投诉、留言人姓名
		 */
		private String guestbookext_name;
		
		public String getGuestbookext_id() {
			return guestbookext_id;
		}
		public void setGuestbookext_id(String guestbookext_id) {
			this.guestbookext_id = guestbookext_id;
		}
		public String getGuestbookext_content() {
			return guestbookext_content;
		}
		public void setGuestbookext_content(String guestbookext_content) {
			this.guestbookext_content = guestbookext_content;
		}
		public String getGuestbookext_email() {
			return guestbookext_email;
		}
		public void setGuestbookext_email(String guestbookext_email) {
			this.guestbookext_email = guestbookext_email;
		}
		public String getGuestbookext_phone() {
			return guestbookext_phone;
		}
		public void setGuestbookext_phone(String guestbookext_phone) {
			this.guestbookext_phone = guestbookext_phone;
		}
		public String getGuestbookext_title() {
			return guestbookext_title;
		}
		public void setGuestbookext_title(String guestbookext_title) {
			this.guestbookext_title = guestbookext_title;
		}
		public String getGuestbook_id() {
			return guestbook_id;
		}
		public void setGuestbook_id(String guestbook_id) {
			this.guestbook_id = guestbook_id;
		}
		public String getGuestbook() {
			return guestbook;
		}
		public void setGuestbook(String guestbook) {
			this.guestbook = guestbook;
		}
		public String getGuestbookext_contactaddress() {
			return guestbookext_contactaddress;
		}
		public void setGuestbookext_contactaddress(String guestbookext_contactaddress) {
			this.guestbookext_contactaddress = guestbookext_contactaddress;
		}
		public String getGuestbookext_landlinetel() {
			return guestbookext_landlinetel;
		}
		public void setGuestbookext_landlinetel(String guestbookext_landlinetel) {
			this.guestbookext_landlinetel = guestbookext_landlinetel;
		}
		public String getGuestbookext_messageobj() {
			return guestbookext_messageobj;
		}
		public void setGuestbookext_messageobj(String guestbookext_messageobj) {
			this.guestbookext_messageobj = guestbookext_messageobj;
		}
		public String getGuestbookext_name() {
			return guestbookext_name;
		}
		public void setGuestbookext_name(String guestbookext_name) {
			this.guestbookext_name = guestbookext_name;
		}

	@Override
	public String toString() {
		return "Complain{" +
				"guestbookext_id='" + guestbookext_id + '\'' +
				", guestbookext_content='" + guestbookext_content + '\'' +
				", guestbookext_email='" + guestbookext_email + '\'' +
				", guestbookext_phone='" + guestbookext_phone + '\'' +
				", guestbookext_title='" + guestbookext_title + '\'' +
				", guestbook_id='" + guestbook_id + '\'' +
				", guestbook='" + guestbook + '\'' +
				", guestbookext_contactaddress='" + guestbookext_contactaddress + '\'' +
				", guestbookext_landlinetel='" + guestbookext_landlinetel + '\'' +
				", guestbookext_messageobj='" + guestbookext_messageobj + '\'' +
				", guestbookext_name='" + guestbookext_name + '\'' +
				'}';
	}
}
