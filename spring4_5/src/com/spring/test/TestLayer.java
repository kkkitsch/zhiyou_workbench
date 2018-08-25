package com.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import com.spring.beans.MyAction;
import com.spring.util.SpringUtil;

public class TestLayer {

	ApplicationContext ac;

	@Before
	public void init() {
		ac = SpringUtil.getApplicationContext();
	}

	@Test
	public void test() {
		MyAction action = (MyAction) ac.getBean("myAction");
		action.execute();
	}

}
