package com.javaweb.entity;

import java.util.List;

public class PageBean {

	//总的页数
	private Integer totalPage;
	//当前页
	private Integer currentPage;
	//每页的数据 
	private List<User> userList;
	
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@Override
	public String toString() {
		return "PageBean [totalPage=" + totalPage + ", currentPage=" + currentPage + ", userList=" + userList + "]";
	}
	
	
	
}
