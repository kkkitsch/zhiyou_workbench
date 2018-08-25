package com.spring.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 定义一个bean
@Scope // 给bean指定作用域
public class CarFactory {

	@Autowired // 按照类型进行匹配

	// 将bean的id为 benz 的子类传递给car，不指定会报错，因为ICar有两个实现类，car对象不知道调用哪个
	@Qualifier("benz")
	private ICar car;

	public String toString() {
		return car.getCarName();
	}
}
