package com.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import com.springmvc.pojo.User;

public class StringToUserConverter implements Converter<String, User> {

	// TOM-12-#,###.##
	public User convert(String source) {

		String[] array = source.split("-");
		User user = new User();
		user.setName(array[0]);
		user.setAge(Integer.parseInt(array[1]));

		if (array != null && array.length == 3) {
			if (array[2].contains(",")) {
				String a[] = array[2].split(",");
				String b = "";
				for (int i = 0; i < a.length; i++) {
					b = b + a[i];
				}
				array[2] = b;
			}
			user.setSalary(Double.parseDouble(array[2]));
			return user;
		}

		return null;
	}
}
