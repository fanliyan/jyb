package com.jyb.dao;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//id��������daoSupport
@Repository("daoSupport")
public class DaoSupport  {
	//Resource���ã���id��sqlSessionTemplate�Ķ���ע�����Ա����sqlSessionTemplate
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * �������
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int save(String str, Object obj) throws Exception {
		return sqlSessionTemplate.insert(str, obj);
	}
	
	
	/**
	 * �޸Ķ���
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int update(String str, Object obj) throws Exception {
		return sqlSessionTemplate.update(str, obj);
	}

	
	/**
	 * ɾ������ 
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public int delete(String str, Object obj) throws Exception {
		return sqlSessionTemplate.delete(str, obj);
	}
	 
	/**
	 * ���Ҷ���
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
	 * ���Ҷ���
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


