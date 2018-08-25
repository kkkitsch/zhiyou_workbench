package com.zhiyou.mybatis.bean;

public class People {

	private Long id;
	private String name;
	private Long age;
	private String info;
	private Integer status;
	private String sex;

	public People() {
	}

	public Long getAge() {
		return age;
	}

	public Long getId() {
		return id;
	}

	public String getInfo() {
		return info;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", info=" + info + ", status=" + status + ", sex=" + sex + "]";
	}

}
