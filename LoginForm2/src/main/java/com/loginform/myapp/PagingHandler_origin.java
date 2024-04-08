package com.loginform.myapp;

import org.springframework.beans.factory.annotation.Autowired;

public class PagingHandler_origin {
	private int totalCnt;
	private int totalPage;
	private int showBoard = 10;
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalCnt) {
		this.totalCnt = doPaging(totalCnt);
	}

	private int doPaging(int totalCnt) {
		this.totalPage = this.totalCnt / 10 + (this.totalCnt % 10 > 0 ? 1 : 0);
		return this.totalPage;
	}
	
}
