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
 * 测试代码 
 * resuType--将sql的列名和pojo的属性进行一一的映射
 *  resultMap--可以避免使用resultType方式的重复记录
 * association--将sql列映射到pojo对象中 collection--将关联信息映射到list列表中
 * association、collection都具备延时加载功能 mybatis具有二级缓存
 * SqlSession--一级缓存，当SqlSession未关闭时，使用key-value的形式存储对象，当进行增加、删除、修改时，都会清空一级缓存中的数据
 * Mapper命名空间--二级缓存，二级缓存的接口为Cache
 * ，mybatis提供的二级缓存默认实现为PerpetualCache，以Mapper的命名空间为单位进行缓存
 * ，可跨多个SqlSession，当SqlSession关闭时
 * ，将一级缓存的对象写入到二级缓存，要进行二级缓存的对象必须序列化，因为二级缓存不一定在内存中，可能在硬盘
 *  当进行增加、删除、修改时，都会清空二级缓存中的数据
 *  useCache="true"  
 *  flushCache="true"
 *  mybatis二级缓存的数据力度不够细粒
 * @author u1
 * 
 */
public class OrderUserMapperDao {

	SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void before() throws IOException {
		sqlSessionFactory = SqlSessionUtil
				.getSqlSessionFactory("mybatis-conf.xml");
	}

	/**
	 * 使用resultType进行一对一的映射
	 */
	@Test
	public void testOneToOne() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OrderUserMapper orderUserMapper = sqlSession
					.getMapper(OrderUserMapper.class);
			List<OrdersUser> ordersUsers = orderUserMapper
					.findOrdersUserByResultType();
			for (OrdersUser ordersUser : ordersUsers) {
				System.out.println(ordersUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 使用resultMap进行一对一的映射
	 */
	@Test
	public void testOneToOneResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OrderUserMapper orderUserMapper = sqlSession
					.getMapper(OrderUserMapper.class);
			List<OrdersUserPojo> ordersUsers = orderUserMapper
					.findOrdersUserByResultMap();
			for (OrdersUserPojo ordersUser : ordersUsers) {
				System.out.println(ordersUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 使用resultMap和collection进行一对多的映射
	 */
	@Test
	public void findOrderUserDetailResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OrderUserMapper orderUserMapper = sqlSession
					.getMapper(OrderUserMapper.class);
			List<OrdersUserDetailPojo> ordersUsers = orderUserMapper
					.findOrderUserDetailResultMap();
			for (OrdersUserDetailPojo ordersUser : ordersUsers) {
				System.out.println(ordersUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 使用resultMap和collection association进行多对多的映射
	 */
	@Test
	public void findUserAndItemsResultMap() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OrderUserMapper orderUserMapper = sqlSession
					.getMapper(OrderUserMapper.class);
			List<UserToOrdersVo> ordersUsers = orderUserMapper
					.findUserAndItemsResultMap();
			for (UserToOrdersVo ordersUser : ordersUsers) {
				System.out.println(ordersUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 延时加载
	 */
	@Test
	public void findOrderUserLazyLoading() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			OrderUserMapper orderUserMapper = sqlSession
					.getMapper(OrderUserMapper.class);
			List<OrdersUserPojo> ordersUsers = orderUserMapper
					.findOrderUserLazyLoading();
			for (OrdersUserPojo ordersUser : ordersUsers) {
				System.out.println(ordersUser);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 测试二级缓存
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCache() throws IOException {
		SqlSession sqlSession = SqlSessionUtil.getSqlSessionFactory(
				"mybatis-conf.xml").openSession();
		OrderUserMapper mapper = sqlSession.getMapper(OrderUserMapper.class);
		System.out.println("第一次查询订单用户");
		List<OrdersUser> ordersUsers = mapper.findOrdersUserByResultType();
		for (OrdersUser ordersUser : ordersUsers) {
			System.out.println(ordersUser);
		}
		// 关闭一级缓存
		sqlSession.close();
		// 如果未使用二级缓存 此时再次查询 会输出查询语句
		sqlSession = SqlSessionUtil.getSqlSessionFactory("mybatis-conf.xml")
				.openSession();
		mapper = sqlSession.getMapper(OrderUserMapper.class);
		System.out.println("第二次查询");
		ordersUsers = mapper.findOrdersUserByResultType();
		for (OrdersUser ordersUser : ordersUsers) {
			System.out.println(ordersUser);
		}
		sqlSession.close();
	}
}
