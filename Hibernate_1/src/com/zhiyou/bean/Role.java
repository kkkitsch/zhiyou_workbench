package com.zhiyou.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {

	private Long role_id;
	private String role_name;
	private String role_memo;

	// 用Set集合来存放多个用户
	private Set<User> users = new HashSet<>();

	public Role() {

	}

	public Long getRole_id() {
		return role_id;
	}

	public String getRole_memo() {
		return role_memo;
	}

	public String getRole_name() {
		return role_name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public void setRole_memo(String role_memo) {
		this.role_memo = role_memo;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_memo=" + role_memo + ", users=" + users
				+ "]";
	}
}
