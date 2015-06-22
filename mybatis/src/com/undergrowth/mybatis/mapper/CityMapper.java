package com.undergrowth.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.undergrowth.mybatis.po.City;
import com.undergrowth.mybatis.po.CityQueryVo;

/**
 * Mapper�ӿ�
 * Mapper���������Լ���дDaoʵ��
 * 1����ȡ��Daoʵ�ִ�����ģ�����
 * 2��������statement��Ӳ����
 * 3�������˲����Ĵ���ΪObject���ڱ���ʱ���ܼ������Ͳ���ȷ
 * 4�������������Զ�ת��
 * 
 * Mapper��Mapper�ӿ��ļ���Mapper�������ļ���ѭ����
 * 1��Mapper�������ļ���namespaceֵ��Mapper�ӿ��ļ��İ�һ��
 * 2��Mapper�����ļ���statement�ı����Mapper�ӿ��ļ��ķ�����һ��
 * 3��Mapper�����ļ���statement��parameterType��������Mapper�ӿ��ļ��ķ������������һ��
 * 4��Mapper�����ļ���statement��resultType��������Mapper�ӿ��ļ��ķ����ķ���ֵ����һ��
 * @author u1
 *
 */
public interface CityMapper {

	public City fetchByCityById(int id);

	public List<City> findCityByName(String name);

	public void removeCityById(int id);

	public void insertCity(City city);

	public void insertCityAfter(City city);

	public void updateCity(City city);

	public int findCityCount(CityQueryVo vo);

	public int findCityCountByIds(CityQueryVo vo);
	
	public City findCityByHashmap(Map<String, Object> hashmap);
}
