package com.undergrowth.collection;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1>o2) return 1;
		if(o1<o2) return -1;
		return 0;
	}

	
}
