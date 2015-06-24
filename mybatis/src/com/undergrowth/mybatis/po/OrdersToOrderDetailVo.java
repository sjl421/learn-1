package com.undergrowth.mybatis.po;

import java.util.List;

public class OrdersToOrderDetailVo extends Orders {
	private List<OrderDetailToItems> orderDetailList;

	public List<OrderDetailToItems> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetailToItems> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	@Override
	public String toString() {
		return super.toString() + "OrdersToOrderDetailVo [orderDetailList="
				+ orderDetailList + "]";
	}

}
