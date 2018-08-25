package com.zhiyou.bean;

import java.util.HashSet;
import java.util.Set;

public class User {

	private Long user_id;
	private String user_name;
	private String user_password;
	private String user_state;

	// 用Set集合来存多个角色
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String user_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public Long getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_password=" + user_password
				+ ", user_state=" + user_state + "]";
	}

	/*
	 * @Override public String toString() { return "User [user_id=" + user_id +
	 * ", user_code=" + ", user_name=" + user_name + ", user_password=" +
	 * user_password + ", user_state=" + user_state + ", roles=" + roles + "]";
	 * }
	 */

}
