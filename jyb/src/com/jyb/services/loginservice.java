package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;

@Service("loginservice")
public class loginservice {
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
	 * @return
	 * @throws Exception
	 */
	 public Map executlogin(String name,String pwd) throws Exception{
		int i=name.length();//���Գ��ȣ�����Ա8λ���£���ͨ�û�����8λ
		 Map reMap=new HashMap();
		 List<Map> list =null;
		 if(i>=8){
			  list=(List<Map>)ds.findList("userMapper.selectUserWhere1", name);
			 
		 }else{
	
			   list=(List<Map>)ds.findList("userMapper.selectUserWhere2", name);
		 }
			if(list!=null && !list.isEmpty()){
				Map m=list.get(0);
				String password=(String)m.get("password");
				String username=(String)m.get("name");
				String aid = (String)m.get("aid");
				reMap.put("aid", aid);
				String status=(String)m.get("status");//״̬
				reMap.put("status", status);
				if(password.equals(pwd)){
					reMap.put("loginResult", 1);
					reMap.put("list", list);
				/*
				 * �����ж��û����ǹ���Ա
				 * ���� ��0
				 * �û� ��1
				 * ����Ա ��2
				 * ��������Ա ��3
				 * ��Ϊע��Ķ�����ͨ�û�
				 * ע��Ĭ��status=1
				 * 
				 */
					
					if(status.equals("0")){
						reMap.put("resultstatus", 0);
					}else if(status.equals("1")){
						reMap.put("resultstatus", 1);
					}else if(status.equals("2")){
						reMap.put("resultstatus", 2);
					}else if(status.equals("3")){
						reMap.put("resultstatus", 3);
					}
				}else{
					reMap.put("loginResult", -2);
					reMap.put("resultstatus", 8);
				}
			}else{
				reMap.put("loginResult", -1);
				reMap.put("resultstatus", 100);
			}
		
		 return reMap;
		 
	 }
}
