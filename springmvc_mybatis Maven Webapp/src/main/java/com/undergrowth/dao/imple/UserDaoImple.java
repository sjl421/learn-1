package com.undergrowth.dao.imple;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.undergrowth.dao.UserMapper;
import com.undergrowth.po.User;
import com.undergrowth.po.UserExample;

/**
 * * mybatis与spring的合并
 * 1、spring帮mybatis管理数据源、事务
 * 2、spring帮mybatis管理sqlSessionFactory、sqlSession的创建、销毁
 * 3、spring帮mybatis管理Mapper接口文件和Mapper文件的映射
 * @author u1
 *
 * mybatis的自定义dao实现和Mapper编程的区别
 * 1、自定义dao需要实现Mapper接口，继承SqlSessionDaoSupport，注入sqlSessionFactory，即可获取sqlSession
 * 2、Mapper编程接口直接从spring容器中获取首字母小写的Mapper代理对象，操作即可
 * 3、相同点：sqlSessionFactory和sqlSession均有spring容器管理
 * @author u1
 *
 */
public class UserDaoImple extends SqlSessionDaoSupport implements UserMapper {

	
    
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=this.getSqlSession();
		User user=sqlSession.selectOne("findUserById",id);
		return user;
	}

	public int countByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByExample(@Param("record") User record,
			@Param("example") UserExample example) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
