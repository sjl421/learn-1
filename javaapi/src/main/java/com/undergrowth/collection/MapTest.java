package com.undergrowth.collection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

import org.junit.Before;
import org.junit.Test;



/**
 * Map����
 * HashMap--key-value,����ʱ��������Ԫ�ص�˳��
 * LinkedHashMap--ʹ��˫����������Ԫ�أ�����ʽ������Ԫ�ص�˳��
 * IdentityHashMap--�Ƚ�key��ʱ��ʹ����������ж�����������
 * WeakHashMap--��key����ʹ��ʱ���Ƴ�������Ķ���
 * Hashtable--�κηǿյĶ����ܹ���Ϊkey����value
 * Properties--�ܹ������м��ػ��߱��浽����
 * TreeMap--����ʱ����֤Ԫ�ص�˳��,ͬʱԪ��Ҳ�ǰ���˳���ŷŵ�
 * EnumMap--ʹ��ö��������Ϊkey
 * @author Administrator
 *
 */
public class MapTest {
	
	Map<String,String> hashMap,linkedHashMap,identityHashMap,weakHashMap,hashtable,treeMap;
	EnumMap<Operation, String> enumMap;
	Properties properties;
	
	@Before
	public void before() throws IOException{
		//��������
		hashMap=new HashMap<String, String>();
		linkedHashMap=new LinkedHashMap<String, String>();
		identityHashMap=new IdentityHashMap<String, String>();
		weakHashMap=new WeakHashMap<String, String>();
		hashtable=new Hashtable<String, String>();
		properties=new Properties();
		treeMap=new TreeMap<String, String>();
		enumMap=new EnumMap<Operation, String>(Operation.class);
		//���г�ʼ��
		initiMap(hashMap);
		initiMap(linkedHashMap);
		initiMap(identityHashMap);
		initiMap(weakHashMap);
		initiMap(hashtable);
		initiMap(treeMap);
		//��ʼ��Properties
		InputStream isInputStream=ClassLoader.getSystemResourceAsStream("test.properties");
		properties.load(isInputStream);
		//��ʼ��EnumMap
		initEnumMap(enumMap);
	}

	/**
	 * ��ʼ��EnumMap
	 * @param enumMap
	 */
	private void initEnumMap(EnumMap<Operation, String> enumMap) {
		// TODO Auto-generated method stub
		enumMap.put(Operation.ADD, "+");
		enumMap.put(Operation.MINUS, "-");
		enumMap.put(Operation.MULTI, "*");
		enumMap.put(Operation.DIVIDE, "/");
	}

	/**
	 * ��ʼ��Map
	 * @param map
	 */
	private void initiMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		map.put("q", "qq");
		map.put("w", "ww");
		map.put("e", "ee");
		map.put("r", "rr");
		map.put("t", "tt");
		map.put("y", "yy");
	}
	
	/**
	 * ����Map
	 */
	@Test
	public void testIteratorMap(){
			iteratorMap(hashMap);
			iteratorMap(linkedHashMap);
			iteratorMap(identityHashMap);
			iteratorMap(weakHashMap);
			iteratorMap(hashtable);
			iteratorMap(treeMap);
			iteratorProperties(properties);
	}

	/**
	 * ����Properties
	 * @param properties2
	 */
	private void iteratorProperties(Properties properties2) {
		// TODO Auto-generated method stub
		Set<Entry<Object, Object>> sets=properties2.entrySet();
		System.out.print(sets.getClass().getName()+"\t");
		for (Entry<Object, Object> entry : sets) {
			System.out.print(entry.getKey()+":"+entry.getValue()+"\t");
		}
		System.out.println();
	}

	/**
	 * ����Map
	 * @param map
	 */
	private void iteratorMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		System.out.print(map.getClass().getName()+"\t");
		for (Map.Entry<String, String> entry:map.entrySet()) {
			System.out.print(entry.getKey()+":"+entry.getValue()+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ����Set
	 * @param keySet
	 */
	private void iteratorSet(NavigableSet<String> keySet) {
		// TODO Auto-generated method stub
		System.out.print(keySet.getClass().getName()+"\t");
		for (String string : keySet) {
			System.out.print(string+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ���Կɵ�����Map
	 */
	@Test
	public void testNavigableMap(){
		iteratorMap(treeMap);
		TreeMap<String, String> treeMapCopy=(TreeMap<String, String>) treeMap;
		//���������Map
		iteratorMap(treeMapCopy.descendingMap());
		NavigableSet<String> keySet=treeMapCopy.descendingKeySet();
		//���������key
		iteratorSet(keySet);
		//��ȡ��Map
		System.out.print("��ȡС��t��ֵ��Map�Ӽ���"+"\t");
		iteratorMap(treeMapCopy.headMap("t"));
		System.out.print("��ȡ����t��ֵ��Map�Ӽ���"+"\t");
		iteratorMap(treeMapCopy.tailMap("t"));
		System.out.print("��ȡ���ķ�Χ[t,y)֮���Map�Ӽ���"+"\t");
		iteratorMap(treeMapCopy.subMap("t","y"));
		//��ȡkey
		System.out.print("��ȡ���ڵ���t��ֵ��key"+"\t");
		System.out.println(treeMapCopy.ceilingKey("t"));
		System.out.print("��ȡС�ڵ���t��ֵ��key"+"\t");
		System.out.println(treeMapCopy.floorKey("t"));
		System.out.print("��ȡ����t��ֵ��key"+"\t");
		System.out.println(treeMapCopy.higherKey("t"));
		System.out.print("��ȡС��t��ֵ��key"+"\t");
		System.out.println(treeMapCopy.lowerKey("t"));
		//��ȡEntry
		System.out.print("��ȡ���ڵ���t��ֵ��Entry"+"\t");
		System.out.println(treeMapCopy.ceilingEntry("t"));
		System.out.print("��ȡС�ڵ���t��ֵ��Entry"+"\t");
		System.out.println(treeMapCopy.floorEntry("t"));
		System.out.print("��ȡ����t��ֵ��Entry"+"\t");
		System.out.println(treeMapCopy.higherEntry("t"));
		System.out.print("��ȡС��t��ֵ��Entry"+"\t");
		System.out.println(treeMapCopy.lowerEntry("t"));
		//�鿴���Ƴ�Entry
		System.out.println("�鿴���Ƴ���һ��Entry:"+treeMapCopy.pollFirstEntry());
		System.out.println("�鿴���Ƴ����һ��Entry:"+treeMapCopy.pollLastEntry());
		iteratorMap(treeMapCopy);
	}

	
	
}
