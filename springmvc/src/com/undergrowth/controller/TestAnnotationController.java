package com.undergrowth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试注解处理器映射器与处理器适配器
 * @author u1
 *
 */
@Controller
public class TestAnnotationController {

	@RequestMapping("/test3.action")
	public ModelAndView test(){
		List<String> list=new ArrayList<>();
		list.add("qq");
		list.add("ww");
		list.add("ee");
		list.add("rr");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/WEB-INF/test/test.jsp");
		return modelAndView;
	}
	
}
