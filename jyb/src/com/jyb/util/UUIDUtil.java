package com.jyb.util;

import java.util.UUID;

public class UUIDUtil {

	/**
	 * ����32λΨһ�ַ���
	 * @author ������
	 * @ʱ�� 2016-08-02
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
