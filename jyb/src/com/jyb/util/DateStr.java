package com.jyb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStr {

	/**
	 * ���ݱ�������ʱ���ַ���
	 * @return
	 */
	public static String getDateStr(){
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   
		return sdf.format(d);
	}
}
