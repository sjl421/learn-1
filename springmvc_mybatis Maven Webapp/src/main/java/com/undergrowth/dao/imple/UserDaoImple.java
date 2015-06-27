package com.undergrowth.dao.imple;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.undergrowth.dao.UserMapper;
import com.undergrowth.pojo.User;

public class UserDaoImple extends SqlSessionDaoSupport implements UserMapper {

	

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession=this.getSqlSession();
		User user=sqlSession.selectOne("findUserById",id);
		return user;
	}

}
