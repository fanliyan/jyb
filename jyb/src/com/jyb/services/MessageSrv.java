package com.jyb.services;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.util.TurnPage;


@Service("MessageSrv")
public class MessageSrv {
	
	/*
	 * java��ע��
	 * ��spring�����л��id��daoSupport�Ķ��󣬲����ö���ע�뵽��Ա����dao��
	 */
	@Resource(name="daoSupport")
	private DaoSupport dao;//��Ϊ����ע�⣬���Բ���дsetDao()����
	
	/*
	 * ɾ������
	 */
	
	public int delectMessage(String mid) throws Exception{
		
		int result=dao.delete("messageMapper.deleteMessage", mid);
		return result;
	}
	
	
	/*
	 * ��ѯȫ������
	 */
	/**
	 * @�޸��� ������
	 * @return
	 * @throws Exception
	 */
	public List selectMessage() throws Exception{
		
		List<Map> list=(List<Map>)dao.findList("messageMapper.selectMessage");
			return list;//����reMap
			
	}
	
	/*
	 * ��ҳ��ѯ����
	 */
	/**
	 * @�޸��� ������
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Map queryMessagePage(Map map) throws Exception{
		Map reMap=new HashMap();
		TurnPage turnPage=(TurnPage)map.get("turnPage");
		
		List<Map> list=(List<Map>)dao.findList("messageMapper.queryMessagePage", map);
		reMap.put("list", list);
		
		long count=(Long)dao.findOne("messageMapper.queryCountMessagePage", map);
		turnPage.setTotal(count);
		return reMap;
	}


	
	/*
	 * �������
	 */
	public Map insertMessage(String connect,String uid,String name) throws Exception{
		
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr=sd.format(date);
	
		Map paraMap=new HashMap();
		
		paraMap.put("mid",  UUID.randomUUID().toString().replace("-", ""));
		paraMap.put("uid", uid);
		paraMap.put("name", name);
		paraMap.put("time", dateStr);
		paraMap.put("connect", connect);
		int i=dao.save("messageMapper.insertMessage", paraMap);
		if(i>0){
			paraMap.put("result", 1);//������Գɹ�
			//throw new Exception("����");
		}else{
		paraMap.put("result", -2);//�������ʧ��	
		}
	//	System.out.println(i);
		
		return paraMap;
	}
	
}
