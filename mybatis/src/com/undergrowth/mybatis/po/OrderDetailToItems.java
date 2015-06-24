package com.undergrowth.mybatis.po;

public class OrderDetailToItems extends OrderDetail {
	private Items items;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return super.toString() + "OrderDetailToItems [items=" + items + "]";
	}

}
