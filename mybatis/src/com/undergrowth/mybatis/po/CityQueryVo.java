package com.undergrowth.mybatis.po;

import java.util.List;

/**
 * ��װ�û���ѯ������
 * @author u1
 *
 */
public class CityQueryVo {
	private City city;
	private List<Integer> ids;
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
}
