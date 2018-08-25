package com.zhiyou.mybatis.bean;

public class ClassStudent {

	private Integer c_id;
	private String class_name;
	private Integer s_id;
	private String student_name;

	public ClassStudent() {
	}

	public Integer getC_id() {
		return c_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public Integer getS_id() {
		return s_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	@Override
	public String toString() {
		return "ClassStudent [c_id=" + c_id + ", class_name=" + class_name + ", s_id=" + s_id + ", student_name="
				+ student_name + "]";
	}
}
