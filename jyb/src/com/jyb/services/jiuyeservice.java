package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.pojo.Trainee;
import com.jyb.pojo.jiuye;
import com.jyb.util.CalendarUtil;
import com.jyb.util.TurnPage;
import com.jyb.util.UUIDUtil;




@Service("jiuyeservice")
public class jiuyeservice {
	
	
	@Resource(name="daoSupport")
	private DaoSupport dao;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })//消除警告
	public Map savejiuye(jiuye jy, String aid) throws Exception{
		Map reMap = new HashMap();
		jy.setTid(UUIDUtil.getUUID());
		jy.setAid(aid);
		jy.setTime(CalendarUtil.getCurrentDate());
		int i = dao.save("userMapper.insertjiuye", jy);
		if(i == 1){
			reMap.put("saveResult", 1);
		}else {
			reMap.put("saveResult", -1);
		}		
		return reMap;
	}

	public Map queryUserPage(Map map) throws Exception{
		Map reMap=new HashMap();
		TurnPage turnPage=(TurnPage)map.get("turnPage");
		
		List list=(List) dao.findList("userMapper.queryUserPagejiuye", map);
		reMap.put("list", list);
		
		long count=(Long)dao.findOne("userMapper.queryCountUserPagejiuye", map);
		turnPage.setTotal(count);
		return reMap;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List showAlljiuye(Map map) throws Exception{
		List<Map> list = (List<Map>)dao.findList("userMapper.selectjiuye", map);
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public Long getjiuyeTotal(Map map) throws Exception{		
		Long total = (Long)dao.findOne("userMapper.getTraineeTotal", map); 	
		return total;
	}
	
	
	
	public void updateview_num(String tid) throws Exception{
		
		dao.update("userMapper.updateview_numjy", tid);
			
			
	}
	
public jiuye showOnejiuye(String tid) throws Exception{
		
		jiuye jy = (jiuye)dao.findOne("userMapper.selectOnejiuye", tid);
		
		return jy;
	}


@SuppressWarnings({ "rawtypes", "unchecked" })
public Map batchDeletejiuye(List tids) throws Exception{
	Map reMap = new HashMap();
   int i = dao.delete("userMapper.deletejiuye", tids);
   if(i >= 1){
	   reMap.put("deleteResult", true);
   }else{
	   reMap.put("deleteResult", false);
   }
	return reMap;
}


@SuppressWarnings({ "rawtypes", "unchecked" })
public Map editOnejiuye(jiuye jy, String aid) throws Exception{
	Map reMap = new HashMap();
	jy.setAid(aid);
	int i = dao.update("userMapper.updateOnejiuye", jy);
	if(i == 1){
		reMap.put("updateResult", true);
	}else{
		reMap.put("updateResult", false);
	}
	return reMap;
}



//置顶
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map zhiding(List tids) throws Exception{
		Map reMap = new HashMap();
	   int i = dao.delete("userMapper.updatejiuyeStatus_0_1", tids);//如何置顶
	   if(i == 1){
		   reMap.put("deleteResult", true);
	   }else{
		   reMap.put("deleteResult", false);
	   }
		return reMap;
	}
	//取消置顶
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map quxiaozhiding(List tids) throws Exception{
		Map reMap = new HashMap();
	   int i = dao.delete("userMapper.updatejiuyeStatus_1_0", tids);//如何置顶
	   if(i == 1){
		   reMap.put("deleteResult", true);
	   }else{
		   reMap.put("deleteResult", false);
	   }
		return reMap;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map jiuyeIndex(Map map) throws Exception{
		 Map reMap = new HashMap();
		
		List<Map> list = (List<Map>)dao.findList("userMapper.selectjiuyeLike", map);
		reMap.put("list", list);
		
		return reMap;
	}

}
