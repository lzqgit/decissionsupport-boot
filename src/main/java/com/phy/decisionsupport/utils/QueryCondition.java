/*
* @(#)QueryCondition.java 1.0 2014-12-1
*
* Copyright (c) 2013-2014 JiangXi Hangtian PoHuYun(JXHTPHY), Inc. 
* All Rights Reserved.
*
* This software is the confidential and proprietary information of JiangXi 
* Hangtian PoHuYun, Inc. ("Confidential Information"). You shall not
* disclose such Confidential Information and shall use it only in
* accordance with the terms of the license agreement you entered into
* with JXHTPHY.
*
* JXHTPHY MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
* THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
* TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
* PARTICULAR PURPOSE, OR NON-INFRINGEMENT. JXHTPHY SHALL NOT BE LIABLE FOR
* ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
* DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
*/
package com.phy.decisionsupport.utils;

/**
 * @类名: QueryCondition
 * @描述: 查询语句拼接
 * @版本: 
 * @创建日期: 2014-12-1下午02:05:11
 * @作者: gzs
 * @JDK: 1.6
 * 
 * @修改描述: 无
 * @版本: 
 * @修改日期: 2014-12-1下午02:05:11
 * @修改人: 01
 * @JDK: 1.6
 */
/*
 * 类的横向关系：
 */

public class QueryCondition {

	/** 等于 */
	public static final String EQ = "=";

	/** 不等于 */
	public static final String UNEQ = "!=";
	
	/** 小于 */
	public static final String LT = "<";

	/** 大于 */
	public static final String GT = ">";

	/** 小于等于 */
	public static final String LE = "<=";

	/** 大于等于 */
	public static final String GE = ">=";

	/** 相似 */
	public static final String LK = "like";
	
	/** IN */
	public static final String IN = "in";

	// 可以再扩展
	// ......

	/** 自定义jpql语句 */
	public static final String CUSTOM = "custom";

	/** 自定义复杂jpql语句 */
	public static final String COMPLEX = "complex";
	
	/** 属性名 */
	private String field;

	/** 操作符 */
	private String operator;

	/** 值 */
	private Object value;

	/** 自定义jpql语句 */
	private String customJPQL;

	/**
	 * 传入自定义语句
	 * 
	 * @param customJPQL
	 */
	public QueryCondition(String customJPQL) {
		this.customJPQL = customJPQL;
		this.operator = CUSTOM;
	}
	/**
	 * 传入自定义复制查询语句
	 * 
	 * @param customJPQL
	 */
	public QueryCondition(String complexJPQL,String complex){
		this.customJPQL = complexJPQL;
		this.operator = COMPLEX;
	}

	/**
	 * 
	 * @param field
	 *            属性名
	 * @param operator
	 *            操作符
	 * @param value
	 *            值 如果属性是日期类型,需将字符串格式为日期 如new SimpleDateFormat("yyyy-MM-dd
	 *            HH:mm:ss").parse("2012-03-23 10:22:22")
	 */
	public QueryCondition(String field, String operator, Object value) {
		this.field = field;
		this.operator = operator;
		this.value = value;
	}
	/**
	 * 
	 * @param field
	 *            属性名
	 * @param operator
	 *            操作符
	 * @param value
	 *            值 如果属性是日期类型,需将字符串格式为日期 如new SimpleDateFormat("yyyy-MM-dd
	 *            HH:mm:ss").parse("2012-03-23 10:22:22")
	 * @param customJPQL  自定义查询语句      
	 */
	public QueryCondition(String field, String operator, Object value,String compleJPQL) {
		this.field = field;
		this.operator = operator;
		this.value = value;
		this.customJPQL = compleJPQL;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getCustomJPQL() {
		return customJPQL;
	}

	public void setCustomJPQL(String customJPQL) {
		this.customJPQL = customJPQL;
	}

}
