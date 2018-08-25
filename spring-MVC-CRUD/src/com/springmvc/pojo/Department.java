package com.springmvc.pojo;

public class Department {

	private Integer depId;
	private String depName;

	public Department() {
	}

	public Department(Integer depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

	public Integer getDepId() {
		return depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + "]";
	}

}
