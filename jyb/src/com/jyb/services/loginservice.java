package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;

@Service("loginservice")
public class loginservice {
          /*
           * Java的注解
           * 从spring容器中获得id是DaoSupport.java的对象，并将该对象注入到成员变量dao中
           */
	
	@Resource(name="daoSupport")
	private DaoSupport ds;
	
	/**
	 * @修改者 范立炎
	 * @param name
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	 public Map executlogin(String name,String pwd) throws Exception{
		int i=name.length();//测试长度，管理员8位以下，普通用户必须8位
		 Map reMap=new HashMap();
		 List<Map> list =null;
		 if(i>=8){
			  list=(List<Map>)ds.findList("userMapper.selectUserWhere1", name);
			 
		 }else{
	
			   list=(List<Map>)ds.findList("userMapper.selectUserWhere2", name);
		 }
			if(list!=null && !list.isEmpty()){
				Map m=list.get(0);
				String password=(String)m.get("password");
				String username=(String)m.get("name");
				String aid = (String)m.get("aid");
				reMap.put("aid", aid);
				String status=(String)m.get("status");//状态
				reMap.put("status", status);
				if(password.equals(pwd)){
					reMap.put("loginResult", 1);
					reMap.put("list", list);
				/*
				 * 返回判断用户还是管理员
				 * 被封 ：0
				 * 用户 ：1
				 * 管理员 ：2
				 * 超级管理员 ：3
				 * 因为注册的都是普通用户
				 * 注册默认status=1
				 * 
				 */
					
					if(status.equals("0")){
						reMap.put("resultstatus", 0);
					}else if(status.equals("1")){
						reMap.put("resultstatus", 1);
					}else if(status.equals("2")){
						reMap.put("resultstatus", 2);
					}else if(status.equals("3")){
						reMap.put("resultstatus", 3);
					}
				}else{
					reMap.put("loginResult", -2);
					reMap.put("resultstatus", 8);
				}
			}else{
				reMap.put("loginResult", -1);
				reMap.put("resultstatus", 100);
			}
		
		 return reMap;
		 
	 }
}
