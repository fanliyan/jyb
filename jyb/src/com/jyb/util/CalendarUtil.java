package com.jyb.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
    
	/**
	 * ��ʽ����ǰʱ��
	 * @author ������
	 * @ʱ�� 2016-08-02
	 * @return 
	 */
	public static String getCurrentDate(){
		Calendar calendar =  Calendar.getInstance();
		Date currentDate = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 return sdf.format(currentDate);
	}
}
