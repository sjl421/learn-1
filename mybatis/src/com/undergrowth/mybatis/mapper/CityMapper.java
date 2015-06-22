package com.undergrowth.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.undergrowth.mybatis.po.City;
import com.undergrowth.mybatis.po.CityQueryVo;

/**
 * Mapper接口
 * Mapper编程相比于自己编写Dao实现
 * 1、提取了Dao实现大量的模板代码
 * 2、避免了statement的硬编码
 * 3、避免了参数的传递为Object，在编译时即能检测出类型不正确
 * 4、传出参数的自动转换
 * 
 * Mapper的Mapper接口文件与Mapper的配置文件遵循规则
 * 1、Mapper的配置文件的namespace值与Mapper接口文件的包一致
 * 2、Mapper配置文件的statement的编号与Mapper接口文件的方法名一致
 * 3、Mapper配置文件的statement的parameterType的类型与Mapper接口文件的方法的入参类型一致
 * 4、Mapper配置文件的statement的resultType的类型与Mapper接口文件的方法的返回值类型一致
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
