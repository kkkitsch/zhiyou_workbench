package com.kkk.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Test;
import org.omg.Messaging.SyncScopeHelper;

public class TestProperties {

	@Test
	public void getProperties() throws IOException {
		Properties pro = new Properties();
		// 从文件夹中获取配置文件，优点是可以从任何路径下配置文件
		// InputStream inputStream = new BufferedInputStream(new
		// FileInputStream(new File("config/config.properties")));

		// 第二种方式：从类路径下包中获取配置文件
		InputStream inputStream = TestProperties.class.getClassLoader()
				.getResourceAsStream("com/kkk/properties/config.properties");

		// 第三种方式获取配置文件中key和value的方式
		// ResourceBundle resource = new PropertyResourceBundle(new
		// FileInputStream(new File("config/config.properties")));
		// String value = resource.getString("name");
		// System.out.println(value);

		pro.load(inputStream);
		// 获取配置文件的key
		Enumeration<?> enum1 = pro.propertyNames();

		// 从配置文件中输出单个数据
		System.out.println("输出单个数据: ------------------" + pro.getProperty("name"));

		// 循环输出配置文件中的数据,并判断是否有下一个元素
		print(enum1, pro);
	}

	/*
	 * Java虚拟机（JVM）有自己的系统配置文件（system.properties），我们可以通过下面的方式来获取
	 */
	@Test
	public void systemProperties() {
		Properties pro = System.getProperties();
		Enumeration<?> enum1 = pro.propertyNames();
		// 判断是否有下一个元素
		print(enum1, pro);
	}

	public void print(Enumeration<?> enum1, Properties pro) {
		while (enum1.hasMoreElements()) {
			// 获取当前key
			String strKey = (String) enum1.nextElement();
			// 通过key获取value
			String strValue = pro.getProperty(strKey);
			// 输出
			System.out.println(strKey + "=" + strValue);
		}
	}
}
