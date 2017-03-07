package com.jyb.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    /**
     * 接收页面传来的各种参数，并将其封装至Map中
     * @author 范立炎
     * @时间 2016-08-06
     * @param request
     * @return Map
     */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map getParameterMap(HttpServletRequest request){
		Map reMap = new HashMap();
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = request.getParameter(name);
			String[] values = request.getParameterValues(name);
			if(values.length == 1){
				reMap.put(name, value);
			}else{
				reMap.put(name, values);
			}
		}
		return reMap;
	}
}
