package com.undergrowth.collection;

public enum Operation {
	ADD("+"),MINUS("-"),MULTI("*"),DIVIDE("/");
	
	private String name;
	
	Operation(String name){
		this.name=name;
	}

	public String getName() {
		return name;
	}
	
	
}
