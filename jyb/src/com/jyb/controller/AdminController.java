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
	 * ����easyui�����ķ�ҳ���������ݲ�����easyui��ҳ�Ͳ�ѯչʾʵϰ����Ϣ
	 * @author ������
	 * @ʱ�� 2016-08-06
	 * @param page  ��ǰ�ڼ�ҳ
	 * @param rows  ÿҳ��ʾ�ļ�¼��
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
			reMap.put("rows", list);     //���ÿҳ��¼��
			reMap.put("total", total);   //����ܼ�¼�� �������
		} catch (Exception e) {	
			e.printStackTrace();
		}
		 return reMap; 
	}
	
	/**
	 * �Լ�����ʽ�������մ���tids,�Ա�����ɾ��
	 * @author ������
	 * @ʱ�� 2016-08-06
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
	 * ����tid,��ʵϰ����Ϣ�Ž�Map,�Ա�ǰ����ת����ϸҳ��
	 * @author ������
	 * @ʱ�� 2016-08-06
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
	 * ����Ҫ�޸�ʵϰ����Ϣ������ʾ��Ϣ����ҳ��
	 * @author ������
	 * @ʱ�� 2016-08-06
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
	 * ����Ҫ����ʵϰ����Ϣ������ʾ��Ϣ����ҳ��
	 * @author ������
	 * @ʱ�� 2016-08-06
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
	@RequestMapping(value="/batchDeleteadmin")//ɾ��
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
	
	//��ӹ���Ա
		@ResponseBody  //����json��ʽ����
		@RequestMapping("addadmin")
		public  Map addadmin(HttpServletRequest req) throws Exception{
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String email=req.getParameter("email");
			String phone=req.getParameter("phone");
			//System.out.println(username);
		
			Map resultMap=	adminService.executaddadmin(username, password,email, phone);
				int loginResult=(Integer)resultMap.get("result");//����code��ֵ
				System.out.println(loginResult);//�����Ƿ��з���ֵ
			
				
				return resultMap;
			
		
		}

}
