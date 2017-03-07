package com.jyb.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jyb.dao.DaoSupport;
import com.jyb.util.TurnPage;

@Service("IndexService")
public class IndexService {

	@Resource(name="daoSupport")
	private DaoSupport dao;
	
	
	/**
	 * Õ¾ÄÚËÑË÷
	 * @author ·¶Á¢Ñ×
	 * @param map
	 * @return Map
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map querySearch(Map map) throws Exception{
		Map reMap = new HashMap();
		TurnPage turnPage = (TurnPage)map.get("turnPage");
		List<Map> list = (List<Map>)dao.findList("indexSearchMapper.selectonsite", map);
		reMap.put("list", list);
		long count = (Long)dao.findOne("indexSearchMapper.getselectonsiteTotal", map);
	    turnPage.setTotal(count);
		return reMap;
	}
	
}
