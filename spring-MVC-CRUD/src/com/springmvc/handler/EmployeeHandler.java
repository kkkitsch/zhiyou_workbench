package com.springmvc.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.DepartmentDAO;
import com.springmvc.dao.EmployeeDAO;
import com.springmvc.pojo.Employee;

@Controller
public class EmployeeHandler {

	private final String SUCCESS = "success";
	private final String INPUT = "input";

	/*
	 * 查询所有雇员
	 */
	@RequestMapping(value = "/allEmployee", method = RequestMethod.GET)
	public String allEmployee(Map<String, Object> map) {

		map.put("emps", EmployeeDAO.getAllEmps());
		return SUCCESS;
	}

	/*
	 * 跳转到input.jsp页面，并且测试回显数据
	 */
	@RequestMapping(value = "/input/{id}", method = RequestMethod.GET)
	public String input(@PathVariable(value = "id") Integer id, Map<String, Object> map) {

		Map<Integer, Object> genders = new HashMap<Integer, Object>();
		genders.put(0, "MALE");
		genders.put(1, "FAMALE");
		map.put("genders", genders);

		Employee employee = new Employee();
		if (id != 0) {
			employee = EmployeeDAO.getEmpById(id);
		}

		// 往input.jsp页面中加入回显数据
		map.put("abc", employee);

		map.put("depts", DepartmentDAO.getAllDepts());
		return INPUT;
	}

	/*
	 * 增加雇员
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public String add(Employee emp) {
		EmployeeDAO.save(emp);
		return "redirect:/allEmployee";
	}

	/*
	 * 在数据绑定的时候进行一些操作
	 */
	@InitBinder
	public void testInitBinder(WebDataBinder binder) {

		// 不允许绑定的数据对象
		binder.setDisallowedFields("");
	}

	/*
	 * 删除雇员信息
	 */
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable(value = "id") Integer id) {
		EmployeeDAO.delete(id);

		// 要加上 /
		return "redirect:/allEmployee";
	}

	/*
	 * 修改雇员信息
	 */
	@RequestMapping(value = "/emp", method = RequestMethod.PUT)
	public String update(Employee emp) {

		/*
		 * 参数emp从前台页面当中映射了属性：id name mail gender dept.depId
		 * 
		 * 值得注意的是： 当映射部门的时候，只映射了部门属性的id值，所以，此时的部门属性是空的
		 * 需要在EmployeeDAO.update()方法中手动添加部门属性
		 */
		// 将emp的id属性和没有部门属性的emp传入到update方法
		EmployeeDAO.update(emp.getId(), emp);
		return "redirect:/allEmployee";
	}

	/*
	 * 如果形参名字与请求参数名称一致，在方法的参数中可以省略@RequestParam
	 */
	@ModelAttribute
	public void attr(Integer id, Map<String, Object> map) {
		if (id != null) {
			Employee emp = EmployeeDAO.getEmpById(id);
			map.put("employee", emp);
		}
	}

}
