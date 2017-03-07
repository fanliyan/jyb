package com.jyb.services;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.util.TurnPage;


@Service("MessageSrv")
public class MessageSrv {
	
	/*
	 * java的注解
	 * 从spring容器中获得id是daoSupport的对象，并将该对象注入到成员变量dao中
	 */
	@Resource(name="daoSupport")
	private DaoSupport dao;//因为加了注解，所以不用写setDao()方法
	
	/*
	 * 删除留言
	 */
	
	public int delectMessage(String mid) throws Exception{
		
		int result=dao.delete("messageMapper.deleteMessage", mid);
		return result;
	}
	
	
	/*
	 * 查询全部留言
	 */
	/**
	 * @修改人 范立炎
	 * @return
	 * @throws Exception
	 */
	public List selectMessage() throws Exception{
		
		List<Map> list=(List<Map>)dao.findList("messageMapper.selectMessage");
			return list;//返回reMap
			
	}
	
	/*
	 * 分页查询留言
	 */
	/**
	 * @修改人 范立炎
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map queryMessagePage(Map map) throws Exception{
		Map reMap=new HashMap();
		TurnPage turnPage=(TurnPage)map.get("turnPage");
		
		List<Map> list=(List<Map>)dao.findList("messageMapper.queryMessagePage", map);
		reMap.put("list", list);
		
		long count=(Long)dao.findOne("messageMapper.queryCountMessagePage", map);
		turnPage.setTotal(count);
		return reMap;
	}


	
	/*
	 * 添加留言
	 */
	public Map insertMessage(String connect,String uid,String name) throws Exception{
		
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr=sd.format(date);
	
		Map paraMap=new HashMap();
		
		paraMap.put("mid",  UUID.randomUUID().toString().replace("-", ""));
		paraMap.put("uid", uid);
		paraMap.put("name", name);
		paraMap.put("time", dateStr);
		paraMap.put("connect", connect);
		int i=dao.save("messageMapper.insertMessage", paraMap);
		if(i>0){
			paraMap.put("result", 1);//添加留言成功
			//throw new Exception("测试");
		}else{
		paraMap.put("result", -2);//添加留言失败	
		}
	//	System.out.println(i);
		
		return paraMap;
	}
	
}
