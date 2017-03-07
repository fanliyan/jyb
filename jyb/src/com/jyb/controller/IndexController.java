package com.jyb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jyb.pojo.Trainee;
import com.jyb.pojo.jiuye;
import com.jyb.services.ArticleSrv;
import com.jyb.services.IndexService;
import com.jyb.services.TraineeService;
import com.jyb.services.jiuyeservice;
import com.jyb.services.newspaperSrv;
import com.jyb.util.TurnPage;

@Controller
public class IndexController {

	@Resource(name = "TraineeService")
	private TraineeService traineeService;
	@Resource(name = "IndexService")
	private IndexService indexService;
	@Resource(name = "ArticleSrv")
	private ArticleSrv articleSrv;
	@Resource(name = "jiuyeservice")
	private jiuyeservice jiuyeservice;
	@Resource(name = "newspaperSrv")
	private newspaperSrv ns;

	private Trainee trainee;
	private jiuye jy;

	/**
	 * 把主页要隐藏的数据发送到主页
	 * 
	 * @author 范立炎
	 * @时间 2016-08-17
	 * @return ModelAndView
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		Map paraMap = new HashMap();
		TurnPage turnPage = new TurnPage(10);
		paraMap.put("turnPage", turnPage);
		try {
			Map map = (Map) traineeService.traineeIndex(paraMap);
			List list = (List) map.get("list");
			mv.addObject("list", list);

			Map jiuyeMap = (Map) jiuyeservice.jiuyeIndex(paraMap);
			List jiuyelist = (List) jiuyeMap.get("list");
			mv.addObject("jiuyelist", jiuyelist);

			Map articleMap = (Map) articleSrv.exuteFindList(paraMap);
			List articleList = (List) articleMap.get("list");
			mv.addObject("articleList", articleList);

			mv.setViewName("index");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 接收站内搜索参数，处理后转发到结果页面
	 * 
	 * @param turnPage
	 * @param title
	 * @return ModelAndView
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" })
	@RequestMapping(value = "/querySearch")
	public ModelAndView querySearch(@ModelAttribute TurnPage turnPage,
			@RequestParam(value = "title") String title) {
		ModelAndView mv = new ModelAndView();
		if (title == null || title.equals("")) {
			mv.setViewName("redirect:/index");
		} else {
			Map paraMap = new HashMap();
			paraMap.put("turnPage", turnPage);
			paraMap.put("title", title);
			try {
				Map map = indexService.querySearch(paraMap);
				List list = (List) map.get("list");
				mv.addObject("list", list);
				mv.addObject("turnPage", turnPage);
				mv.addObject("title", title);
				mv.setViewName("queryResult1");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mv;
	}

	/**
	 * 接收站内搜索的结果参数，根据参数跳到相应service
	 * 
	 * @param id
	 * @param tablename
	 * @param ra
	 * @return ModelAndView
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/showOneQueryResult")
	public ModelAndView showOneQueryResult(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "tablename") String tablename,
			RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView();
		if (tablename.equals("article")) {
			try {
				Map paraMap = articleSrv.exuteFindOne(id);
				String title = (String) paraMap.get("title");
				String connect = (String) paraMap.get("connect");
				String time = (String) paraMap.get("time");
				int view_num = (Integer) paraMap.get("view_num");
				mv.addObject("title", title);
				mv.addObject("connect", connect);
				mv.addObject("time", time);
				mv.addObject("view_num", view_num);
				mv.setViewName("articleView");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (tablename.equals("jiuye")) {
			try {
				jiuyeservice.updateview_num(id);
				jy = jiuyeservice.showOnejiuye(id);
				mv.addObject("jy", jy);
				mv.setViewName("jiuye/showonejiuye");
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (tablename.equals("newspaperpart")) {
			mv.setViewName("redirect:/newspaperCtrl/toNewspaper");
			ra.addAttribute("partid", id);
		} else if (tablename.equals("trainee")) {
			try {
				trainee = traineeService.showOneTraee(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mv.addObject("trainee", trainee);
			mv.setViewName("trainee/traineedetail");
		}
		return mv;
	}

}
