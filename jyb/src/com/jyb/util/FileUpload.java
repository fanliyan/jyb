package com.jyb.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

	/**
	 * �ļ��ϴ�������Ψһ32λ�ַ�������
	 * @author ������
	 * @ʱ�� 2016-08-02
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
