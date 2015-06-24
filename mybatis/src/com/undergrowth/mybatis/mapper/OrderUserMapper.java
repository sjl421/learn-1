package com.undergrowth.mybatis.mapper;

import java.util.List;

import com.undergrowth.mybatis.po.OrdersUser;
import com.undergrowth.mybatis.po.OrdersUserDetailPojo;
import com.undergrowth.mybatis.po.OrdersUserPojo;
import com.undergrowth.mybatis.po.UserToOrdersVo;

/**
 * Í¨¹ý
 * @author u1
 *
 */
public interface OrderUserMapper {

	public List<OrdersUser> findOrdersUserByResultType();
	public List<OrdersUserPojo> findOrdersUserByResultMap();
	public List<OrdersUserDetailPojo> findOrderUserDetailResultMap();
	public List<UserToOrdersVo> findUserAndItemsResultMap();
}
