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
//	 * ���ձ��ύ�Ĳ��������浽pojo���setter()���ض�����showAllTrainee()
//	 * @author ������
//	 * @ʱ�� 2016-08-02
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
//				//	 mv.addObject("saveResult", "��ӳɹ���");		
//					 mv.setViewName("redirect:/trainee/queryTraineeLike");
//				 }else{
//					 mv.addObject("saveResult", "���ʧ�ܣ�");
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
	 * ����service���ѯ���з���������ҳ����ʾ����ʵϰ����Ϣ
	 * @author ������
	 * @ʱ�� 2016-08-02
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
	 * ���ղ���tid,����service��������󷵻ظ�ҳ��չʾһ��ʵϰ����Ϣ
	 * @author ������
	 * @ʱ�� 2016-08-02
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
	 * ���շ�ҳ�Ȳ�����ת������ҳ��ѯչʾʵϰ����Ϣҳ��
	 * @author ������
	 * @ʱ�� 2016-08-06
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
