package com.spring.proxy;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
// @Order(1) //切面的优先级，使用接口就不需要使用注解啦
public class AOP_AspectJ implements Ordered {

	// 在before方法当中可以加上参数：JoinPoint jp，来访问当前连接点的细节
	@Before("execution(public int com.spring.proxy.ComputerImp.add(int,	 int))")
	public void before(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法之前调用......" + "参数为：" + Arrays.asList(args));
	}

	// 针对所有方法
	@Before("execution(public * com.spring.proxy.ComputerImp.*(..))")
	public void beforeAll(JoinPoint jp) {
		// 获取调用方法的参数,Object对象数组，因为参数可能不止一个
		Object[] args = jp.getArgs();
		// 获取方法的签名---> 获取方法名
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法之前调用......" + "参数为：" + Arrays.asList(args));
	}

	// 后置通知：无论方法正确执行还是抛出异常，后置方法都会执行
	@After("execution(public int com.spring.proxy.ComputerImp.*(..))")
	public void afterAll(JoinPoint jp) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法之后调用......" + "参数为：" + Arrays.asList(args));
	}

	// 返回通知：无论方法正确执行还是抛出异常，后置方法都会执行
	// 在返回通知中获取方法执行后的返回值：在AfterReturning标注中添加returning属性，属性值和返回通知中的参数值保持一致，添加此属性的作用为获取目标对象（被代理对象）的返回值
	@AfterReturning(pointcut = "getExecution()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法正常返回结果之后调用...结果为" + result + "，参数为：" + Arrays.asList(args));
	}

	// 异常通知：参考返回通知，用法都相似
	@AfterThrowing(pointcut = "execution(public int com.spring.proxy.ComputerImp.*(..))", throwing = "ex")
	public void exception(JoinPoint jp, Exception ex) {
		Object[] args = jp.getArgs();
		String methodName = jp.getSignature().getName();
		System.out.println(methodName + "方法执行出现异常：" + ex.getMessage() + "，方法参数为：" + Arrays.asList(args));
	}

	// 环绕通知:可以控制是否执行这个连接点,需要在通知方法的参数列表中，提供一个ProceedingJoinPoint接口类型的形参
	/*@Around("execution(public int com.spring.proxy.ComputerImp.*(..))")
	public void around(ProceedingJoinPoint pjp) {
		try {
			// 模拟前置通知
			System.out.println("前置通知方法...");

			// 如果不加这个方法，目标方法不会执行，通知方法会执行
			pjp.proceed();

			// 模拟返回通知
			System.out.println("返回通知方法...");

		} catch (Throwable e) {
			// 模拟异常通知
			System.out.println("异常通知方法...");
			e.printStackTrace();
		} finally {
			// 模拟后置通知
			System.out.println("后置通知方法...");
		}
	}*/

	@Override
	public int getOrder() {
		return 1;
	}

	// 重用切点表达式
	@Pointcut("execution(public * com.spring.proxy.ComputerImp.*(..))")
	public void getExecution() {
	}

}
