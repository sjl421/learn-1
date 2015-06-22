package com.undergrowth.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;


/**
 * List����
 * @author u1
 *
 */
public class ListTest {

	List<Integer> arrayList,vectorList,stackList,linkedList;
	
	/**
	 * ����List����������
	 */
	@Before
	public void before(){
		arrayList=new ArrayList<Integer>();
		vectorList=new Vector<Integer>();
		stackList=new Stack<Integer>();
		linkedList=new LinkedList<Integer>();
		
		initList(arrayList);
		initList(vectorList);
		initList(stackList);
		initList(linkedList);
	}
	
	
	/**
	 * ���б����������
	 * @param list
	 */
	private void initList(List<Integer> list) {
		// TODO Auto-generated method stub
		List<Integer> c=Arrays.asList(13,2,56,100,87,87);
		list.addAll(c);
	}
	
	/**
	 * ���Ե���Ԫ��
	 */
	@Test
	public void testIterator(){
		iteratorList(arrayList);
		iteratorList(vectorList);
		iteratorList(stackList);
		iteratorList(linkedList);
	}

	/**
	 * ����Ԫ��
	 * @param list
	 */
	private void iteratorList(List<Integer> list) {
		// TODO Auto-generated method stub
		System.out.print(list.getClass().getName()+"\t");
		for (Integer integer : list) {
			System.out.print(integer+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ����set��get����
	 */
	@Test
	public void testGetSet(){
		System.out.println("����set����֮ǰ");
		iteratorList(arrayList);
		//��������ֵΪ0��Ԫ�ص�ֵΪ10000
		arrayList.set(0, 10000);
		System.out.println("����set����֮��");
		iteratorList(arrayList);
		System.out.println("���һ��Ԫ��Ϊ:"+arrayList.get(arrayList.size()-1));
	}
	
	/**
	 * ����subList����
	 */
	@Test
	public void testSubList(){
		iteratorList(vectorList.subList(0, vectorList.size()-2));
	}
	
	/**
	 * ����indexOf
	 */
	@Test
	public void testIndexOf(){
		System.out.println("100���Ԫ�ص�����Ϊ:"+stackList.indexOf(100));;
	}
	
	
	/**
	 * ����LinkedList��Deque����
	 */
	@Test
	public void testLinkedList(){
		LinkedList<Integer> linkedListCopy=(LinkedList<Integer>) linkedList;
		System.out.println("�鿴����ͷԪ�أ���ɾ��Ԫ��:"+linkedListCopy.peek());
		System.out.println("�鿴����ͷԪ�أ���ɾ��Ԫ��:"+linkedListCopy.peekFirst());
		System.out.println("�鿴����βԪ�أ���ɾ��Ԫ��:"+linkedListCopy.peekLast());
		iteratorList(linkedListCopy);
		System.out.println("�鿴����ͷԪ�أ�ɾ��Ԫ��:"+linkedListCopy.poll());
		System.out.println("�鿴����ͷԪ�أ�ɾ��Ԫ��:"+linkedListCopy.pollFirst());
		System.out.println("�鿴����βԪ�أ�ɾ��Ԫ��:"+linkedListCopy.pollLast());
		iteratorList(linkedListCopy);
		System.out.println("��Ӷ�ͷԪ��"+linkedListCopy.offerFirst(300));
		System.out.println("��Ӷ�βԪ��"+linkedListCopy.offer(400));
		System.out.println("��Ӷ�βԪ��"+linkedListCopy.offerLast(500));
		iteratorList(linkedListCopy);
	}
	
	/**
	 * ����Stack�Ķ�ջ����
	 */
	@Test
	public void testStack(){
		Stack<Integer> stack=(Stack<Integer>) stackList;
		iteratorList(stack);
		System.out.println("�鿴��ջ��ջ����ɾ��Ԫ��:"+stack.peek());
		System.out.println("�鿴��ջ��ջ��ɾ��Ԫ��:"+stack.pop());
		iteratorList(stack);
	}
}
