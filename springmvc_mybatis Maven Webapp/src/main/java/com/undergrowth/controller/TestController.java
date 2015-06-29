package com.undergrowth.controller;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.undergrowth.po.User;
import com.undergrowth.po.UserExample;
import com.undergrowth.service.TestService;

/**
 * * SpringMvc流程  
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
 * 
 * 设计思路
 * spring管理控制器(表现层)，管理Service实现(业务层)，管理Dao实现(持久层)
 * 控制器中注入Service实现，用Service接口进行关联，Service实现中注入Dao实现，用Dao接口关联
 * 
 * @author u1
 * @Date  2015-6-28
 */
@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/test.action")
	public ModelAndView test(){
		ModelAndView modelAndView=new ModelAndView();
		User user=testService.findUserById(1);
		modelAndView.addObject("user", user);
		modelAndView.addObject("test", 12);
		modelAndView.setViewName("/test/test");
		return modelAndView;
	}
	
	@RequestMapping("/countByExample.action")
	public ModelAndView  countByExample(){
		ModelAndView modelAndView=new ModelAndView();
		UserExample example=new UserExample();
		example.createCriteria().andIdEqualTo(27);
		int num=testService.countByExample(example);
		modelAndView.addObject("num", num);
		modelAndView.setViewName("/test/test");
		return modelAndView;
	}
	
	@RequestMapping("/deleteByExample.action")
	public ModelAndView  deleteByExample(){
		ModelAndView modelAndView=new ModelAndView();
		UserExample example=new UserExample();
		example.createCriteria().andIdEqualTo(27);
		int num=testService.deleteByExample(example);
		modelAndView.addObject("num", num);
		modelAndView.setViewName("/test/test");
		return modelAndView;
	}
	
	@RequestMapping("/insert.action")
	public ModelAndView  insert(){
		ModelAndView modelAndView=new ModelAndView();
		UserExample example=new UserExample();
		User record=new User();
		record.setAddress("番禺区");
		record.setSex("男");
		record.setBirthday(new Date());
		record.setUsername("好好学习");
		int num=testService.insert(record);
		modelAndView.addObject("num", num);
		modelAndView.setViewName("/test/test");
		return modelAndView;
	}
	
	@RequestMapping("/updateByPrimaryKey.action")
	public ModelAndView  updateByPrimaryKey(){
		ModelAndView modelAndView=new ModelAndView();
		User record=testService.selectByPrimaryKey(28);
		record.setUsername("天天向上");
		int num=testService.updateByPrimaryKey(record);
		modelAndView.addObject("num", num);
		modelAndView.setViewName("/test/test");
		return modelAndView;
	} 
/*
	    int deleteByExample(UserExample example);

	    int deleteByPrimaryKey(Integer id);

	    int insert(User record);

	    int insertSelective(User record);

	    List<User> selectByExample(UserExample example);

	    User selectByPrimaryKey(Integer id);

	    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	    int updateByPrimaryKeySelective(User record);

	    int updateByPrimaryKey(User record);*/
	
}
