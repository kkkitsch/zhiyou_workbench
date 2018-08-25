package com.springmvc.handler;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.springmvc.pojo.Account;
import com.springmvc.pojo.User;

@Controller
@RequestMapping("helloWorldHandler")
// @SessionAttributes(value = { "city" }) // 只添加city模型数据到session中
@SessionAttributes(types = String.class) // 添加所有String类型的模型数据到session中
public class HelloWorldHandler {

	/**
	 * 控制器处理请求的业务方法的格式: public String 方法名称() { } String :当前方法处理完毕之后，所要返回的逻辑视图名称
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.GET, params = { "name!=kkkitsch", "age!=21" }, headers = {
			"accept=text/html" })
	public String helloWorld() {
		System.out.println("走入到了hello方法当中");
		return "success";
	}

	/**
	 * Ant风格的请求映射
	 */
	@RequestMapping("/*/antStyl?")
	public String antStyle() {
		return "success";
	}

	/**
	 * rest风格
	 */
	@RequestMapping("/pathVariable/{id}")
	public String pathVariable(@PathVariable(value = "id") int id) {
		System.out.println("进入到pathVariable方法......");
		System.out.println("id=" + id);
		return "success";
	}

	/**
	 * test GET
	 */
	@RequestMapping(value = "testGet/{id}", method = RequestMethod.GET)
	public String testGet(@PathVariable(value = "id") int id) {
		// 模拟的操作
		System.out.println("test Get 方法，id为" + id);
		return "success";
	}

	/**
	 * test POST
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String testPost() {
		// 模拟的操作
		System.out.println("Test POST 方法");
		return "success";
	}

	/**
	 * test DELETE
	 */
	@RequestMapping(value = "/delete/{age}", method = RequestMethod.DELETE)
	public String testDelete(@PathVariable(value = "age") int age) {
		// 模拟的操作
		System.out.println("Test DELETE方法,age=" + age);
		return "success";
	}

	/**
	 * test PUT REST风格传入多个参数
	 */
	@RequestMapping(value = "/put/{age}/{name}", method = RequestMethod.PUT)
	public String testPut(@PathVariable(value = "age") int age, @PathVariable(value = "name") String name) {
		// 模拟的操作
		System.out.println("Test PUT方法,age=" + age + ",name=" + name);
		return "success";
	}

	/**
	 * test getRequestParam
	 */
	@RequestMapping(value = "/testRequestParam", method = RequestMethod.POST)
	public String testRequestParam(@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "name") String name) {
		// 模拟的操作
		System.out.println("id=" + id + ",name=" + name);
		return "success";
	}

	/**
	 * test testRequestParamByPojo
	 */
	@RequestMapping(value = "/testRequestParamByPojo", method = RequestMethod.POST)
	public String testRequestParamByPojo(User user) {
		// 模拟的操作
		System.out.println("id=" + user.getId() + ",name=" + user.getName());
		return "success";
	}

	/**
	 * test testRequestParamByPojo_01 级联属性操作
	 */
	@RequestMapping(value = "/testRequestParamByPojo_01", method = RequestMethod.POST)
	public String testRequestParamByPojo_01(User user) {
		// 模拟的操作
		System.out.println(user);
		return "success";
	}

	/**
	 * 获取cookie值
	 */
	@RequestMapping(value = "/getCookieValue", method = RequestMethod.GET)
	public String getCookieValue(@CookieValue(value = "JSESSIONID") String cookie) {
		System.out.println("cookie值：" + cookie);
		return "success";
	}

	/**
	 * 获取getServletAPI
	 */
	@RequestMapping(value = "/getServletAPI", method = RequestMethod.GET)
	public String getServletAP(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request);
		System.out.println(response);
		return "success";
	}

	/**
	 * 获取getRequestHeader
	 */
	@RequestMapping(value = "/getRequestHeader", method = RequestMethod.GET)
	public String getRequestHeader(@RequestHeader("Accept") String accept) {
		System.out.println("accept" + accept);
		return "success";
	}

	/**
	 * 测试ModelAndView
	 * 
	 * 导入的jar包：import org.springframework.web.servlet.ModelAndView;
	 */
	@RequestMapping(value = "/ModelAndView", method = RequestMethod.GET)
	public ModelAndView testModelAndView() {
		ModelAndView mv = new ModelAndView();

		// 添加返回的视图
		mv.setViewName("success");

		// 添加的模型数据的值放在request范围当中
		mv.addObject("name", "kkkitsch");
		return mv;
	}

	/**
	 * 测试testMap
	 */
	@RequestMapping(value = "/testMap", method = RequestMethod.GET)
	public String testMap(Map<String, Object> map) {

		// map当中的值会自动地添加到request请求对象当中，作为属性值
		map.put("age", 21);
		System.out.println(map.get("age"));
		return "success";
	}

	/**
	 * 测试testModel
	 */
	@RequestMapping(value = "/testModel", method = RequestMethod.GET)
	public String testModel(Model model) {
		model.addAttribute("email", "llh@qq.com");
		return "success";
	}

	/**
	 * 测试testModelMap
	 */
	@RequestMapping(value = "/testModelMap", method = RequestMethod.GET)
	public String testModelMap(ModelMap modelMap) {
		modelMap.addAttribute("city", "郑州");
		return "success";
	}

	/**
	 * testResult
	 */
	@RequestMapping(value = "/testResult", method = RequestMethod.GET)
	public String testResult() {
		return "result";
	}

	/**
	 * testModelAttribute
	 * 
	 * 在方法参数中，如果不加注解：@ModelAttribute(value = "nice")，只有Account
	 * account，那么会自动关联Account类，并且会从request请求范围内查找是否有类的首字母小
	 * 写的模型属性，如果有，就自动关联属性了，如果没有，会把页面表单中获取到的值和pojo中的属性关联，
	 * 
	 * 在方法参数中，如果加了注解：@ModelAttribute(value = "nice")，那么会根据value值进行关联
	 */
	@RequestMapping(value = "/modelAttribute")
	public String testModelAttribute(@ModelAttribute(value = "kkk") Account account) {
		System.out.println(account);
		return "success";
	}

	/**
	 * 练习@ModelAttribute修饰无返回值方法
	 * 
	 * 有@ModelAttribute注解时，会先执行这个方法
	 * 
	 * 为什么放在request请求范围内的模型属性可以在@ModelAttribute中找到
	 */
	@ModelAttribute
	public void start(Map<String, Object> map) {
		// 真是情况中应该从数据库中获取，这里只是简单模拟
		Account account = new Account(007, "kkk", "2018-09-09");
		map.put("nice", account);
	}

	/**
	 * 练习@ModelAttribute修饰有返回值方法
	 * 
	 * 有@ModelAttribute注解时，会先执行这个方法
	 * 
	 * 为什么放在request请求范围内的模型属性可以在@ModelAttribute中找到
	 */
	@ModelAttribute(value = "kkk")
	public Account start_01() {
		// 真是情况中应该从数据库中获取，这里只是简单模拟
		Account account = new Account(007, "kkk", "2018-09-09");
		return account;
	}

	/**
	 * 测试要跳转的jsp文件中包含JSTL标签，如果直接访问jstl.jsp页面，springMVC容器会认为只是单纯的访问一个jsp页面，
	 * 不会执行springMVC.xml文件
	 * 
	 * 另外 一种方法是直接给jsp页面定义一个映射
	 */
	@RequestMapping(value = "/testJSTL")
	public String testJSTL() {
		return "jstl";
	}

	@RequestMapping(value = "/testMyView")
	public String testMyView() {
		return "myView";
	}

}
