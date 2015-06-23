package com.undergrowth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * 自定义处理器
 * 实现Controller接口
 * @author u1
 * 
 * SpringMvc流程  
 * 1、前端控制器--DispatcherServlet的doDispatch方法
 * 2、获取处理器映射器--mappedHandler = getHandler(processedRequest, false);
 * 3、获取处理器适配器--HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
 * 4、处理器处理 返回ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
 * 5、使用视图解析器进行渲染 processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
 * 					render(mv, request, response);
 * 					  view = resolveViewName(mv.getViewName(), mv.getModelInternal(), locale, request);
 * 						view.render(mv.getModelInternal(), request, response);
 * 							renderMergedOutputModel(mergedModel, request, response);
 * 								exposeModelAsRequestAttributes(model, requestToExpose);
 */
public class TestController1 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//创建数据
		List<String> list=new ArrayList<>();
		list.add("qq");
		list.add("ww");
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.setViewName("/WEB-INF/test/test.jsp");
		
		
		return modelAndView;
	}

}
