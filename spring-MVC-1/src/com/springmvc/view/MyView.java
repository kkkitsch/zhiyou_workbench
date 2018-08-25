package com.springmvc.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 自定义视图,，默认返回的视图为：myView
 */
@Component
public class MyView implements View {

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.getWriter().print("<h2> this is  my view</h2>");
	}

}
