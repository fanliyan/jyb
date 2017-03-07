package com.jyb.util;


/**
 * 
 * @author 范立炎
 * @时间 2016-08-06
 *
 */
public class TurnPage {

	/**
	 * 当前页面的记录数
	 */
	private int rowInOnePage = 10;

	/**
	 * 数据的总共数
	 */
	private long total;

	/**
	 * 当前页数
	 */
	private int pageNum = 1;

	/**
	 * 总共页数
	 */
	private int pageCount = 0;
	
	/**
	 * 执行查询时，其实的记录数
	 */
	private int startNum=0;
	/**
	 * 
	 */
	public TurnPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TurnPage(int rowInOnePage){
		this.rowInOnePage=rowInOnePage;
	}
	/**
	 * @return Returns the pageCount.
	 */
	public int getPageCount() {
		long tmp = total/(new Long(rowInOnePage)).longValue();
		pageCount = (new Long(tmp)).intValue();
		if((total%rowInOnePage)>0)
			pageCount++;
		return pageCount;
	}
	/**
	 * @param pageCount The pageCount to set.
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return Returns the pageNum.
	 */
	public int getPageNum() {
		return pageNum;
	}
	/**
	 * @param pageNum The pageNum to set.
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	/**
	 * @return Returns the rowInOnePage.
	 */
	public int getRowInOnePage() {
		return rowInOnePage;
	}
	/**
	 * @param rowInOnePage The rowInOnePage to set.
	 */
	public void setRowInOnePage(int rowInOnePage) {
		this.rowInOnePage = rowInOnePage;
	}
	/**
	 * @return Returns the total.
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total The total to set.
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	public int getStartNum() {
		startNum=(pageNum-1)*rowInOnePage;
		return startNum;
	}

}
