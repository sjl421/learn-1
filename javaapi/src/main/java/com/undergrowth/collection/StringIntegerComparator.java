package com.undergrowth.collection;

import java.util.Comparator;

/**
 * ���ڽ�String���͵�����ת��ΪInteger ���бȽ�
 * @author Administrator
 *
 */
public class StringIntegerComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(Integer.valueOf(o1)>Integer.valueOf(o2)) return 1;
		if(Integer.valueOf(o1)<Integer.valueOf(o2)) return -1;
		return 0;
	}

}
