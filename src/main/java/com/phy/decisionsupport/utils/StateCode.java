package com.phy.decisionsupport.utils;

/**
 * @类名: StateCode
 * @描述: rest与前台交互的结果集
 * @版本:
 * @创建日期: 2016-5-10上午10:05:55
 * @作者: lizhq
 * @JDK: 1.6
 * 
 */
public class StateCode {
	/**
	 * String SUCCESS_DEFAULT 请求成功（默认状态码）
	 */
	public static final String SUCCESS_DEFAULT = "200";

	/**
	 * String ERROR_RQUEST 请求失败（默认状态码）
	 */
	public static final String ERROR_RQUEST_DEFAULT = "404";

	/**
	 * String ERROR_SERVER 服务器内部出错
	 */
	public static final String ERROR_SERVER_DEFAULT = "500";

	/**
	 * String SUCCESS_CREATE 请求创建资源成功
	 */
	public static final String SUCCESS_CREATE = "201";

	/**
	 * String ERROR_REQUEST 请求错误
	 */
	public static final String ERROR_REQUEST = "400";

	/**
	 * String ERROR_UNAUTHORIZED 无权操作
	 */
	public static final String ERROR_UNAUTHORIZED = "401";

	/**
	 * String UNAUTHORIZED_REDIRECT 重定向
	 */
	public static final String UNAUTHORIZED_REDIRECT = "301";
	/**
	 * String NOT_FOUND 未找到
	 */
	public static final String NOT_FOUND = "405";

	/**
	 * String HAS_EXIST 已经存在
	 */
	public static final String HAS_EXIST = "600";

	/**
	 * String NOT_EQUAL 不匹配
	 */
	public static final String NOT_EQUAL = "700";
	/**
	 * ERROR_IMPORT 导入文件有错
	 */
	public static final String ERROR_IMPORT = "407";

	/**
	 * String USER_HAS_BIND 用户已经绑定角色
	 */
	public static final String USER_HAS_BIND = "408";
	


}
