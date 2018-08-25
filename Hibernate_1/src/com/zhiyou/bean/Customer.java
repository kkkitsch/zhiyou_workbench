package com.zhiyou.bean;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private Long cust_id;
	private String cust_name;
	private String cust_level;
	private String cust_linkman;
	private String cust_phone;
	private String cust_mobile;
	private String cust_address;

	// bean中对应的一对多关系表示
	private Set<LinkMan> linkMans = new HashSet<LinkMan>();

	public Customer() {

	}

	public String getCust_address() {
		return cust_address;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public String getCust_level() {
		return cust_level;
	}

	public String getCust_linkman() {
		return cust_linkman;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public String getCust_name() {
		return cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public Set<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public void setCust_level(String cust_level) {
		this.cust_level = cust_level;
	}

	public void setCust_linkman(String cust_linkman) {
		this.cust_linkman = cust_linkman;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public void setLinkMans(Set<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}

	// 多表操作使用这条toString语句
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_level=" + cust_level
				+ ", cust_linkman=" + cust_linkman + ", cust_phone=" + cust_phone + ", cust_mobile=" + cust_mobile
				+ ", cust_address=" + cust_address + ", linkMans=" + linkMans + "]";
	}

	// 单表操作使用这条toString语句
	/*
	 * @Override public String toString() { return "Customer [cust_id=" +
	 * cust_id + ", cust_name=" + cust_name + ", cust_industry=" +
	 * ", cust_level=" + cust_level + ", cust_linkman=" + cust_linkman +
	 * ", cust_phone=" + cust_phone + ", cust_mobile=" + cust_mobile +
	 * ", cust_address=" + cust_address + "]"; }
	 */
}
