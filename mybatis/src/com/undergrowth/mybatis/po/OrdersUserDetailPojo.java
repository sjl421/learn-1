package com.undergrowth.mybatis.po;

import java.util.List;

public class OrdersUserDetailPojo extends OrdersUserPojo {

	// ʹ���б�Ԫ�����ڴ�Ŷ�����ϸ
	private List<OrderDetail> orderDetails;

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return super.toString() + "OrdersUserDetailPojo [orderDetails="
				+ orderDetails + "]";
	}

}
