/**
 * 
 */
package com.undergrowth.service.imple;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.undergrowth.dao.UserMapper;
import com.undergrowth.po.User;
import com.undergrowth.po.UserExample;
import com.undergrowth.service.TestService;

/**
 * @author u1
 * @Date  2015-6-28
 */
@Service
public class TestServiceImple implements TestService {

	@Autowired
	private UserMapper userMapper;
	
	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#countByExample(com.undergrowth.po.UserExample)
	 */
	public int countByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.countByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#deleteByExample(com.undergrowth.po.UserExample)
	 */
	public int deleteByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.deleteByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#deleteByPrimaryKey(java.lang.Integer)
	 */
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#insert(com.undergrowth.po.User)
	 */
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#insertSelective(com.undergrowth.po.User)
	 */
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#selectByExample(com.undergrowth.po.UserExample)
	 */
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#selectByPrimaryKey(java.lang.Integer)
	 */
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#updateByExampleSelective(com.undergrowth.po.User, com.undergrowth.po.UserExample)
	 */
	public int updateByExampleSelective(@Param("record") User record,
			@Param("example") UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.updateByExampleSelective(record, example);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#updateByExample(com.undergrowth.po.User, com.undergrowth.po.UserExample)
	 */
	public int updateByExample(@Param("record") User record,
			@Param("example") UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.updateByExample(record, example);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#updateByPrimaryKeySelective(com.undergrowth.po.User)
	 */
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(record);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#updateByPrimaryKey(com.undergrowth.po.User)
	 */
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	/* (non-Javadoc)
	 * @see com.undergrowth.dao.UserMapper#findUserById(int)
	 */
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}

}
