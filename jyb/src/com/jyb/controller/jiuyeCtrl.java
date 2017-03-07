package com.jyb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jyb.pojo.Page;
import com.jyb.pojo.jiuye;
import com.jyb.services.jiuyeservice;
import com.jyb.util.RequestUtil;
import com.jyb.util.TurnPage;

@Controller
@RequestMapping(value="/jiuye")
public class jiuyeCtrl {
	@Resource(name="jiuyeservice")
	private jiuyeservice jiuyeservice;
	private List<jiuye> jiuyeList;
	private jiuye jy;
	
	/**
	 * @修改者 范立炎
	 * @param jy
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/savejiuye", method=RequestMethod.POST)
	public ModelAndView savejiuye(jiuye jy, HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		
			 try {
				 String aid = (String)request.getSession().getAttribute("aid");
				Map resultMap = jiuyeservice.savejiuye(jy, aid);
				 
				 int saveResult = (Integer)resultMap.get("saveResult");
				 
				 if(saveResult == 1){
				//	 mv.addObject("saveResult", "添加成功！");		
					 mv.setViewName("redirect:/admin/writejiuye.jsp");
				 }else{
					 mv.addObject("saveResult", "添加失败！");
					 mv.setViewName("admin/writejiuye");
				 }
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		return mv;
	}
	@RequestMapping("queryUserPage")
	public ModelAndView queryUserPage(@ModelAttribute("turnPage") TurnPage turnPage,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		
		Map paraMap=RequestUtil.getParameterMap(request);
//		TurnPage tp=new TurnPage();
//		tp.setPageCount(pageCount)
		paraMap.put("turnPage", turnPage);
		try {
			Map resultMap=jiuyeservice.queryUserPage(paraMap);
			List list=(List)resultMap.get("list");
			mv.addObject("list", list);
			mv.addObject("turnPage", turnPage);
			
			mv.addObject("title", paraMap.get("title"));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("jiuye/showjiuye");
		return mv;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/showAlljiuye")
	public Map showAllTrainee(@RequestParam(value="page", required=false) String page, 
			@RequestParam(value="rows", required=false) String rows, @RequestParam(value="title", required=false) String title){
		   
		  Page pageBean = new Page(Integer.parseInt(page), Integer.parseInt(rows));
		  Map reMap = new HashMap();		  
		  Map paraMap = new HashMap();	
		  
		  paraMap.put("title", title);
		  paraMap.put("firstPage", pageBean.getFirstPage());
		  paraMap.put("rows", pageBean.getRows());
		  
		  try {
			List<Map> list = jiuyeservice.showAlljiuye(paraMap);
			Long total = jiuyeservice.getjiuyeTotal(paraMap);			
			reMap.put("rows", list);
			reMap.put("total", total);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		 return reMap; 
	}
	
	
	@RequestMapping(value="/showOnejiuye")
	public ModelAndView showOnejiuye(@RequestParam(value="tid") String tid){
		
		ModelAndView mv = new ModelAndView();
		
		try {
			jiuyeservice.updateview_num(tid);
			jy = jiuyeservice.showOnejiuye(tid);
		
			mv.addObject("jy", jy);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		mv.setViewName("jiuye/showonejiuye");
		
		return mv;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/batchDeletejiuye")//删除
	public Map batchDeleteTrainee(@RequestParam(value="tids", required=false) List tids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)jiuyeservice.batchDeletejiuye(tids);
			Boolean b = (Boolean)paraMap.get("deleteResult");
			if(b == true){
				reMap.put("deleteResult", true);
			}else{
				reMap.put("deleteResult", false);
			}
		} catch (Exception e) {
			reMap.put("deleteResult", false);
			e.printStackTrace();
		}
		return reMap;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/editOnejiuye")
	public Map editOnejiuye(jiuye jy, HttpServletRequest request){
		Map reMap = new HashMap();
		String aid = (String)request.getSession().getAttribute("aid");
		try {
			Map paraMap = jiuyeservice.editOnejiuye(jy, aid);
			Boolean b = (Boolean)paraMap.get("updateResult");
			if(b == true){
				reMap.put("updateResult", true);
			}else{
				reMap.put("updateResult", false);
			}
		} catch (Exception e) {
			reMap.put("updateResult", false);
			e.printStackTrace();
		}	
		return reMap;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/datezhiding")//置顶
	public Map datezhiding(@RequestParam(value="tids", required=false) List tids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)jiuyeservice.zhiding(tids);
			Boolean b = (Boolean)paraMap.get("deleteResult");
			if(b == true){
				reMap.put("deleteResult", true);
			}else{
				reMap.put("deleteResult", false);
			}
		} catch (Exception e) {
			reMap.put("deleteResult", false);
			e.printStackTrace();
		}
		return reMap;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/quxiaodatezhiding")//取消置顶
	public Map quxiaodatezhiding(@RequestParam(value="tids", required=false) List tids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)jiuyeservice.quxiaozhiding(tids);
			Boolean b = (Boolean)paraMap.get("deleteResult");
			if(b == true){
				reMap.put("deleteResult", true);
			}else{
				reMap.put("deleteResult", false);
			}
		} catch (Exception e) {
			reMap.put("deleteResult", false);
			e.printStackTrace();
		}
		return reMap;
	}
	
}
