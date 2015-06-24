package com.undergrowth.mybatis.po;

import java.util.Date;

public class OrdersUser extends Orders {
	private String username;
	private Date birthday;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return super.toString() + "[username=" + username + ", birthday="
				+ birthday + "]";
	}
}
