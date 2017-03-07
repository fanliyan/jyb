package com.jyb.dao;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//id的名字是daoSupport
@Repository("daoSupport")
public class DaoSupport  {
	//Resource作用，将id是sqlSessionTemplate的对象注入进成员变量sqlSessionTemplate
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 保存对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int save(String str, Object obj) throws Exception {
		return sqlSessionTemplate.insert(str, obj);
	}
	
	
	/**
	 * 修改对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int update(String str, Object obj) throws Exception {
		return sqlSessionTemplate.update(str, obj);
	}

	
	/**
	 * 删除对象 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int delete(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}
	 
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findOne(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}
	
	public Object findOne(String str) throws Exception{
		return sqlSessionTemplate.selectOne(str);
	}

	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
//	@SuppressWarnings("rawtypes")
	public Object findList(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	
	
//	@SuppressWarnings("rawtypes")
	public Object findList(String str) throws Exception{
		return sqlSessionTemplate.selectList(str);
	}	
	
	
	
}


