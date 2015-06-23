package com.undergrowth.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/**
 * ʵ��HttpRequestHandler�ӿ�
 * @author u1
 *
 */
public class TestHttpRequestController implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��������
		List<String> list = new ArrayList<>();
		list.add("qq");
		list.add("ww");
		list.add("ee");
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/test/test.jsp").forward(request, response);
	}

}
