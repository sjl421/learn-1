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
 * Dao�Ĳ�����
 * 
 * @author u1
 *
 */
public class CityDao {

	/**
	 * ͨ��ID���Ҷ���
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
	 * ͨ��ģ����ѯ
	 */
	@Test
	public void findCityByName() {
		SqlSession sqlSession = null;
		City city = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// ʹ��Mapper���в�ѯ ʹ�ýӿڸ������� ����
			/*
			 * CityMapper cityMapper=sqlSession.getMapper(CityMapper.class);
			 * List<City> citys=cityMapper.findCityByName("und");
			 * System.out.println(citys);
			 */
			// ʹ��sqlsession���в�ѯ
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
	 * ������Ŀ
	 */
	@Test
	public void findCityCount() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// ʹ��Mapper���в�ѯ ʹ�ýӿڸ������� ����

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
	 * ͨ��id���ϲ�����Ŀ
	 */
	@Test
	public void findCityCountByIds() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionUtil
					.getSqlSessionFactory("mybatis-conf.xml").openSession();
			// ʹ��Mapper���в�ѯ ʹ�ýӿڸ������� ����

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
			// ʹ��Mapper���в�ѯ ʹ�ýӿڸ������� ����

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
	 * �������
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
			System.out.println("�ɹ�����");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}

	}

	
	
	/**
	 * ��ȡ������id
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
			System.out.println("�ɹ�����");
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
	 * �޸Ķ���
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
	 * �Ƴ�����
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
