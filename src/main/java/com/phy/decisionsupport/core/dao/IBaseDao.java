package com.phy.decisionsupport.core.dao;

import com.phy.decisionsupport.utils.QueryCondition;

import java.util.List;
import java.util.Map;

public interface IBaseDao {
	
	/**
	 * getAll
	 * @描述: 获取所有
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:30:00
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:30:00
	 * @param clazz
	 * @return
	 */
	public <T> List<T> getAll(Class<T> clazz);
	
	/**
	 * getById
	 * @描述: 根据指定ID获取实体信息
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:30:03
	 * 
	 * @修改描述: TODO 请描述修改内容
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:30:03
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T getById(Class<T> clazz, Object id);
	
	/**
	 * getByIds
	 * @描述:根据ID数组获取实体列表信息
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:30:16
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:30:16
	 * @param clazz
	 * @param ids
	 * @return
	 */
	public <T> List<T> getByIds(Class<T> clazz, Object[] ids);
	/**
	 * getByJPQL
	 * @描述: 根据jpql语句获取实体列表信息
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:30:28
	 * 
	 * @修改描述: 无
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:30:28
	 * @param clazz
	 * @param queryStr
	 * @return
	 */
	public <T> List<T> getByJPQL(Class<T> clazz, String queryStr);
	
	/**
	 * getSingleResult
	 * @描述: TODO 描述这个方法的功能、适用条件及注意事项
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:30:41
	 * 
	 * @修改描述: TODO 请描述修改内容
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:30:41
	 * @param clazz
	 * @param queryConditions
	 * @return
	 */
	public Object getSingleResult(Class clazz, List<QueryCondition> queryConditions);
	
	/**
	 * refresh
	 * @描述: TODO 描述这个方法的功能、适用条件及注意事项
	 * @作者: liub
	 * @创建时间: 2016-12-16下午03:30:49
	 * 
	 * @修改描述: TODO 请描述修改内容
	 * @修改人: liub
	 * @修改时间: 2016-12-16下午03:30:49
	 * @param entity
	 * @param properties
	 */
	public void refresh(Object entity, Map<String, Object> properties);
	
    /**
     * save
     * @描述: TODO 描述这个方法的功能、适用条件及注意事项
     * @作者: liub
     * @创建时间: 2016-12-16下午03:31:06
     * 
     * @修改描述: TODO 请描述修改内容
     * @修改人: liub
     * @修改时间: 2016-12-16下午03:31:06
     * @param entity
     *  TODO 描述每个输入输出参数的作用、量化单位、值域、精度
     */
    public void save(Object entity);
    
    /**
     * batchSave
     * @描述: TODO 描述这个方法的功能、适用条件及注意事项
     * @作者: liub
     * @创建时间: 2016-12-16下午03:31:15
     * 
     * @修改描述: TODO 请描述修改内容
     * @修改人: liub
     * @修改时间: 2016-12-16下午03:31:15
     * @param entitys
     *  TODO 描述每个输入输出参数的作用、量化单位、值域、精度
     */
    public <T> void batchSave(List<T> entitys);
    
    /**
     * update
     * @描述: TODO 描述这个方法的功能、适用条件及注意事项
     * @作者: liub
     * @创建时间: 2016-12-16下午03:31:20
     * 
     * @修改描述: TODO 请描述修改内容
     * @修改人: liub
     * @修改时间: 2016-12-16下午03:31:20
     * @param entity
     */
    public void update(Object entity);
    /**
     * delete
     * @描述: TODO 描述这个方法的功能、适用条件及注意事项
     * @作者: liub
     * @创建时间: 2016-12-16下午03:31:29
     * 
     * @修改描述: TODO 请描述修改内容
     * @修改人: liub
     * @修改时间: 2016-12-16下午03:31:29
     * @param entity
     */
    public void delete(Object entity);

    /**
     * delete
     * @描述: TODO 描述这个方法的功能、适用条件及注意事项
     * @作者: liub
     * @创建时间: 2016-12-16下午03:31:40
     * 
     * @修改描述: TODO 请描述修改内容
     * @修改人: liub
     * @修改时间: 2016-12-16下午03:31:40
     * @param clazz
     * @param id
     */
    public <T> void delete(Class<T> clazz, Object id);

    /**
     * delete
     * @描述: TODO 描述这个方法的功能、适用条件及注意事项
     * @作者: liub
     * @创建时间: 2016-12-16下午03:31:49
     * 
     * @修改描述: TODO 请描述修改内容
     * @修改人: liub
     * @修改时间: 2016-12-16下午03:31:49
     * @param clazz
     * @param ids
     */
    public <T> void delete(Class<T> clazz, Object[] ids);

}
