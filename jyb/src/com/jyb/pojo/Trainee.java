package com.jyb.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author ������
 * @ʱ�� 2016-08-06
 *
 */
public class Trainee {

	private String tid;
	private String aid;
	private String time;
	private String name;
	private String major;
	private String city;
	private String company;	
	private String photo;        //�ϴ�ͼƬ�ı���·��
	private String title;
	private String connect;
	private Integer view_num;
	
	private MultipartFile file;  //�ϴ�ͼƬ�ı����ԣ���ʵϰ��ʵ������
	private String aname; //����Ա��������ʵϰ��ʵ������
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConnect() {
		return connect;
	}
	public void setConnect(String connect) {
		this.connect = connect;
	}
	public Integer getView_num() {
		return view_num;
	}
	public void setView_num(Integer view_num) {
		this.view_num = view_num;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
}
