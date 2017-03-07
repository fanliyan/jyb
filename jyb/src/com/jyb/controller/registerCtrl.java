package com.jyb.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.jyb.services.registerservice;

@Controller
@ResponseBody
@RequestMapping(value="test")
public class registerCtrl {
    
	@Resource(name="registerservice")
	private registerservice rg;
	
	
	@ResponseBody  //����json��ʽ����
	@RequestMapping("ajaxregister")
	public  Map ajaxlogin(HttpServletRequest req,HttpServletResponse resp) throws Exception{
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String phone=req.getParameter("phone");
		//System.out.println(username);
	
		Map resultMap=	rg.executregister(username, password,email, phone);
			int loginResult=(Integer)resultMap.get("result");//����code��ֵ
			System.out.println(loginResult);//�����Ƿ��з���ֵ
		
			
			return resultMap;
		
	
	}
}
