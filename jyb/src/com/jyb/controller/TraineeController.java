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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jyb.pojo.Trainee;
import com.jyb.services.TraineeService;
import com.jyb.util.RequestUtil;
import com.jyb.util.TurnPage;

@Controller
@RequestMapping(value="/trainee")
public class TraineeController {
	
	@Resource(name="TraineeService")
	private TraineeService traineeService;
	private List<Trainee> traineeList;
	private Trainee trainee;

//	/**
//	 * 接收表单提交的参数并保存到pojo类的setter()并重定向至showAllTrainee()
//	 * @author 范立炎
//	 * @时间 2016-08-02
//	 * @param trainee
//	 * @param request
//	 * @return ModelAndView
//	 */
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value="/saveTrainee", method=RequestMethod.POST)
//	public ModelAndView saveTrainee(Trainee trainee, HttpServletRequest request){
//		
//		ModelAndView mv = new ModelAndView();
//		if(trainee.getConnect() != null && !trainee.getConnect().equals("")){
//			if(!trainee.getFile().isEmpty()){
//				String imgSrc = FileUpload.fileUpload(request, trainee.getFile());
//				trainee.setPhoto(imgSrc);
//			}
//			 try {
//				Map resultMap = traineeService.saveTrainee(trainee);
//				 
//				 int saveResult = (int)resultMap.get("saveResult");
//				 
//				 if(saveResult == 1){
//				//	 mv.addObject("saveResult", "添加成功！");		
//					 mv.setViewName("redirect:/trainee/queryTraineeLike");
//				 }else{
//					 mv.addObject("saveResult", "添加失败！");
//					 mv.setViewName("admin/writeTrainee");
//				 }
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}else{
//			mv.setViewName("admin/writeTrainee");		
//		}
//		
//		return mv;
//	}
//	
	/**
	 * 调用service层查询所有方法，返回页面显示所有实习生信息
	 * @author 范立炎
	 * @时间 2016-08-02
	 * @return ModelAndView
	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@RequestMapping(value="/showAllTrainee", method=RequestMethod.GET)
//	public ModelAndView showAllTrainee(){
//			
//		ModelAndView mv = new ModelAndView();
//		
//		
//			try {
//				Map map = traineeService.showAllTrainee();
//				traineeList = (List<Trainee>)map.get("list");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		    mv.addObject("traineeList", traineeList);
//		    mv.setViewName("trainee/showTrainee");
//		
//		    return mv;
//	}
	
	/**
	 * 接收参数tid,传给service处理，处理后返回给页面展示一条实习生信息
	 * @author 范立炎
	 * @时间 2016-08-02
	 * @param tid
	 * @return ModelAndView
	 */
	@RequestMapping(value="/showOneTrainee")
	public ModelAndView showOneTrainee(@RequestParam(value="tid") String tid){
		
		ModelAndView mv = new ModelAndView();
		
		try {
			trainee = traineeService.showOneTraee(tid);
			mv.addObject("trainee", trainee);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		mv.setViewName("trainee/traineedetail");
		
		return mv;
	}
	
	/**
	 * 接收分页等参数，转发至分页查询展示实习生信息页面
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param turnPage
	 * @param request
	 * @return ModelAndView
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	//@ResponseBody
	@RequestMapping(value="/queryTraineeLike")
	public ModelAndView queryTraineeLike(@ModelAttribute TurnPage turnPage, HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		Map reMap = new HashMap();
		Map paraMap = RequestUtil.getParameterMap(request);
		paraMap.put("turnPage", turnPage);
		try {
			Map map = traineeService.queryTraineeLike(paraMap);		
			traineeList = ((List<Trainee>)map.get("list"));
			mv.addObject("traineeList", traineeList);
		//	reMap.put("traineeList", traineeList);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		mv.addObject("turnPage", turnPage);
		mv.addObject("name", paraMap.get("name"));
		mv.addObject("major", paraMap.get("major"));
		mv.addObject("city", paraMap.get("city"));
		mv.addObject("company", paraMap.get("company"));
		mv.addObject("title", paraMap.get("title"));
		
		mv.setViewName("trainee/showTrainee");
//		reMap.put("turnPage", turnPage);
//		reMap.put("name", paraMap.get("name"));
//		reMap.put("major", paraMap.get("major"));
//		reMap.put("city", paraMap.get("city"));
//		reMap.put("company", paraMap.get("company"));
//		reMap.put("title", paraMap.get("title"));
		return mv;
		
	}
	
	
	
}
