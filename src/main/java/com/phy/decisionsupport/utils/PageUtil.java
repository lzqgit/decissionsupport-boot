package com.phy.decisionsupport.utils;

import java.util.List;

/**
 * @类名: PageUtil
 * @描述: 一个设置分页工具类
 * @版本:
 * @创建日期: 2016-5-16上午10:00:15
 * @作者: liub
 * @JDK: 1.6
 * 
 * @修改描述:无
 * @版本:
 * @修改日期: 2016-5-16上午10:00:15
 * @修改人: liub
 * @JDK: 1.6
 */
public class PageUtil {

	/**
	 * toPage
	 * 
	 * @描述: 将一个list集合按指定的条件进行分页
	 * @作者: 刘波
	 * @创建时间: 2016-5-16上午10:00:15
	 * 
	 * @修改描述:
	 * @修改人: 刘波
	 * @修改时间: 2016-5-16上午10:00:15
	 * @param list
	 * @param pageNum
	 * @param pageMaxRows
	 * @return
	 */
	public static Page toPage(List<? extends Object> list, Integer pageNum,
                              Integer pageMaxRows) {
		// 当list集合为空时,返回page为null
		if (null == list || list.size() == 0) {
			return null;
		}
		int listSize = list.size();
		// 修正pageNum的值，最小为1
		if (pageNum == null || pageNum <= 0) {
			pageNum = 1;
		}
		//若行数为空，则默认一页显示所有数据
		if (pageMaxRows == null) {
			pageMaxRows = listSize;
		} else if (pageMaxRows < 1) {// 修正最大行记录值，最小为1
			pageMaxRows = 1;
		}
		Page page = new Page();
		int startIndex = (pageNum - 1) * pageMaxRows;
		int endIndex = 0;
		if (startIndex + pageMaxRows >= listSize) {
			endIndex = listSize;
		} else {
			endIndex = startIndex + pageMaxRows;
		}

		if (startIndex > listSize) {
			return null;
		}
		// 设置页号
		page.setObjectsPerPage(pageMaxRows);
		page.setPageNumber(pageNum);
		page.setTotalItems(listSize);
		page.setList(list.subList(startIndex, endIndex));
		return page;
	}

	/**
	 * toPage
	 * 
	 * @描述: 初始化分页
	 * @作者: 刘波
	 * @创建时间: 2016-5-16上午10:00:15
	 * @param list
	 *            数据
	 * @param pageNum
	 *            页数
	 * @param pageMaxRows
	 *            每页数量
	 * @param maxResult
	 *            总记录数
	 * @return page对象
	 */
	public static Page toPage(List<? extends Object> list, int pageNum,
                              int pageMaxRows, int maxResult) {
		// 修正pageNum的值，最小为1
		if (pageNum <= 0) {
			pageNum = 1;
		}
		// 修正最大行记录值，最小为1
		if (pageMaxRows < 1) {
			pageMaxRows = 1;
		}
		Page page = new Page();
		// 设置页号
		page.setObjectsPerPage(pageMaxRows);
		page.setPageNumber(pageNum);
		page.setTotalItems(maxResult);
		page.setList(list);

		return page;
	}
}
