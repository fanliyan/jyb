package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.SendResult;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jyb.dao.DaoSupport;

@Service("registerservice")
public class registerservice {
          /*
           * Java的注解
           * 从spring容器中获得id是DaoSupport.java的对象，并将该对象注入到成员变量dao中
           */
	
	@Resource(name="daoSupport")
	private DaoSupport ds;
	/**
	 * @修改人 范立炎
	 * @param name
	 * @param pwd
	 * @param email
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	 public  Map executregister(String name,String pwd,String email,String phone) throws Exception {
		//System.out.println(name);
		//System.out.println(pwd);
		 ModelAndView mv=new ModelAndView();//视图解析器
		 HttpServletRequest req = null;
		Map param=new HashMap();
		List<Map> l=(List<Map>)ds.findList("userMapper.selectUserWhere1", name);
	
		if(l!=null && !l.isEmpty()){
			param.put("result", 0);//如果重名，返回0
			//mv.setViewName("redirect:/login.jsp?code="+0); 	
			//req.setAttribute("code","0");
			//return mv;
			/*
			 * 通过这跳到前台，把code传过去
			 * 
			 */
			//System.out.println("adfaf");//测试是否执行if语句
			
		}else{
		
		param.put("aid",getUuid());
		param.put("name", name);
		param.put("password", pwd);
		param.put("email", email);
		param.put("phone", phone);
		param.put("status",1);
		
	
	int i;
	i = ds.save("userMapper.insertUser", param);
	
	param.put("result", 80);//之前传的，怕空指针，表示注册成功
		}
		return param;
		//return mv;
	 }
	 public static String getUuid() {

			return UUID.randomUUID().toString().replaceAll("-", "");
	//mysql 自己提供的ID，保证主键不能重复
		}
}
