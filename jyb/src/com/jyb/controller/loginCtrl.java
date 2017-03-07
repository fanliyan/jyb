package com.jyb.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;*/


import com.jyb.services.loginservice;

@Controller
@RequestMapping(value="test")
public class loginCtrl {
    
	@Resource(name="loginservice")
	private loginservice ls;
	
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse resp,RedirectAttributes ra) throws UnsupportedEncodingException{
		ModelAndView mv=new ModelAndView();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		try {
			Map resultMap = ls.executlogin(username, password);
			List<Map> list=(List<Map>) resultMap.get("list");			
			if(list != null && !list.isEmpty()){
			 req.getSession().setAttribute("loginList", list.get(0));
			 req.getSession().setAttribute("aid", resultMap.get("aid"));
			 req.getSession().setAttribute("status", resultMap.get("status"));
			}
			int loginResult=(Integer)resultMap.get("loginResult");
			int resultstatus=(Integer)resultMap.get("resultstatus");
			
			if(loginResult==1){
				//�ж��û����ǹ���Ա
			    String nowJsp=(String) req.getSession().getAttribute("nowJsp");
			    System.out.println(nowJsp);
			    if(nowJsp==null){
			    	mv.setViewName("index");
			    }else{
			    	mv.setViewName("redirect:"+nowJsp);
			    	
			    }
				if(resultstatus==1){
					//mv.addObject("msg","���,"+username+"!");
					mv.setViewName("redirect:/"+nowJsp);
				}else if(resultstatus==0){
					mv.addObject("msg","������̬�ȶ���,�㱻����!");	
					mv.setViewName("index");
				}else if(resultstatus==2){
					mv.setViewName("redirect:/admin/main.jsp");
				//	mv.addObject("msg","����Ա"+username+"!");
					req.getSession().setAttribute("msg","����Ա"+username+"!");
				}else if(resultstatus==3){
					//mv.addObject("msg","��������Ա"+username+"!");	
					req.getSession().setAttribute("msg","��������Ա"+username+"!");
					mv.setViewName("redirect:/admin/main.jsp");
				}
			}else if(loginResult==-1){
				mv.setViewName("redirect:/login.jsp");
				ra.addAttribute("code", loginResult);
			}else if(loginResult==-2){
				mv.setViewName("redirect:/login.jsp");
				ra.addAttribute("code", loginResult);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return mv;
	}
	
}
