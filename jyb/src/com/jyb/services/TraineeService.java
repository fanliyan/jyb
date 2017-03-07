package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.pojo.Trainee;
import com.jyb.util.CalendarUtil;
import com.jyb.util.TurnPage;
import com.jyb.util.UUIDUtil;

@Service("TraineeService")
public class TraineeService {

	@Resource(name="daoSupport")
	private DaoSupport dao;
		
//	/**
//	 * 保存trainee
//	 * @author 范立炎
//	 * @时间 2016-08-02
//	 * @param trainee
//	 * @return Map
//	 * @throws Exception
//	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public Map saveTrainee(Trainee trainee) throws Exception{
//		Map reMap = new HashMap();
//		trainee.setAid("1");
//		trainee.setTid(UUIDUtil.getUUID());
//		trainee.setTime(CalendarUtil.getCurrentDate());
//		int i = dao.save("traineeMapper.insertTrainee", trainee);
//		if(i == 1){
//			reMap.put("saveResult", 1);
//		}else {
//			reMap.put("saveResult", -1);
//		}		
//		return reMap;
//	}
	
	/**
	 * 查询所有实习生信息
	 * @author 范立炎 
	 * @时间 2016-08-02
	 * @return Map
	 * @throws Exception
	 */
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public Map showAllTrainee() throws Exception{
//		
//		Map reMap = new HashMap();
//		List<Map> list = (List<Map>)dao.findList("traineeMapper.selectTrainee");
//		reMap.put("list", list);	
//		return reMap;
//		
//	}
	
	/**
	 * 根据tid查询一条实习生信息
	 * @author 范立炎
	 * @时间 2016-08-02
	 * @param tid
	 * @return Trainee
	 * @throws Exception
	 */
	public Trainee showOneTraee(String tid) throws Exception{
		
		dao.update("traineeMapper.updateViewNum", tid);
		Trainee trainee = (Trainee)dao.findOne("traineeMapper.selectOneTrainee", tid);	
		return trainee;
	}
	
	/**
	 * 分页查询展示实习生信息
	 * @author 范立炎
	 * @时间 2016-08-06
	 * @param map
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map queryTraineeLike(Map map) throws Exception{
	    
		Map reMap = new HashMap();
		TurnPage turnPage = (TurnPage)map.get("turnPage");
	     	    	     
	     List<Map> list = (List<Map>)dao.findList("traineeMapper.selectTraineeLike", map);     	     
	     reMap.put("list", list);
	     long count = (Long)dao.findOne("traineeMapper.getTraineeTotal", map);
	     turnPage.setTotal(count);
		return reMap;
	}
	
	public Map traineeIndex(Map map) throws Exception{
		Map reMap = new HashMap();
		List<Map> list = (List<Map>)dao.findList("traineeMapper.selectTraineeLike", map);
		reMap.put("list", list);
		return reMap;
	}
	
	
	
	
}
