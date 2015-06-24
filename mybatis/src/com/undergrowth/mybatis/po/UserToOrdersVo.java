package com.undergrowth.mybatis.po;

import java.util.List;

public class UserToOrdersVo extends User {
	private List<OrdersToOrderDetailVo> orderList;

	public List<OrdersToOrderDetailVo> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrdersToOrderDetailVo> orderList) {
		this.orderList = orderList;
	}

	@Override
	public String toString() {
		return super.toString()+"UserToOrdersVo [orderList=" + orderList + "]";
	}
	
}
