package com.springmvc.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.springmvc.pojo.Department;

public class DepartmentDAO {

	private static Map<Integer, Department> depts;

	static {
		depts = new HashMap<Integer, Department>();
		depts.put(1, new Department(1, "销售"));
		depts.put(2, new Department(2, "市场"));
	}

	public static Collection<Department> getAllDepts() {
		return depts.values();
	}

	public static Department getDeptById(Integer id) {
		return depts.get(id);
	}

}
