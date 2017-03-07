package com.jyb.custom;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;



public class CustomObjectMapper extends ObjectMapper{
	
	/**
	 * 格式化日期以全局解决数据库datetime类型以json返回页面后变成一串数字问题，需要修改springmvc配置文件
	 * @author 范立炎
	 * @时间 2016-08-06
	 */
	public CustomObjectMapper(){
		CustomSerializerFactory factory = new CustomSerializerFactory();
		 factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {

			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator,
					SerializerProvider provider) throws IOException,
					JsonProcessingException {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				jsonGenerator.writeString(sdf.format(value));
			}
			 
		});
	   this.setSerializerFactory(factory);
	}
}
