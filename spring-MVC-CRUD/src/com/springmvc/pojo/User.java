package com.springmvc.pojo;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class User {

	private String name;

	// hibernate-validate 验证框架
	@Range(min = 1, max = 100)
	private Integer age;

	/*
	 * 进行数据格式化处理
	 * 
	 * 如果不指名pattern，那么输入pattern类型的数字时， 会出现错误，指明之后，既可以单纯地输入纯数字，也可以输入带 , . 类型的数字
	 */
	@NumberFormat(pattern = "###,###,###.##")
	private Double salary;

	/*
	 * 进行格式化处理、JSR303数据验证
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date birth;

	// hibernate-validate 框架验证
	@Email
	private String email;

	public User() {
	}

	public Integer getAge() {
		return age;
	}

	public Date getBirth() {
		return birth;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", salary=" + salary + ", birth=" + birth + ", email=" + email
				+ "]";
	}

}
