package com.jyb.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author 范立炎
 * @时间 2016-08-06
 *
 */
public class UrlKit {

	/**
	 * 获取url，格式：http://ip:port/contextPath，如果port是80，不显示
	 * @param request
	 * @return
	 */
	public static String getURL(HttpServletRequest request){
		String basePath = request.getScheme()+"://"+request.getServerName();
		String path = request.getContextPath();
		int port=request.getServerPort();
		if("/".equals(path)){
			path="";
		}
		if(port!=80){
			basePath=basePath+":"+port;
		}
		basePath=basePath+path;
//		String basePath2 = basePath;
//		basePath=basePath+"/";
		return basePath;
	}
	public static String getDomain(HttpServletRequest request){
		return getURL(request);
	}
	/**
	 * 结尾带斜杠
	 * @param request
	 * @return
	 */
	public static String getDomainSlash(HttpServletRequest request){
		return getURL2(request);
	}
	/**
	 * 获取url，格式：http://ip:port/contextPath/，如果port是80，不显示
	 * @param request
	 * @return
	 */
	public static String getURL2(HttpServletRequest request){
		return getURL(request)+"/";
	}
}
