package com.jyb.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {
    /**
     * ����ҳ�洫���ĸ��ֲ������������װ��Map��
     * @author ������
     * @ʱ�� 2016-08-06
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
