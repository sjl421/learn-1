package com.undergrowth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * �Զ��崦����
 * @author u1
 *
 */
public class TestController1 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//��������
		List<String> list=new ArrayList<>();
		list.add("qq");
		list.add("ww");
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/WEB-INF/test/test.jsp");
		
		
		return modelAndView;
	}

}
