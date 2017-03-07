package com.jyb.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.pojo.Page;
import com.jyb.pojo.Trainee;
import com.jyb.services.AdminService;
import com.jyb.util.FileUpload;


@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@Resource(name="AdminService")
	private AdminService adminService;
	
	/**
	 * 接收easyui传来的分页参数，传递参数给easyui分页和查询展示实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param page  当前第几页
	 * @param rows  每页显示的记录数
	 * @param title
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/showAllTrainee")
	public Map showAllTrainee(@RequestParam(value="page", required=false) String page, 
			@RequestParam(value="rows", required=false) String rows, @RequestParam(value="title", required=false) String title){
		   
		  Page pageBean = new Page(Integer.parseInt(page), Integer.parseInt(rows));
		  Map reMap = new HashMap();		  
		  Map paraMap = new HashMap();	
		  
		  paraMap.put("title", title);
		  paraMap.put("firstPage", pageBean.getFirstPage());
		  paraMap.put("rows", pageBean.getRows());
		  
		  try {
			List<Map> list = adminService.showAllTrainee(paraMap);
			long total = adminService.getTraineeTotal(paraMap);
			reMap.put("rows", list);     //存放每页记录数
			reMap.put("total", total);   //存放总记录数 ，必须的
		} catch (Exception e) {	
			e.printStackTrace();
		}
		 return reMap; 
	}
	
	/**
	 * 以集合形式批量接收传来tids,以便批量删除
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param tids
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/batchDeleteTrainee")
	public Map batchDeleteTrainee(@RequestParam(value="tids", required=false) List tids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)adminService.batchDeleteTrainee(tids);
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
	
	/**
	 * 接收tid,把实习生信息放进Map,以便前端跳转到详细页面
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param tid
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/showOneTrainee")
	public Map showOneTrainee(@RequestParam(value="tid", required=false) String tid){
		Map reMap = new HashMap();
		try {
			Trainee trainee = adminService.showOneTrainee(tid);
			reMap.put("trainee", trainee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reMap;
	}
	
	
	/**
	 * 接收要修改实习生信息，把提示信息返回页面
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param trainee
	 * @param request
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/editOneTrainee")
	public Map editOneTrainee(Trainee trainee, HttpServletRequest request){
		Map reMap = new HashMap();
		String aid = (String)request.getSession().getAttribute("aid");
		if(!trainee.getFile().isEmpty()){
			String imgSrc = FileUpload.fileUpload(request, trainee.getFile());
			trainee.setPhoto(imgSrc);			 
		}
		try {			
			Map paraMap = adminService.editOneTrainee(trainee, aid);
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
	
	/**
	 * 接收要保存实习生信息，把提示信息返回页面
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param trainee
	 * @param request
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/saveTrainee")
	public Map saveTrainee(Trainee trainee, HttpServletRequest request){
		 Map reMap = new HashMap();
		if(trainee.getConnect() != null && !trainee.getConnect().equals("")){
			if(!trainee.getFile().isEmpty()){
				String imgSrc = FileUpload.fileUpload(request, trainee.getFile());
				trainee.setPhoto(imgSrc);
			}
			String aid = (String)request.getSession().getAttribute("aid");
			 try {
				Map resultMap = adminService.saveTrainee(trainee, aid);
				 
				 Boolean saveResult = (Boolean)resultMap.get("saveResult");
				 
				 if(saveResult == true){
				    reMap.put("saveResult", true);
				 }else{
					reMap.put("saveResult", false);
				 }
			} catch (Exception e) {
				reMap.put("saveResult", false);
				e.printStackTrace();
			}
		}else{
			reMap.put("saveResult", false);	
		}
		
		return reMap;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/setadmin")
	public Map setadmin(@RequestParam(value="page", required=false) String page, 
			@RequestParam(value="rows", required=false) String rows, @RequestParam(value="name", required=false) String name){
		   
		  Page pageBean = new Page(Integer.parseInt(page), Integer.parseInt(rows));
		  Map reMap = new HashMap();		  
		  Map paraMap = new HashMap();	
		  
		  paraMap.put("name", name);
		  paraMap.put("firstPage", pageBean.getFirstPage());
		  paraMap.put("rows", pageBean.getRows());
		  
		  try {
			List<Map> list = adminService.setadmin(paraMap);
			Long total = adminService.getTraineeTotal(paraMap);			
			reMap.put("rows", list);
			reMap.put("total", total);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		 return reMap; 
	}
	
@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value="/batchDeleteadmin")//删除
	public Map batchDeleteadmin(@RequestParam(value="aids", required=false) List aids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)adminService.batchDeleteadmin(aids);
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
	@RequestMapping(value="/setadminaid")
	public Map setadminid(@RequestParam(value="aids", required=false) List aids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)adminService.setadminid(aids);
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
	@RequestMapping(value="/quxiaosetadminaid")
	public Map quxiaosetadminid(@RequestParam(value="aids", required=false) List aids){
		Map reMap = new HashMap();
		try {
			Map paraMap = (Map)adminService.quxiaosetadminid(aids);
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
	
	//添加管理员
		@ResponseBody  //返回json格式数据
		@RequestMapping("addadmin")
		public  Map addadmin(HttpServletRequest req) throws Exception{
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			//System.out.println(username);
		
			Map resultMap=	adminService.executaddadmin(username, password,email, phone);
				int loginResult=(Integer)resultMap.get("result");//接收code的值
				System.out.println(loginResult);//测试是否有返回值
			
				
				return resultMap;
			
		
		}

}
