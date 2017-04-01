package com.casicloud.aop.mongodb.core;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.casicloud.aop.mongodb.page.PageModel;

@Component
public abstract class MongoBaseDAO<T extends Serializable> implements MongoBase<T>{
	private static final Logger logger=LoggerFactory.getLogger(MongoBaseDAO.class);
	private Class<T> clazz=null;
	private String clazzName=""; 
	@SuppressWarnings("unchecked")
	public MongoBaseDAO() {
		clazz  =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
		clazzName=clazz.getName();
		logger.info(clazzName);
	}
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	/**
	 * 分页查询
	 * @param pageNo
	 * @param pageSize
	 * @param query
	 * @return
	 */
	@Override
	public PageModel<T> findByPage(int pageNo, int pageSize, Query query) {  
		long totalCount = this.mongoTemplate.count(query, clazz);  
		PageModel<T>  page= new PageModel<T>(pageNo, pageSize, totalCount);  
        query.skip(page.getFirstResult());// skip相当于从那条记录开始  
        query.limit(pageSize);// 从skip开始,取多少条记录  
        List<T> datas = this.mongoTemplate.find(query,clazz);  
        page.setDatas(datas);  
	   return page;  
	}
	
	/**
	 * 通过条件查询实体(集合)
	 * 
	 * @param query
	 */
	@Override
	public List<T> find(Query query) {
		return mongoTemplate.find(query, clazz);
	}

	/**
	 * 通过一定的条件查询一个实体
	 * 
	 * @param query
	 * @return
	 */
	@Override
	public T findOne(Query query) {
		return mongoTemplate.findOne(query, clazz);
	}

	/**
	 * 查询出所有数据
	 * 
	 * @return
	 */
	@Override
	public List<T> findAll() {
		return this.mongoTemplate.findAll(clazz);
	}

	/**
	 * 查询并且修改记录
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	@Override
	public T findAndModify(Query query, Update update) {

		return this.mongoTemplate.findAndModify(query, update, clazz);
	}

	/**
	 * 按条件查询,并且删除记录
	 * 
	 * @param query
	 * @return
	 */
	@Override
	public T findAndRemove(Query query) {
		return this.mongoTemplate.findAndRemove(query, clazz);
	}

	/**
	 * 通过条件查询更新数据
	 * 
	 * @param query
	 * @param update
	 * @return
	 */
	@Override
	public void updateFirst(Query query, Update update) {
		mongoTemplate.updateFirst(query, update, clazz);
	}

	/**
	 * 保存一个对象到mongodb
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public T save(T t) {
		mongoTemplate.save(t);
		return t;
	}

	/**
	 * 通过ID获取记录
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public T findById(String id) {
		return mongoTemplate.findById(id, clazz);
	}

	/**
	 * 通过ID获取记录,并且指定了集合名(表的意思)
	 * 
	 * @param id
	 * @param collectionName 集合名
	 * @return
	 */
	@Override
	public T findById(String id, String collectionName) {
		return mongoTemplate.findById(id, clazz, collectionName);
	}
}
