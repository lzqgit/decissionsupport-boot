package com.phy.decisionsupport.utils;

import java.util.List;

/**
 * @类名: Page
 * @描述: 该类用于实现后台分页
 * @版本: v1.0
 * @创建日期: 2016-5-16上午10:13:32
 * @作者: 刘波
 * @JDK: 1.6
 * 
 */
public class Page {

	/**
	 * List list 查询结果集
	 */
	@SuppressWarnings("rawtypes")
	private List list;
	/**
	 * int fullListSize 一共有多少条记录
	 */
	private int totalItems = 0;
	/**
	 * int pageNumber 当前第几页
	 */
	private int pageNumber = 1;

	/**
	 * int pageSize 一共多少页
	 */
	private int pageSize = 0;

	/**
	 * int objectsPerPage 每页多少条
	 */
	private int objectsPerPage = 10;
	
	/**
	 * int start 该页第一条记录的索引号
	 */
	private int start = 0;

	/**
	 * getPageSize
	 * 
	 * @描述: 获取页的大小
	 * @作者: 刘波
	 * @创建时间: 2016-5-16上午10:13:32
	 * 
	 * @return 页的大小
	 */

	public int getPageSize() {
		double pageSize = (double) this.totalItems
				/ (double) this.objectsPerPage;
		this.pageSize = (int) (pageSize > 0 & pageSize <= 1 ? 1
				: pageSize > (int) pageSize ? pageSize + 1 : pageSize);
		return this.pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @param objectsPerPage
	 *            the objectsPerPage to set
	 */
	public void setObjectsPerPage(int objectsPerPage) {
		this.objectsPerPage = objectsPerPage;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return this.list;
	}

	public int getObjectsPerPage() {
		return objectsPerPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	public Integer getFirstResult(){
		return start;
	}
	
}
