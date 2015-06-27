package com.undergrowth.dao;

import com.undergrowth.pojo.User;

/**
 * mybatis与spring的合并
 * 1、spring帮mybatis管理数据源、事务
 * 2、spring帮mybatis管理sqlSessionFactory、sqlSession的创建、销毁
 * 3、spring帮mybatis管理Mapper接口文件和Mapper文件的映射
 * @author u1
 *
 * mybatis的自定义dao实现和Mapper编程的区别
 * 1、自定义dao需要实现Mapper接口，继承SqlSessionDaoSupport，注入sqlSessionFactory，即可获取sqlSession
 * 2、Mapper编程接口直接从spring容器中获取首字母小写的Mapper代理对象，操作即可
 * 3、相同点：sqlSessionFactory和sqlSession均有spring容器管理
 */
public interface UserMapper {
	public User findUserById(int id);
}
