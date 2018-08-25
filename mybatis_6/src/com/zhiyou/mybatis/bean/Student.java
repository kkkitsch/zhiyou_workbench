package com.zhiyou.mybatis.bean;

public class Student {
	private Integer student_id;
	private String student_name;
	private String student_age;
	private String student_sex;
	private String student_info;
	private Clazz clazz;

	public Student() {
	}

	public String getStudent_age() {
		return student_age;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public String getStudent_info() {
		return student_info;
	}

	public String getStudent_name() {
		return student_name;
	}

	public String getStudent_sex() {
		return student_sex;
	}

	public void setStudent_age(String student_age) {
		this.student_age = student_age;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public void setStudent_info(String student_info) {
		this.student_info = student_info;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setStudent_sex(String student_sex) {
		this.student_sex = student_sex;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_name=" + student_name + ", student_age=" + student_age
				+ ", student_sex=" + student_sex + ", student_info=" + student_info + "]";
	}

}
