package com.zhiyou.mybatis.dao;

import java.util.List;

import com.zhiyou.mybatis.bean.Clazz;
import com.zhiyou.mybatis.bean.Student;

public interface StudentMapper {

	// 根据id查询某个学生，不包含学生班级信息
	Student getStudentById(int id);

	// 根据班级id查询此班级的所有学生
	List<Student> getStudentByClazzId(int id);

	// 根据id查询某个学生，包含学生班级信息，返回类型为结果集
	Student getStudentWithClass(int id);

	// 根据id查询某个学生，包含学生班级信息，返回类型为bean对象
	Student getStudentWithClass1(int id);

	// 根据id查询clazz，涉及student的查询，返回类型为结果集
	Clazz getClazzById(int id);

	// 根据id查询clazz，不涉及student的查询，返回类型为bean对象
	Clazz getClazzById1(int id);

	// 嵌套查询 查询学生信息，以及延迟加载
	Student getStudentClazzByStep(int id);

}
