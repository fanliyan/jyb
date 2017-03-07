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

@Service("ArticleSrv") // 涓庣被鍚嶇浉鍚岋紝纭繚鍞竴鎬�
public class ArticleSrv<text, date> {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 * @修改人 范立炎
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map exuteFindList(Map map) throws Exception {// 鏄剧ず鍏ㄩ儴鏍囬
		Map reMap = new HashMap();
		TurnPage turnPage = (TurnPage) map.get("turnPage");
		List list = (List)dao.findList("articleMapper.selectArtitleTitleList", map);
		reMap.put("list", list);

		long count = (Long) dao.findOne("articleMapper.queryCountArticlePage", map);
		turnPage.setTotal(count);

		return reMap;
	}
	
	/**
	 * @author 李丽梅
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public Map ArticleIndex(Map map) throws Exception{
		Map reMap = new HashMap();
		List<Map> list = (List<Map>)dao.findList("articleMapper.queryArticleSome", map);
		reMap.put("list", list);
		return reMap;
	}
	
	/**
	 * @author 李丽梅
	 * @param title
	 * @param connect
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map exuteAdd(String title, text connect,text keyword, String aid) throws Exception {// 娣诲姞
		Map reMap = new HashMap();
		Map paraMap = new HashMap();

		// 鑾峰彇褰撳墠绯荤粺鏃堕棿锛堜笂浼狅級
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sd.format(date);

		paraMap.put("id", UUID.randomUUID().toString().replace("-", ""));
		paraMap.put("title", title);
		paraMap.put("connect", connect);
		paraMap.put("keyword", keyword);
		paraMap.put("time", dateStr);
		paraMap.put("status_0_1", 0);
		paraMap.put("aid", aid);
		// paraMap.put("keyview_num", view_num);
		int i = dao.save("articleMapper.insertArticle", paraMap);
		if (i > 0) {
			reMap.put("result", 1);// 娣诲姞鎴愬姛
		} else {
			reMap.put("result", -2);// 娣诲姞澶辫触
		}
		return reMap;
	}
	
	/**
	 * @author 李丽梅
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map exuteFindOne(String id) throws Exception {// 鏍规嵁id 鏌ユ壘锛堢紪杈戦渶瑕侊級
		dao.update("articleMapper.updateArticleViewNum", id);
		Map reMap = (Map) dao.findOne("articleMapper.selectArtitleById", id);
		return reMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map exuteUpdate(String id, String title, String connect,String aid) throws Exception {
		Map reMap = new HashMap();
		Map paraMap = new HashMap();

		paraMap.put("keyid", id);
		paraMap.put("keytitle", title);
		paraMap.put("keyconnect", connect);
		paraMap.put("aid", aid);

		int i = dao.update("articleMapper.updateArticle", paraMap);
		if (i > 0) {
			reMap.put("result", 1);// 淇敼鎴愬姛
		} else {
			reMap.put("result", -2);// 淇敼澶辫触
		}
		return reMap;
	}

	public Map exuteUpdateStatus_0_1(String id) throws Exception {
		Map reMap = new HashMap();
		Map paraMap = new HashMap();

		int i = dao.update("articleMapper.updateArticleStatus_0_1", id);
		if (i > 0) {
			reMap.put("result", 1);
		} else {
			reMap.put("result", -2);
		}
		return reMap;
	}

	public Map exuteUpdateStatus_1_0(String id) throws Exception {
		Map reMap = new HashMap();
		int i = dao.update("articleMapper.updateArticleStatus_1_0", id);
	
		if (i > 0) {
			reMap.put("result", 1);
		} else {
			reMap.put("result", -2);
		}
		return reMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map exuteDelete(String id) throws Exception {
		Map reMap = new HashMap();
		int i = dao.delete("articleMapper.deleteArticleById", id);
		if (i > 0) {
			reMap.put("result", 1);
		} else {
			reMap.put("result", -2);
		}
		return reMap;
	}
}
