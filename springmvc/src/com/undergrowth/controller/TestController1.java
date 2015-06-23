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
 * �Զ��崦����
 * ʵ��Controller�ӿ�
 * @author u1
 * 
 * SpringMvc����  
 * 1��ǰ�˿�����--DispatcherServlet��doDispatch����
 * 2����ȡ������ӳ����--mappedHandler = getHandler(processedRequest, false);
 * 3����ȡ������������--HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());
 * 4������������ ����ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
 * 5��ʹ����ͼ������������Ⱦ processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
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
