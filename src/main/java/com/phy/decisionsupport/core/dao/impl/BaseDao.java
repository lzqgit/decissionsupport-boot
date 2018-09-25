package com.phy.decisionsupport.core.dao.impl;

import com.phy.decisionsupport.core.dao.IBaseDao;
import com.phy.decisionsupport.utils.QueryCondition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
@Transactional(readOnly = true, propagation=Propagation.REQUIRED)
public class BaseDao implements IBaseDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 根据查询条件获取Query
	 * 
	 * @param clazz
	 * @param queryConditions
	 * @param orderBy
	 * @param isQueryTotal
	 *            是否查询记录总数, true 则查询记录总数
	 * @return
	 */
	private Query getQuery(Class clazz, List<QueryCondition> queryConditions,
			String orderBy, boolean isQueryTotal) {
		String className = clazz.getSimpleName();
		String preJPQL = isQueryTotal ? "select count(*) from "
				: "select o from ";
		StringBuffer jpql = new StringBuffer(preJPQL);
		jpql.append(className).append(" o where 1=1");
		Query query = null;
		if (queryConditions != null && queryConditions.size() > 0) {
			// 构造jpql语句
			Iterator<QueryCondition> iterator = queryConditions.iterator();
			while (iterator.hasNext()) {
				QueryCondition queryCondition = iterator.next();
				if (queryCondition != null) {
					if (queryCondition.getOperator().equals(
							QueryCondition.CUSTOM)) {
						jpql.append(" and ").append(queryCondition.getCustomJPQL());
					}
					//如果是复杂查询
					if(queryCondition.getOperator().equals(
							QueryCondition.COMPLEX)){
						//删除字符串中的 where 1=1
						jpql.delete(jpql.length()-9,jpql.length());
						jpql.append(queryCondition.getCustomJPQL());
					}
					if (queryCondition.getValue() != null
							&& !"".equals(queryCondition.getValue())) {
						// 如果占位符名称是*.*格式，则换成*_*格式。且：和名称之间不能有空格
						String placeholder = queryCondition.getField().indexOf(
								".") != -1 ? queryCondition.getField().replace(
								".", "_") : queryCondition.getField();
						jpql.append(" and o.").append(
								queryCondition.getField().trim()).append(" ")
								.append(queryCondition.getOperator()).append(
										":").append(placeholder.trim());
					}
				}

			}
		}
		if (orderBy != null && !"".equals(orderBy)) {
			jpql.append(" ").append(orderBy);
		}

		query = entityManager.createQuery(jpql.toString());

		if (queryConditions != null && queryConditions.size() > 0) {
			// 为参数赋值
			Iterator<QueryCondition> iterator2 = queryConditions.iterator();
			while (iterator2.hasNext()) {
				QueryCondition queryCondition = iterator2.next();
				if (queryCondition != null) {
					if (queryCondition.getValue() != null
							&& !"".equals(queryCondition.getValue())) {
						// 将占位符中的.替换成_
						queryCondition.setField(queryCondition.getField()
								.indexOf(".") != -1 ? queryCondition.getField()
								.replace(".", "_") : queryCondition.getField());
						if (queryCondition.getOperator().equals(
								QueryCondition.LK)) {
							query.setParameter(queryCondition.getField(), "%"
									+ queryCondition.getValue() + "%");
						} else {
							query.setParameter(queryCondition.getField(),
									queryCondition.getValue());
						}
					}
				}

			}
		}
		return query;
	}

	/**
	 * 根据jpql语句、参数，创建Query
	 * @param jpql
	 * @param objects
	 * @return
	 */
	public  Query createQuery(String jpql, Object... objects) {   
		Query query = entityManager.createQuery(jpql);   
		if  (objects !=  null ) {   
			for  ( int  i =  0 ; i < objects.length; i++) {   
				query.setParameter(i+1, objects[i]);   
			}   
		}   
		return  query;   
	}   

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public <T> List<T> getAll(Class<T> clazz) {
		String className = clazz.getSimpleName();
		StringBuffer jpql = new StringBuffer("select o from ");
		jpql.append(className).append(" o ");
		return entityManager.createQuery(jpql.toString()).getResultList();
	}

	@Override
	public <T> T getById(Class<T> clazz, Object id) {
		return entityManager.find(clazz, id);
	}

	@Override
	public <T> List<T> getByIds(Class<T> clazz, Object[] ids) {
		List<T> list = new ArrayList<T>();
		for(Object id : ids){
			list.add(getById(clazz, id));
		}
		return list;
	}
	
	@Override
	public <T> List<T> getByJPQL(Class<T> clazz,String queryStr) {
		//logger.info("excute jpql:" + queryStr);
		TypedQuery<T> query = entityManager.createQuery(
				queryStr, clazz);
		return query.getResultList();
	}
	
	@Override
	public Object getSingleResult(Class clazz, List<QueryCondition> queryConditions) {
		Query query = getQuery(clazz, queryConditions, null, false);
		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void refresh(Object entity, Map<String, Object> properties) {
		if( entityManager.contains(entity) ){
			if( properties == null ){
				entityManager.refresh(entity);
			}else{
				entityManager.refresh(entity, properties);
			}
		}
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Object entity) {
		if (null == entity) {
			throw new NullPointerException();
		}
		entityManager.persist(entity);
	}

	@Override
	public <T> void batchSave(List<T> entitys) {
		for(T entity : entitys){
			entityManager.persist(entity); 
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(Object entity) {
		if (null == entity) {
			throw new NullPointerException();
		}
		this.entityManager.merge(entity);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Object entity) {
		if (null == entity) {
			throw new NullPointerException();
		}
		this.entityManager.remove(this.entityManager.merge(entity));
	}

	/*	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public <T> void delete(T obj) {
		obj = entityManager.merge(obj);
		entityManager.remove(obj);
	}*/

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public <T> void delete(Class<T> clazz, Object id) {
		T entity = entityManager.find(clazz, id);
		entity = entityManager.merge(entity);
		entityManager.remove(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public <T> void delete(Class<T> clazz, Object[] ids) {
		T entity = null;
		for (Object id : ids) {
			entity = entityManager.find(clazz, id);
			entityManager.remove(entity);
		}
	}

}
