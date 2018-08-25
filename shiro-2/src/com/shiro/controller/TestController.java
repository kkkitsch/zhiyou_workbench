package com.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	// 定义一个日志输出器
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	// web环境 - 认证
	@RequestMapping(value = "/login")
	public String test(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {

		System.out.println("用户键入的用户名：" + username + ",密码：" + password);
		// 获取Subject对象，即将登陆的用户
		Subject currentUser = SecurityUtils.getSubject();
		// 判断这个对象是否 是有效的 Authenticated：真实的 有效的
		if (currentUser.isAuthenticated() == false) {
			// 设置一个账号和密码
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			token.setRememberMe(true);
			try {
				// 当执行这个方法时，会在springIoC容器中调用securityManager中的属性realm，执行响应的方法，完成数据的校验
				currentUser.login(token);
				log.info("用户名和密码正确，登录成功");
			} catch (UnknownAccountException e) {
				log.info("账户不存在");
			} catch (IncorrectCredentialsException e) {
				log.info("密码错误");
			} catch (LockedAccountException e) {
				log.info("用户已经锁死");
			} catch (AuthenticationException e) {
				log.info("认证异常");
			}
		} else {
			return "error";
		}
		return "success";
	}
}