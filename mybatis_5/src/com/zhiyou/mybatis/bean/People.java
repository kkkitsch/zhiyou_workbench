package com.zhiyou.mybatis.bean;

public class People {
	private Long id;

	private String name;

	private Long age;

	private String info;

	private Integer status;

	private String sex;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info == null ? null : info.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", age=" + age + ", info=" + info + ", status=" + status
				+ ", sex=" + sex + "]";
	}

}