package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.SendResult;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jyb.dao.DaoSupport;

@Service("registerservice")
public class registerservice {
          /*
           * Java��ע��
           * ��spring�����л��id��DaoSupport.java�Ķ��󣬲����ö���ע�뵽��Ա����dao��
           */
	
	@Resource(name="daoSupport")
	private DaoSupport ds;
	/**
	 * @�޸��� ������
	 * @param name
	 * @param pwd
	 * @param email
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	 public  Map executregister(String name,String pwd,String email,String phone) throws Exception {
		//System.out.println(name);
		//System.out.println(pwd);
		 ModelAndView mv=new ModelAndView();//��ͼ������
		 HttpServletRequest req = null;
		Map param=new HashMap();
		List<Map> l=(List<Map>)ds.findList("userMapper.selectUserWhere1", name);
	
		if(l!=null && !l.isEmpty()){
			param.put("result", 0);//�������������0
			//mv.setViewName("redirect:/login.jsp?code="+0); 	
			//req.setAttribute("code","0");
			//return mv;
			/*
			 * ͨ��������ǰ̨����code����ȥ
			 * 
			 */
			//System.out.println("adfaf");//�����Ƿ�ִ��if���
			
		}else{
		
		param.put("aid",getUuid());
		param.put("name", name);
		param.put("password", pwd);
		param.put("email", email);
		param.put("phone", phone);
		param.put("status",1);
		
	
	int i;
	i = ds.save("userMapper.insertUser", param);
	
	param.put("result", 80);//֮ǰ���ģ��¿�ָ�룬��ʾע��ɹ�
		}
		return param;
		//return mv;
	 }
	 public static String getUuid() {

			return UUID.randomUUID().toString().replaceAll("-", "");
	//mysql �Լ��ṩ��ID����֤���������ظ�
		}
}
