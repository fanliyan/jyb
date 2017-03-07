package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.util.DateStr;
import com.jyb.util.TurnPage;
import com.jyb.util.UUIDUtil;

@Service("newspaperSrv")
public class newspaperSrv {

	@Resource(name="daoSupport")
	private DaoSupport ds;
	
	/**
	 * �鿴���б�ֽ���ں�
	 * @�޸��� ������
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> selectEditionnum() throws Exception{
		List<Map<String,Object>> list = (List<Map<String,Object>>)ds.findList("newspaperMapper.selectEditionnum");
		return list;
	}
	
	/**
	 * �鿴ĳ�ڱ�ֽ�Ƿ����
	 * @�޸��� ������
	 * @param editionnum
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryEditionnum(String editionnum) throws Exception{
		List<Map<String,Object>> list = (List<Map<String,Object>>)ds.findList("newspaperMapper.queryEditionnum",editionnum);
		return list;
	}
	
	/**
	 * �鿴ĳ��ĳ�汨ֽ�Ƿ����
	 * @�޸��� ������
	 * @param editionnum
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryPagenum(String newspaperid,String pagenum) throws Exception{
		Map map = new HashMap();
		map.put("newspaperid", newspaperid);
		map.put("pagenum", pagenum);	
		List<Map<String,Object>> list = (List<Map<String,Object>>)ds.findList("newspaperMapper.queryPagenum",map);
		return list;
	}
	
	/**
	 * ��ѯ�Ƿ���ĳ�ں�ĳ�������Ϣ
	 * @�޸��� ������
	 * @param editionnum
	 * @param pagenum
	 * @return
	 * @throws Exception
	 */
	public Map selectNespaperPart(String editionnum,String pagenum) throws Exception{
		List<Map> list = (List<Map>)ds.findList("newspaperMapper.queryEditionnum",editionnum);
		Map map = null;
		if(list!=null && !list.isEmpty()){
			map = list.get(0);
			map.put("pagenum", pagenum);
			list = (List<Map>)ds.findList("newspaperMapper.queryPagenum",map);
			if(list!=null && !list.isEmpty()){
				map = list.get(0);
				String imgname = (String)map.get("imgname");
				list = (List<Map>)ds.findList("newspaperMapper.queryPart",map);
				map = new HashMap();
				map.put("result", 1);
				map.put("list", list);
				map.put("imgname", imgname);
			}else{
				map = new HashMap();
				map.put("result", -2);//û�д˰��
			}
		}else{
			map = new HashMap();
			map.put("result", -1);//û�д��ں�
		}
		return map;
	}
	
	/**
	 * �û��ۿ���ֽ
	 * @�޸��� ������
	 * @param editionnum
	 * @param pagenum
	 * @return
	 * @throws Exception
	 */
	public Map toNewspaper(String editionnum,String pagenum,String partid) throws Exception{
		List<Map<String,Object>> list ;
		Map map = null;
		if(partid!=null){
			list = (List<Map<String,Object>>)ds.findList("newspaperMapper.queryEditionPagenum",partid);
			map = list.get(0);
			editionnum = (String)map.get("editionnum");
			pagenum = (String)map.get("pagenum");
		}
		Map reMap = new HashMap();
		list = (List<Map<String,Object>>)ds.findList("newspaperMapper.toNewspaperEditionnum");
		if(list!=null && !list.isEmpty()){
			map = list.get(list.size()-1);
			reMap.put("maxEditionnum", map.get("editionnum"));
			if(editionnum!=null && !"".equals(editionnum)){
				for(Map tMap:list){
					if(tMap.get("editionnum").equals(editionnum)){
						map = tMap;
						break;
					}
				}
			}
			reMap.put("newspaper", map);
			list = (List<Map<String,Object>>)ds.findList("newspaperMapper.toNewspaperPagenum",map);
			if(list!=null && !list.isEmpty()){
				reMap.put("editionList", list);
				map = list.get(list.size()-1);
				reMap.put("maxPagenum", map.get("pagenum"));
				if(pagenum!=null && !"".equals(pagenum)){
					for(Map tMap:list){
						if(tMap.get("pagenum").equals(pagenum)){
							map = tMap;
							break;
						}
					}
				}else{
					map = list.get(0);
				}
				reMap.put("imgname", map.get("imgname"));
				reMap.put("pagenum", map.get("pagenum"));
				list = (List<Map<String,Object>>)ds.findList("newspaperMapper.queryPartSynopsis", map);
				if(list!=null && !list.isEmpty()){
					reMap.put("partList", list);
					reMap.put("result", 1);//�ɹ�					
				}else{
					reMap.put("result", -3);//ĳ�ڱ�ֽĳ��û���ϴ�����
				}
			}else{
				reMap.put("result", -2);//ĳ�ڱ�ֽû�а�
			}
		}else{
			reMap.put("result", -1);//û�б�ֽ
		}
		return reMap;
	}
	
	/**
	 * �鿴�����ڵı�ֽ
	 * @�޸��� ������
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List showNewspaper(Map map) throws Exception{
		TurnPage turnPage = (TurnPage)map.get("turnPage");
		List list = (List)ds.findList("newspaperMapper.showNewspaper",map);
		turnPage.setTotal(list.size());
		return list;
	}
	
	/**
	 * ���ݰ���İ��id��ѯ��Ӧ����Ŀ������
	 * @�޸��� ������
	 * @param partid
	 * @return
	 * @throws Exception
	 */
	public Map selectNewspaperPart(String partid) throws Exception{
		List<Map> list = (List<Map>)ds.findList("newspaperMapper.queryPartContent",partid);
		Map map = list.get(0);
		return map;
	}
	
	/**
	 * �鿴ʱ���ĵ����
	 * @param partid
	 * @throws Exception
	 */
	public void updatePartHits(String partid) throws Exception{
		ds.findList("newspaperMapper.updatePartHits",partid);
	}
	
	/**
	 * ���ݰ���İ��id������Ӧ����Ŀ�����Ĳ������ϴ�ʱ��
	 * @param partid
	 * @param parttitle
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public Map updateNewspaperPart(String partid,String parttitle,String content,String aid) throws Exception{
		Map map = new HashMap();
		map.put("partid", partid);
		map.put("parttitle", parttitle);
		map.put("content", content);
		map.put("aid", aid);
        String dateStr = DateStr.getDateStr();
		map.put("uploadtime", dateStr);
		int result = ds.update("newspaperMapper.updateNewspaperPart", map);
		map.clear();
		map.put("result", result);
		return map;
	}
	
	/**
	 * ������ֽĳ�ںŵİ���
	 * @param list
	 * @param msg
	 * @throws Exception
	 */
	public void insertNewspaperEdition(List<Map> list,Map msg) throws Exception{
		
		if("1".equals(msg.get("pagenum"))){
			ds.update("newspaperMapper.updateNewspaperFirstimg", msg);
		}
		String uuid = UUIDUtil.getUUID();
		msg.put("editionid", uuid);
		ds.save("newspaperMapper.insertNewspaperEdition", msg);
		for(Map map:list){
			map.put("partid",UUIDUtil.getUUID());
			map.put("editionid", uuid);
			String tlhw[] = ((String) map.get("tlhw")).replace("px", "").split("-");
			map.put("t", tlhw[0]);
			map.put("l", tlhw[1]);
			map.put("h", tlhw[2]);
			map.put("w", tlhw[3]);
			map.put("aid",msg.get("aid"));
			ds.save("newspaperMapper.insertNewspaperPart", map);
		}
	}
	
	/**
	 * ������ֽ�ں�
	 * @param editionnum
	 * @throws Exception
	 */
	public void insertNewspaper(String editionnum) throws Exception{
		String uuid = UUIDUtil.getUUID();
        String dateStr = DateStr.getDateStr();
        Map map = new HashMap();
        map.put("newspaperid", uuid);
        map.put("editionnum", editionnum);
        map.put("creattime", dateStr);
		ds.save("newspaperMapper.insertNewspaper", map);
	}
	
	public Map updateNewspaperEdition(String editionnum,String pagenum,String pagetitle) throws Exception{
		Map map = new HashMap();
		map.put("editionnum", editionnum);
		map.put("pagenum", pagenum);
		map.put("pagetitle", pagetitle);
		boolean test = false;
		List<Map<String,Object>> list = (List<Map<String, Object>>) ds.findList("newspaperMapper.toNewspaperEditionnum");
		if(list!=null && !list.isEmpty()){
			if(editionnum!=null && !"".equals(editionnum)){
				for(Map tMap:list){
					if(tMap.get("editionnum").equals(editionnum)){
						map = tMap;
						test = true;
						break;
					}
				}
			}
			if(test){
				test = false;
				list = (List) ds.findList("newspaperMapper.toNewspaperPagenum",map);
				if(list!=null && !list.isEmpty()){
					if(pagenum!=null && !"".equals(pagenum)){
						for(Map tMap:list){
							if(tMap.get("pagenum").equals(pagenum)){
								map = tMap;
								test = true;
								break;
							}
						}
					}
				}
				if(test && pagetitle!=null && !"".equals(pagetitle)){
					map.put("result", 1);
					map.put("pagetitle", pagetitle);
					ds.update("newspaperMapper.updateNewspaperEdition", map);
				}else{
					map.put("result", -3);//û��ĳ�ڸð�
				}
			}else{
				map.put("result", -2);//û�и���
			}
		}else{
			map.put("result", -1);//û�б�ֽ
		}
		return map;
	}


}
