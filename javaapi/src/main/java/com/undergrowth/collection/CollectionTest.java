package com.undergrowth.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;



/**
 * Collection����
 * 
 * 
 * PriorityQueue--����ʱ��������Ԫ�صĵ���˳��
 * 
 * equals �� hashCode ������
 *  1��If equal, then same hash codes too.
	2��Same hash codes no guarantee of being equal.
	��ͬ�����������ɵ�hashcodeֵ��һ��
	�����дequals��hashCode���� ���ݾ�����������
 * @author u1
 *
 */
public class CollectionTest {

	/**
	 * ���ϵ�����������
	 */
	Collection<Integer> collectionList,collectionSet,collectionQueue;
	
	/**
	 * �������ϵ�����������
	 */
	@Before
	public void before(){
		//����List Set Queue ������Collection���� ��ʵ����
		collectionList=new ArrayList<Integer>();
		collectionSet=new TreeSet<Integer>();
		collectionQueue=new PriorityQueue<Integer>();
		
		//�������������������
		initCollection(collectionList);
		initCollection(collectionSet);
		initCollection(collectionQueue);
	}

	/**
	 * �򼯺����������
	 * @param collectionList2
	 */
	private void initCollection(Collection<Integer> collection) {
		// TODO Auto-generated method stub
		Collection<Integer> c=Arrays.asList(13,2,56,100,87,87);
		collection.addAll(c);
	}
	
	/**
	 * ��������������
	 */
	@Test
	public void testIterator(){
		iteratorCollection(collectionList);
		iteratorCollection(collectionSet);
		iteratorCollection(collectionQueue);
	}

	/**
	 * ��������
	 * @param collectionList2
	 */
	private void iteratorCollection(Collection<Integer> collection) {
		// TODO Auto-generated method stub
		System.out.print(collection.getClass().getSimpleName()+"\t");
		for (Integer Integer : collection) {
			System.out.print(Integer+"\t");
		}
		System.out.println();
	}
	/**
	 * �Ƴ������е�Ԫ��
	 */
	@Test
	public void testRemove(){
		//�Ƴ�ǰ
		System.out.println("�Ƴ�ǰ����");
		testIterator();
		removeCollection(collectionList);
		removeCollection(collectionSet);
		removeCollection(collectionQueue);
		//�ٽ��е���
		System.out.println("�Ƴ��󼯺�");
		testIterator();
	}

	/**
	 * �Ƴ������е�Ԫ��
	 * @param collection
	 */
	private void removeCollection(Collection<Integer> collection) {
		// TODO Auto-generated method stub
		Collection<Integer> c=Arrays.asList(2,56,200);
		collection.removeAll(c);
	}
	
	/**
	 * ���Լ����Ƿ�Ϊ��
	 */
	@Test
	public void testIsEmpty(){
		System.out.println(collectionList.isEmpty());
		System.out.println(collectionSet.isEmpty());
		System.out.println(collectionQueue.isEmpty());
	}
	
	/**
	 * ���Լ����Ƿ����Ԫ��
	 */
	@Test
	public void testContains(){
		Collection<Integer> c=Arrays.asList(100);
		System.out.println(collectionList.containsAll(c));
		System.out.println(collectionSet.containsAll(c));
		System.out.println(collectionQueue.containsAll(c));
	}
	
	/**
	 * ���Լ���ת��Ϊ����
	 */
	@Test
	public void testToArray(){
		Integer[] a=new Integer[collectionList.size()];
		System.out.println(Arrays.toString(collectionList.toArray(a)));
		a=new Integer[collectionSet.size()];
		System.out.println(Arrays.toString(collectionSet.toArray(a)));
		a=new Integer[collectionQueue.size()];
		System.out.println(Arrays.toString(collectionQueue.toArray(a)));
	}
	
	/**
	 * �����������
	 */
	@Test
	public void testClear(){
		//���ǰ
		System.out.println("���ǰ");
		testIterator();
		collectionList.clear();
		collectionSet.clear();
		collectionQueue.clear();
		//�����
		System.out.println("�����");
		testIterator();
	}
	
	/**
	 * ���Ա�������
	 */
	@Test
	public void testRetain(){
		//����ǰ
		System.out.println("����ǰ");
		testIterator();
		Collection<Integer> c=Arrays.asList(100);
		collectionList.retainAll(c);
		collectionSet.retainAll(c);
		collectionQueue.retainAll(c);
		//������
		System.out.println("������");
		testIterator();
	}
}
