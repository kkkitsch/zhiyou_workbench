package com.spring.proxy;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class AOP_AspectJ {

	// 在before方法当中可以加上参数：JoinPoint jp，来访问当前连接点的细节
	public void before(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法之前调用......" + "参数为：" + Arrays.asList(args));
	}

	public void beforeAll(JoinPoint jp) {
		// 获取调用方法的参数,Object对象数组，因为参数可能不止一个
		Object[] args = jp.getArgs();
		// 获取方法的签名---> 获取方法名
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法之前调用......" + "参数为：" + Arrays.asList(args));
	}

	public void afterAll(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法之后调用......" + "参数为：" + Arrays.asList(args));
	}

	public void afterReturning(JoinPoint jp, Object result) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法正常返回结果之后调用...结果为" + result + "，参数为：" + Arrays.asList(args));
	}

	// 异常通知：参考返回通知，用法都相似
	public void exception(JoinPoint jp, Exception ex) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法执行出现异常：" + ex.getMessage() + "，方法参数为：" + Arrays.asList(args));
	}

}
