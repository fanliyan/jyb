package com.jyb.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jyb.services.ArticleSrv;
import com.jyb.util.RequestUtil;
import com.jyb.util.TurnPage;

@Controller
@RequestMapping(value = "/articleCtrl")
public class ArticleCtrl {

	@Resource(name = "ArticleSrv")
	private ArticleSrv articleSrv;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/selectAllTitle")
	public ModelAndView selectAllTitle(
			@ModelAttribute("turnPage") TurnPage turnPage,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		Map paraMap = RequestUtil.getParameterMap(request);
		paraMap.put("turnPage", turnPage);
		try {
			Map resultMap = articleSrv.exuteFindList(paraMap);
			List list = (List) resultMap.get("list");
			mv.addObject("list", list);
			mv.addObject("turnPage", turnPage);
			mv.addObject("title", paraMap.get("title"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.setViewName("showAllArticle");
		return mv;

	}

	@RequestMapping(value = "/saveArticle")
	public <text> ModelAndView  saveArticle(HttpServletRequest request,RedirectAttributes ra){
		ModelAndView mv = new ModelAndView();
		String aid = (String)request.getSession().getAttribute("aid");
		String title = request.getParameter("title");
		text connect = (text) request.getParameter("connect");
		text keyword = (text) request.getParameter("keyword");
		if((title==null||title.equals(""))||(connect==null||connect.equals(""))){
			mv.setViewName("saveArticle");
		}else{
			try {
				Map resultMap = articleSrv.exuteAdd(title, connect,keyword, aid);
				int result = (Integer) resultMap.get("result");
				if(1==result){
					/*mv.setViewName("saveResult");
					mv.addObject("msg","aa");*/
					ra.addAttribute("code",result);
					mv.setViewName("redirect:/articleCtrl/selectAllTitle");
				}else{
					ra.addAttribute("code",result);
					mv.setViewName("redirect:/saveAricle.jsp");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mv;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "selectArticleOne")
	public ModelAndView selectArticleOne(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		try {
			Map paraMap = articleSrv.exuteFindOne(id);
			String title = (String) paraMap.get("title");
			String connect = (String) paraMap.get("connect");
			String time = (String) paraMap.get("time");
			int view_num = (Integer) paraMap.get("view_num");
			String name = (String) paraMap.get("name");
			mv.addObject("title", title);
			mv.addObject("connect", connect);
			mv.addObject("time", time);
			mv.addObject("view_num", view_num);
			mv.addObject("name", name);
			mv.setViewName("articleView");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "updateArticleOne")
	public ModelAndView updateArticleOne(HttpServletRequest req) {// 编辑（修改）
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		try {
			Map paraMap = articleSrv.exuteFindOne(id);
			String title = (String) paraMap.get("title");
			String connect = (String) paraMap.get("connect");
			mv.addObject("title", title);
			mv.addObject("connect", connect);
			mv.addObject("id", id);
			mv.setViewName("updateArticle");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/updateArticle")
	public <text> ModelAndView updateArticle(HttpServletRequest req,
			RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		String title = req.getParameter("title");
		String connect = req.getParameter("connect");
		String aid = (String) req.getSession().getAttribute("aid");
		try {
			Map resultMap = articleSrv.exuteUpdate(id, title, connect, aid);
			int result = (Integer) resultMap.get("result");
			if (1 == result) {
				ra.addAttribute("code", result);
				mv.setViewName("redirect:/articleCtrl/selectAllTitle");

			} else {
				ra.addAttribute("code", result);
				mv.setViewName("redirect:/showAllArticle.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "updateArticleStatus_0_1")
	public ModelAndView updateArticleStatus_0_1(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		try {
			Map resultMap = articleSrv.exuteUpdateStatus_0_1(id);
			int result = (Integer) resultMap.get("result");
			if (1 == result) {
				mv.setViewName("redirect:/articleCtrl/selectAllTitle");
			} else {
				mv.setViewName("redirect:/showAllArticle.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "updateArticleStatus_1_0")
	public ModelAndView updateArticleStatus_1_0(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		try {
			Map resultMap = articleSrv.exuteUpdateStatus_1_0(id);
			int result = (Integer) resultMap.get("result");
			if (1 == result) {
				mv.setViewName("redirect:/articleCtrl/selectAllTitle");
			} else {
				mv.setViewName("redirect:/showAllArticle.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "deleteArticle")
	public ModelAndView deleteArticle(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String id = req.getParameter("id");
		try {
			Map resultMap = articleSrv.exuteDelete(id);
			int result = (Integer) resultMap.get("result");
			if (1 == result) {
				mv.setViewName("redirect:/articleCtrl/selectAllTitle");
			} else {
				mv.setViewName("redirect:/showAllArticle.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	/*
	 * @RequestMapping("queryUserPage") public ModelAndView
	 * queryUserPage(@ModelAttribute("turnPage") TurnPage
	 * turnPage,HttpServletRequest request,HttpServletResponse response){
	 * ModelAndView mv=new ModelAndView();
	 * 
	 * Map paraMap=RequestTool.getParameterMap(request); // TurnPage tp=new
	 * TurnPage(); // tp.setPageCount(pageCount) paraMap.put("turnPage",
	 * turnPage); try { Map resultMap=articleSrv.queryUserPage(paraMap); List
	 * list=(List)resultMap.get("list"); mv.addObject("list", list);
	 * mv.addObject("turnPage", turnPage); mv.addObject("xb",
	 * paraMap.get("xb")); mv.addObject("username", paraMap.get("username")); }
	 * catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } mv.setViewName("queryUserPage"); return mv; }
	 */
}
