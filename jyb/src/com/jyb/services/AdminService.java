package com.jyb.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.pojo.Trainee;
import com.jyb.util.CalendarUtil;
import com.jyb.util.UUIDUtil;

@Service("AdminService")
public class AdminService {

	@Resource(name="daoSupport")
	private DaoSupport dao;
	
	/**
	 * 分页查询实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param map
	 * @return List
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List showAllTrainee(Map map) throws Exception{
		List<Map> list = (List<Map>)dao.findList("traineeMapper.selectTraineeLimit", map);		
		return list;
	}
	
	/**
	 * 获得查询记录条数，供分页使用
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param map
	 * @return long
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public long getTraineeTotal(Map map) throws Exception{		
		long total = (Long)dao.findOne("traineeMapper.getTraineeTotal", map); 	
		return total;
	}
	
	/**
	 * 批量删除实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param tids
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map batchDeleteTrainee(List tids) throws Exception{
		Map reMap = new HashMap();
	   int i = dao.delete("traineeMapper.deleteTrainee", tids);
	   if(i >= 1){
		   reMap.put("deleteResult", true);
	   }else{
		   reMap.put("deleteResult", false);
	   }
		return reMap;
	}
	
	/**
	 * 查询一条实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param tid
	 * @return Trainee
	 * @throws Exception
	 */
	public Trainee showOneTrainee(String tid) throws Exception{		
		Trainee trainee = (Trainee)dao.findOne("traineeMapper.selectOneTrainee", tid);	 
		return trainee;
	}
	
	/**
	 * 悠修改一条实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param trainee
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map editOneTrainee(Trainee trainee, String aid) throws Exception{
		Map reMap = new HashMap();
		trainee.setAid(aid);
		int i = dao.update("traineeMapper.updateOneTrainee", trainee);
		if(i == 1){
			reMap.put("updateResult", true);
		}else{
			reMap.put("updateResult", false);
		}
		return reMap;
	}
	
	/**
	 * 保存一条实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param trainee
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map saveTrainee(Trainee trainee, String aid) throws Exception{
		Map reMap = new HashMap();
		trainee.setAid(aid);
		
		trainee.setTid(UUIDUtil.getUUID());
		trainee.setTime(CalendarUtil.getCurrentDate());
		int i = dao.save("traineeMapper.insertTrainee", trainee);
		if(i == 1){
			reMap.put("saveResult", true);
		}else {
			reMap.put("saveResult", false);
		}		
		return reMap;
	}
	
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List setadmin(Map map) throws Exception{
		List<Map> list = (List<Map>)dao.findList("userMapper.selectsetadmin", map);
		return list;
	}
@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map batchDeleteadmin(List aids) throws Exception{
		Map reMap = new HashMap();
	   int i = dao.delete("userMapper.deleteadmin", aids);
	   if(i > 1){
		   reMap.put("deleteResult", true);
	   }else{
		   reMap.put("deleteResult", false);
	   }
		return reMap;
	}
@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map setadminid(List aids) throws Exception{
		Map reMap = new HashMap();
	   int i = dao.update("userMapper.updateadmin", aids);
	   if(i == 1){
		   reMap.put("deleteResult", true);
	   }else{
		   reMap.put("deleteResult", false);
	   }
		return reMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map quxiaosetadminid(List aids) throws Exception{
		Map reMap = new HashMap();
	   int i = dao.update("userMapper.updateadminquxiao", aids);
	   if(i == 1){
		   reMap.put("deleteResult", true);
	   }else{
		   reMap.put("deleteResult", false);
	   }
		return reMap;
	}
	
	 public  Map executaddadmin(String name,String pwd,String email,String phone) throws Exception {
			 
			Map param=new HashMap();
			List<Map> l=(List<Map>) dao.findList("userMapper.selectadmin", name);
			
			if(l!=null && !l.isEmpty()){
				param.put("result", 0);//如果重名，返回0
				
			}else{
			
			param.put("aid",UUIDUtil.getUUID());
			param.put("name", name);
			param.put("password", pwd);
			param.put("email", email);
			param.put("phone", phone);
			param.put("status",2);
			
		
		int i;
		i = dao.save("userMapper.insertadmin", param);
		
		param.put("result", 80);//之前传的，怕空指针，表示注册成功
			}
			return param;
		 }
}
