package com.springmvc.pojo;

public class Employee {

	private Integer id;
	private String name;
	private String mail;
	private Integer gender;
	private Department dept;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name, String mail, Integer gender, Department dept) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.gender = gender;
		this.dept = dept;
	}

	public Department getDept() {
		return dept;
	}

	public Integer getGender() {
		return gender;
	}

	public Integer getId() {
		return id;
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mail=" + mail + ", gender=" + gender + ", dept=" + dept
				+ "]";
	}
}
