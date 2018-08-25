package com.zhiyou.mybatis.bean;

import java.util.Date;
import java.util.List;

public class Clazz {

	private Integer clazz_id;
	private String clazz_name;
	private String clazz_info;
	private Date clazz_buildtime;

	private List<Student> students;

	public Clazz() {
	}

	public Date getClazz_buildtime() {
		return clazz_buildtime;
	}

	public Integer getClazz_id() {
		return clazz_id;
	}

	public String getClazz_info() {
		return clazz_info;
	}

	public String getClazz_name() {
		return clazz_name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setClazz_buildtime(Date clazz_buildtime) {
		this.clazz_buildtime = clazz_buildtime;
	}

	public void setClazz_id(Integer clazz_id) {
		this.clazz_id = clazz_id;
	}

	public void setClazz_info(String clazz_info) {
		this.clazz_info = clazz_info;
	}

	public void setClazz_name(String clazz_name) {
		this.clazz_name = clazz_name;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Clazz [clazz_id=" + clazz_id + ", clazz_name=" + clazz_name + ", clazz_info=" + clazz_info
				+ ", clazz_buildtime=" + clazz_buildtime + "]";
	}

}
