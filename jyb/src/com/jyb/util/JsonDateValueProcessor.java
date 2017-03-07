package com.jyb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * �����json�������ݿ�datetime���ͱ��һ���������⣨�˹���û���ϣ�
 * @ʱ�� 2016-08-06
 * @author ������
 *
 */
public class JsonDateValueProcessor implements JsonValueProcessor {

	private String format;
	
	public JsonDateValueProcessor() {
	}
	
	public JsonDateValueProcessor(String format){
		this.format = format;
	}
	
	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		String[] obj = {};
		if(value instanceof Date[]){
			SimpleDateFormat sf = new SimpleDateFormat(format);
			Date[] dates = (Date[]) value;
			obj = new String[dates.length];
			for(int i = 0; i < dates.length; i++){
				obj[i] = sf.format(dates[i]);
			}
		}
		return obj;
	}

	@Override
	public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
		if(value instanceof Date){
			String str = new SimpleDateFormat(format).format((Date) value);
			return str;
		}
		return value.toString();
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

}