package com.springmvc.handler;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;

import com.springmvc.pojo.Person;
import com.springmvc.pojo.User;

@Controller
//@RequestMapping("defined")
public class TestHandler {

	@RequestMapping(value = "/testConversionService")
	public String testConversionService(User user) {
		System.out.println(user);
		return "success";
	}

	/*
	 * 从前端传来的数据可以进行类型转换，格式化处理，数据验证，还可以利用BindingResult捕捉错误消息
	 * 
	 * 进行数据验证的时候，参数中与前端属性绑定的对象的前面 要加上标注：@valid
	 * 
	 * 如果参数中含有BindingResult对象，那么要和User对象相连，否则会出现错误
	 */
	@RequestMapping("/testFormat")
	public String testFormat(@Valid User user, BindingResult result) {

		/*
		 * 在控制器中捕获错误消息，还可以在前端输出错误消息
		 */
		if (result.getFieldErrorCount() > 0) {
			List<FieldError> fieldError = result.getFieldErrors();
			for (FieldError fieldError2 : fieldError) {
				System.out.println(fieldError2.getField() + ":" + fieldError2.getDefaultMessage());
			}
		}

		System.out.println(user);
		return "format";
	}

	/*
	 * 含有 <form:form />表单的jsp页面不能直接访问，否则会出现错误，可以通过一个url来访问，这个方法的作用就是这个
	 */
	@RequestMapping("/formError")
	public String testFormError(Map<String, Object> map) {
		User user = new User();
		user.setName("lll");
		map.put("user", user);
		return "format";
	}

	/*
	 * 在java代码中获取国际化信息
	 */
	@RequestMapping("/testGlobal")
	public String testGlobal(HttpServletRequest request) {
		RequestContext context = new RequestContext(request);
		String message = context.getMessage("user.name");
		System.out.println(message);
		return "success";
	}

	/*
	 * springmvc对ajax的支持：在业务方法中获取ajax发送的请求数据，发送数据到ajax中
	 */
	@ResponseBody
	@RequestMapping("/testRequestBody")
	public List<Person> testRequestBody(@RequestBody List<Person> person) {
		System.out.println(person);
		return person;
	}

}
