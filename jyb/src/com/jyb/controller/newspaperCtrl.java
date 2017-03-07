package com.jyb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jyb.services.newspaperSrv;
import com.jyb.util.FileUpload;
import com.jyb.util.TurnPage;

@Controller
@RequestMapping(value = "/newspaperCtrl")
public class newspaperCtrl {

	@Resource(name = "newspaperSrv")
	private newspaperSrv ns;

	/**
	 * 进入'添加每期报纸版面'的页面，读取现有的期号,如没有期号信息则转发至'新增期号'的页面
	 * @return mv
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/toInsertNewspaperEdition")
	public ModelAndView toInsertNewspaperEdition() {
		ModelAndView mv = new ModelAndView();
		try {
			List list = ns.selectEditionnum();
			if(list!=null && !list.isEmpty()){
				mv.setViewName("insertNewspaperEdition");
				mv.addObject("newspaperList", list);
			}else{
				mv.setViewName("insertNewspaper");
				mv.addObject("msg", "请新建报纸期号！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 进入'修改指定期和版面的板块信息'的页面，如没有期号信息则转发至'新增期号'的页面
	 * 如没有版号信息则转发至'新增版号'的页面
	 * @param req
	 * @return mv
	 */
	@RequestMapping("/toUploadNewspaperPart")
	public ModelAndView toUploadNewspaperPart(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		try {
			String editionnum = req.getParameter("editionnum");
			String pagenum = req.getParameter("pagenum");
			Map map = ns.selectNespaperPart(editionnum,pagenum);
			int result = (Integer)map.get("result");
			if(result == 1){
				List list = (List)map.get("list");
				mv.setViewName("uploadNewspaperPart");
				mv.addObject("partList", list);
				mv.addObject("imgname",map.get("imgname"));
				//System.out.println(list);
				//System.out.println(map.get("imgname"));
			}else if(result == -1){
				mv.setViewName("insertNewspaper");
				mv.addObject("msg", "请新建报纸期号！");
			}else if(result == -2){
				List list = ns.selectEditionnum();
				mv.setViewName("insertNewspaperEdition");
				mv.addObject("newspaperList", list);
				mv.addObject("msg", "请新建报纸版号！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 用户观看报纸
	 * @param req
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/toNewspaper")
	public ModelAndView toNewspaper(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String editionnum = req.getParameter("editionnum");
		String pagenum = req.getParameter("pagenum");
		String partid = req.getParameter("partid");
		try {
			Map map = ns.toNewspaper(editionnum,pagenum,partid);
			mv.setViewName("jybNewspaper/newspaper");
			mv.addObject("newspaper", map.get("newspaper"));
			mv.addObject("maxEditionnum", map.get("maxEditionnum"));
			mv.addObject("imgname", map.get("imgname"));
			mv.addObject("maxPagenum", map.get("maxPagenum"));
			mv.addObject("pagenum", map.get("pagenum"));
			mv.addObject("editionList", map.get("editionList"));
			mv.addObject("partList", map.get("partList"));
			mv.addObject("partid",partid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 查看所有期的报纸
	 * @param turnPage
	 * @return
	 */
	@RequestMapping("/showNewspaper")
	public ModelAndView showNewspaper(@ModelAttribute TurnPage turnPage){
		ModelAndView mv = new ModelAndView();
		try {
			Map map = new HashMap();
			map.put("turnPage", turnPage);
			List list = ns.showNewspaper(map);
			mv.setViewName("jybNewspaper/showNewspaper");
			mv.addObject("newspaperList", list);
			mv.addObject("turnPage", turnPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 添加版面信息，暂缺结果页面
	 * @param file
	 * @param req
	 * @return
	 */
	@RequestMapping("/insertNewspaperEdition")
	public ModelAndView insertNewspaperEdition(@RequestParam(value = "doc", required = false) MultipartFile file,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		try {
			List<Map> wList = new ArrayList<Map>();
			String newspaperid = req.getParameter("newspaperid");
			String pagenum = req.getParameter("pagenum");
			List list = ns.queryPagenum(newspaperid,pagenum);
			if(list==null || list.isEmpty()){
				String pagetitle = req.getParameter("pagetitle");
				String imgname = FileUpload.fileUpload(req,file);
				String aid = (String)req.getSession().getAttribute("aid");
				for(int i=1;i<7;i++){
					String w = req.getParameter("w"+i);
					System.out.println(w);
					if(w!=null){
						Map map = new HashMap();
						map.put("tlhw", w);
						wList.add(map);
					}
				}
				if(wList!=null && !wList.isEmpty()){
					Map msg = new HashMap();
					msg.put("newspaperid", newspaperid);
					msg.put("pagenum", pagenum);
					msg.put("pagetitle", pagetitle);
					msg.put("imgname", imgname);
					msg.put("aid", aid);
					ns.insertNewspaperEdition(wList,msg);
					mv.setViewName("redirect:/newspaperCtrl/toInsertNewspaperEdition");
				}
			}else{
				list = ns.selectEditionnum();
				mv.setViewName("insertNewspaperEdition");
				mv.addObject("newspaperList", list);
				mv.addObject("msg", "该期报纸版号已存在！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * 添加期号信息，暂缺结果页面
	 * @param req
	 * @param ra
	 * @return
	 */
	@RequestMapping("/insertNewspaper")
	public ModelAndView insertNewspaper(HttpServletRequest req, RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView();
		String editionnum = req.getParameter("editionnum");
		try {
			List list = ns.queryEditionnum(editionnum);
			if(list==null || list.isEmpty()){
				ns.insertNewspaper(editionnum);
				mv.setViewName("redirect:/newspaperCtrl/toInsertNewspaperEdition");
			}else{
				mv.setViewName("insertNewspaper");
				mv.addObject("msg", "该报纸期号已存在！");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
	
	/**
	 * ajax添加报纸每个板块的文章内容，标题，时间
	 * @param req
	 * @return map to json
	 */
	@ResponseBody
	@RequestMapping("/updateNewspaperPart")
	public Map updateNewspaperPart(HttpServletRequest req) {
		Map map = null;
		String partid = req.getParameter("partid");
		String parttitle = req.getParameter("parttitle");
		String content = req.getParameter("content");
		String aid = (String)req.getSession().getAttribute("aid");
		try {
			map = ns.updateNewspaperPart(partid,parttitle,content,aid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map==null){
			map = new HashMap();
		}
		return map;
	}
	
	/**
	 * ajax获取每个板块内的文章内容，标题
	 * @param req
	 * @return map to json
	 */
	@ResponseBody
	@RequestMapping("/selectNewspaperPart")
	public Map selectNewspaperPart(HttpServletRequest req) {
		String partid = req.getParameter("partid");
		String action = req.getParameter("action");
		Map map = null;
		try {	
			System.out.println(action);
			if(action==null || "".equals(action)){
				ns.updatePartHits(partid);
			}
			map = ns.selectNewspaperPart(partid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map==null){
			map = new HashMap();
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/updateNewspaperEdition")
	public Map updateNewspaperEdition(HttpServletRequest req) {
		Map map = null;
		String editionnum = req.getParameter("editionnum");
		String pagenum = req.getParameter("pagenum");
		String pagetitle = req.getParameter("pagetitle");
		try {
			map = ns.updateNewspaperEdition(editionnum,pagenum,pagetitle);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map==null){
			map = new HashMap();
		}
		return map;
	}
}
