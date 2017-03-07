package com.jyb.util;

import java.util.UUID;

public class UUIDUtil {

	/**
	 * 生成32位唯一字符串
	 * @author 范立炎
	 * @时间 2016-08-02
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
