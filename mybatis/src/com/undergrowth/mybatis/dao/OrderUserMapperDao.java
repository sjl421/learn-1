package com.undergrowth.mybatis.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.undergrowth.mybatis.mapper.OrderUserMapper;
import com.undergrowth.mybatis.po.OrdersUser;
import com.undergrowth.mybatis.po.OrdersUserDetailPojo;
import com.undergrowth.mybatis.po.OrdersUserPojo;
import com.undergrowth.mybatis.po.UserToOrdersVo;
import com.undergrowth.mybatis.util.SqlSessionUtil;


/**
 * ���Դ���
 * resuType--��sql��������pojo�����Խ���һһ��ӳ��
 * resultMap--���Ա���ʹ��resultType��ʽ���ظ���¼
 * 		association--��sql��ӳ�䵽pojo������
 * 		collection--��������Ϣӳ�䵽list�б���
 * @author u1
 *
 */
public class OrderUserMapperDao {

	SqlSessionFactory sqlSessionFactory=null;
	
	@Before
	public void before() throws IOException{
		sqlSessionFactory=SqlSessionUtil.getSqlSessionFactory("mybatis-conf.xml");
	}
	
	
	/**
	 * ʹ��resultType����һ��һ��ӳ��
	 */
	@Test
	public void testOneToOne(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			OrderUserMapper  orderUserMapper=sqlSession.getMapper(OrderUserMapper.class);
			List<OrdersUser> ordersUsers=orderUserMapper.findOrdersUserByResultType();
			for (OrdersUser ordersUser : ordersUsers) {
				System.out.println(ordersUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	
	/**
	 * ʹ��resultMap����һ��һ��ӳ��
	 */
	@Test
	public void testOneToOneResultMap(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			OrderUserMapper  orderUserMapper=sqlSession.getMapper(OrderUserMapper.class);
			List<OrdersUserPojo> ordersUsers=orderUserMapper.findOrdersUserByResultMap();
			for (OrdersUserPojo ordersUser : ordersUsers) {
				System.out.println(ordersUser); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * ʹ��resultMap��collection����һ�Զ��ӳ��
	 */
	@Test
	public void findOrderUserDetailResultMap(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			OrderUserMapper  orderUserMapper=sqlSession.getMapper(OrderUserMapper.class);
			List<OrdersUserDetailPojo> ordersUsers=orderUserMapper.findOrderUserDetailResultMap();
			for (OrdersUserDetailPojo ordersUser : ordersUsers) {
				System.out.println(ordersUser); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * ʹ��resultMap��collection association���ж�Զ��ӳ��
	 */
	@Test
	public void findUserAndItemsResultMap(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			OrderUserMapper  orderUserMapper=sqlSession.getMapper(OrderUserMapper.class);
			List<UserToOrdersVo> ordersUsers=orderUserMapper.findUserAndItemsResultMap();
			for (UserToOrdersVo ordersUser : ordersUsers) {
				System.out.println(ordersUser); 
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
}
