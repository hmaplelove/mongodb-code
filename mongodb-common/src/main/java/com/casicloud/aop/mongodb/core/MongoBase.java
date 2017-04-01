package com.casicloud.aop.mongodb.core;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.casicloud.aop.mongodb.page.PageModel;

public interface MongoBase<T extends Serializable> {
	
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param query
	 * @return
	 */
	public PageModel<T> findByPage(int pageNo, int pageSize, Query query);
	
	/**
	 * 通过条件查询实体(集合)
	 * 
	 * @param query
	 */
	public List<T> find(Query query);

	/**
	 * 通过一定的条件查询一个实体
	 * 
	 * @param query
	 * @return
	 */
	public T findOne(Query query);

	/**
	 * 查询出所有数据
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 查询并且修改记录
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	public T findAndModify(Query query, Update update) ;

	/**
	 * 按条件查询,并且删除记录
	 * 
	 * @param query
	 * @return
	 */
	public T findAndRemove(Query query) ;
	/**
	 * 通过条件查询更新数据
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	public void updateFirst(Query query, Update update);

	/**
	 * 保存一个对象到mongodb
	 * 
	 * @param t
	 * @return
	 */
	public T save(T t);

	/**
	 * 通过ID获取记录
	 * 
	 * @param id
	 * @return
	 */
	public T findById(String id);

	/**
	 * 通过ID获取记录,并且指定了集合名(表的意思)
	 * 
	 * @param id
	 * @param collectionName 集合名
	 * @return
	 */
	public T findById(String id, String collectionName);
	
}
