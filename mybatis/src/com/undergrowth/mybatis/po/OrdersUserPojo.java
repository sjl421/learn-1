package com.undergrowth.mybatis.po;

public class OrdersUserPojo extends Orders {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return super.toString() + "OrdersUserPojo [user=" + user + "]";
	}

}
