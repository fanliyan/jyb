package com.jyb.pojo;

/**
 * 
 * @author ������
 * @ʱ�� 2016-08-06
 *
 */
public class Page {

	private int page;     //��ǰ�ڼ�ҳ
	private int rows;     //ÿҳ��ʾ��¼��
	private int firstPage;  //�ڼ�����¼��ʼ
	
	
	public Page(int page, int rows){
		this.page = page;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getFirstPage() {
		firstPage = (page - 1) * rows;
		return firstPage;
	}

	
	
}
