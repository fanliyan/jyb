package com.jyb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jyb.services.MessageSrv;
import com.jyb.util.RequestUtil;
import com.jyb.util.TurnPage;

@Controller
@RequestMapping(value="/message")
public class MessageCtrl {

	@Resource(name="MessageSrv")
	private MessageSrv messageSrc;
	
	@RequestMapping("/delectMessage")
	public ModelAndView delectMessage(HttpServletRequest req,HttpServletResponse resp,RedirectAttributes ra){
		ModelAndView mv=new ModelAndView();
		String mid=(String) req.getParameter("mid");
		try {
			int result=messageSrc.delectMessage(mid);
			mv.setViewName("redirect:/message/queryMessagePage");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/insertMessage")
	public Map inertMessage(HttpServletRequest req,HttpServletResponse resp,RedirectAttributes ra){
		Map map = null;
		map = new HashMap();
		String connect=req.getParameter("content");
	//	String connect1 = connect.trim();
		try {
			String uid=req.getParameter("uid");
			String name=req.getParameter("name");
			Map resultMap= messageSrc.insertMessage(connect,uid,name);
			int insertMessageResult=(Integer)resultMap.get("result");
			map.put("result", insertMessageResult);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping("/selectMessage")
	public ModelAndView selectMessage(HttpServletRequest req,HttpServletResponse resp,RedirectAttributes ra){
		ModelAndView mv=new ModelAndView();
		List list = new ArrayList();
		try {
			list=messageSrc.selectMessage();
			req.getSession().setAttribute("messageList",list);
			mv.setViewName("news");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/*
	 * ·ÖÒ³
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("queryMessagePage")
	public ModelAndView queryMessagePage(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		Map paraMap=RequestUtil.getParameterMap(request);
//		TurnPage tp=new TurnPage();
//		tp.setPageCount(pageCount)
		paraMap.put("turnPage", turnPage);
		try {
			Map resultMap=messageSrc.queryMessagePage(paraMap);
			List list=(List)resultMap.get("list");
			mv.addObject("messageList", list);
			mv.addObject("turnPage", turnPage);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("news");
		return mv;
	}
}
