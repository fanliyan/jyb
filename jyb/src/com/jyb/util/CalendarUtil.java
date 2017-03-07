package com.jyb.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    
	/**
	 * 格式化当前时间
	 * @author 范立炎
	 * @时间 2016-08-02
	 * @return 
	 */
	public static String getCurrentDate(){
		Calendar calendar =  Calendar.getInstance();
		Date currentDate = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return sdf.format(currentDate);
	}
}
