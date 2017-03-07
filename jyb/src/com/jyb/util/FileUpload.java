package com.jyb.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	/**
	 * 文件上传，并以唯一32位字符串命名
	 * @author 范立炎
	 * @时间 2016-08-02
	 * @param request
	 * @param multipartFile
	 * @return String
	 */
	public static String fileUpload(HttpServletRequest request, MultipartFile multipartFile){
		String webRoot = request.getSession().getServletContext().getRealPath("");
		File uploadFile = new File(webRoot, "upload");
		if(!uploadFile.exists()){
			uploadFile.mkdirs();
		}
		String newName = UUIDUtil.getUUID() + ".jpg";
		File imgFile = new File(uploadFile, newName);
		try {
			multipartFile.transferTo(imgFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String imgSrc = "./upload/" + newName;
		
		return imgSrc;
	}
}
