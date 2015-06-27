package com.undergrowth.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.undergrowth.dao.UserMapper;

public class UserDaoImpleTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void before(){
		applicationContext=new ClassPathXmlApplicationContext("classpath:config/spring/springmvc.xml");
	}
	
	/**
	 * 使用自定义的Mapper实现完成查询
	 */
	@Test 
	public void test(){
		UserMapper userDaoImple=(UserMapper) applicationContext.getBean("userDao");
		System.out.println(userDaoImple.findUserById(1));
	}
	
	/**
	 * 使用Mapper接口完成查询
	 */
	@Test
	public void testMapper(){
		UserMapper userMapper=(UserMapper) applicationContext.getBean("userMapper");
		System.out.println(userMapper.findUserById(1));
	}
}
