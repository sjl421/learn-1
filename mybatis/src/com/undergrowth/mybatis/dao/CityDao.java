package com.undergrowth.mybatis.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.undergrowth.mybatis.mapper.CityMapper;
import com.undergrowth.mybatis.po.City;
import com.undergrowth.mybatis.po.CityQueryVo;
import com.undergrowth.mybatis.util.SqlSessionUtil;

/**
 * Dao的测试类
 * 
 * @author u1
 *
 */
public class CityDao {

	/**
	 * 通过ID查找对象
	 */
	@Test
	public void fetchByCityById() {
		SqlSession sqlSession = null;
		City city = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			city = cityMapper.fetchByCityById(3);
			System.out.println(city);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	/**
	 * 通过模糊查询
	 */
	@Test
	public void findCityByName() {
		SqlSession sqlSession = null;
		City city = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// 使用Mapper进行查询 使用接口更加清晰 明了
			/*
			 * CityMapper cityMapper=sqlSession.getMapper(CityMapper.class);
			 * List<City> citys=cityMapper.findCityByName("und");
			 * System.out.println(citys);
			 */
			// 使用sqlsession进行查询
			List<City> citys = sqlSession.selectList("findCityByName", "und");
			System.out.println(citys);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	/**
	 * 查找数目
	 */
	@Test
	public void findCityCount() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// 使用Mapper进行查询 使用接口更加清晰 明了

			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			CityQueryVo vo = new CityQueryVo();
			City city = new City();
			city.setName("und");
			vo.setCity(city);
			int num = cityMapper.findCityCount(vo);
			System.out.println(num);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	/**
	 * 通过id集合查找数目
	 */
	@Test
	public void findCityCountByIds() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// 使用Mapper进行查询 使用接口更加清晰 明了

			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			CityQueryVo vo = new CityQueryVo();
			City city = new City();
			city.setName("und");
			vo.setCity(city);
			List<Integer> ids = Arrays.asList(1, 2, 3, 4, 5, 6);
			vo.setIds(ids);
			int num = cityMapper.findCityCountByIds(vo);
			System.out.println(num);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	@Test
	public void findCityByHashmap() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// 使用Mapper进行查询 使用接口更加清晰 明了

			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			Map<String, Object> hashmap=new HashMap<String, Object>();
			hashmap.put("id", "1");
			hashmap.put("name", "");
			City city=cityMapper.findCityByHashmap(hashmap);
			System.out.println(city);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}
	
	/**
	 * 插入对象
	 */
	@Test
	public void insertCity() {
		SqlSession sqlSession = null;
		City city = new City();
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			city.setName("under");
			city.setCountryCode("AFG");
			city.setDistrict("china");
			city.setPopulation(10000);
			cityMapper.insertCity(city);
			System.out.println("成功插入");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	
	
	/**
	 * 获取插入后的id
	 */
	@Test
	public void insertCityAfter() {
		SqlSession sqlSession = null;
		City city = new City();
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			city.setName("ww");
			city.setCountryCode("AFG");
			city.setDistrict("guangzhou");
			city.setPopulation(10000);
			cityMapper.insertCityAfter(city);
			System.out.println("成功插入");
			System.out.println(city.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	/**
	 * 修改对象
	 */
	@Test
	public void updateCity() {
		SqlSession sqlSession = null;
		City city = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			city = cityMapper.fetchByCityById(3);
			city.setPopulation(10000);
			System.out.println(city);
			cityMapper.updateCity(city);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	/**
	 * 移除对象
	 */
	@Test
	public void removeCityById() {
		SqlSession sqlSession = null;
		City city = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
			cityMapper.removeCityById(4);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

}
