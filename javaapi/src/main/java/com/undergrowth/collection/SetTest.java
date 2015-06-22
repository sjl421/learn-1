package com.undergrowth.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * Set���ϲ���
 * �����е�ÿһ��Ԫ�ض�ֻ�ܴ���һ��
 * HashSet--����ʱ�����ܱ�֤Ԫ�ص�˳��
 * LinkedHashSet--����ʱ������Ԫ�ص�˳�������ǲ����˳��
 * TreeSet--����ʱ������Ԫ�ص�˳�������ǲ����˳��ͬʱ�ڼ����ڲ���Ԫ�ؽ�����������
 * EnumSet--ö�����͵ļ���
 * @author Administrator
 *
 */
public class SetTest {
	
	Set<Operation> enumSet;
	Set<Integer> hashSet,linkedHashSet,treeSet;
	Set<String> treeSetComparator;
	
	@Before
	public void before(){
		//��������Set��������
		enumSet=EnumSet.of(Operation.ADD, Operation.MULTI,Operation.ADD);
		hashSet=new HashSet<Integer>();
		linkedHashSet=new LinkedHashSet<Integer>();
		treeSet=new TreeSet<Integer>();
		//ʹ�ñȽ�������TreeSet ���ձȽ����ķ�ʽ��������Set�е�Ԫ��
		StringIntegerComparator comparator=new StringIntegerComparator();
		treeSetComparator=new TreeSet<String>(comparator);
		treeSetComparator.addAll(Arrays.asList("100","45","78","120","87","89","87"));
		//��ʼ��Setֵ
		initSet(hashSet);
		initSet(linkedHashSet);
		initSet(treeSet);
		
	}

	/**
	 * ��Set���������
	 * @param hashSet2
	 */
	private void initSet(Set<Integer> set) {
		// TODO Auto-generated method stub
		Collection<Integer> c=Arrays.asList(100,45,78,120,87,89,87);
		set.addAll(c);
	}
	
	
	/**
	 * ����Ԫ��
	 */
	@Test
	public void testIterator(){
		iteratorSet(hashSet);
		iteratorSet(linkedHashSet);
		iteratorSet(treeSet);
		iteratorEnumSet(enumSet);
		iteratorTreeSet(treeSetComparator);
	}

	/**
	 * ����TreeSet
	 * @param treeSetComparator2
	 */
	private void iteratorTreeSet(Set<String> treeSetComparator2) {
		// TODO Auto-generated method stub
		System.out.print(treeSetComparator2.getClass().getName()+"\t");
		for (String string : treeSetComparator) {
			System.out.print(string+"\t");
		}
		System.out.println();
	}

	/**
	 * ��������
	 * @param set
	 */
	private void iteratorSet(Set<Integer> set) {
		// TODO Auto-generated method stub
		System.out.print(set.getClass().getName()+"\t");
		for (Integer integer : set) {
			System.out.print(integer+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ����EnumSet
	 * @param enumSet
	 */
	private void iteratorEnumSet(Set<Operation> enumSet){
		System.out.print(enumSet.getClass().getName()+"\t");
		for (Operation operation : enumSet) {
			System.out.print(operation.ordinal()+":"+operation.getName()+"\t");
		}
		System.out.println();
	}
	
	/**
	 * ����NavigableSet��11�����з���
	 */
	@Test
	public void testNavigableSet(){
		TreeSet<Integer> treeSetCopy=(TreeSet<Integer>) treeSet;
		//������ά�ֵ�Ԫ�� 2������
		System.out.print("������ά�ֵ�Ԫ��\t");
		iteratorSet(treeSetCopy);
		System.out.print("�����е���Ԫ��\t");
		iteratorSet(treeSetCopy.descendingSet());
		Iterator<Integer> iterator=treeSetCopy.descendingIterator();
		//��ȡ���ּ��� 3������
		System.out.println("��ȡС��100�ļ���\t");
		SortedSet<Integer> sortedSet=treeSetCopy.headSet(100);
		iteratorSet(sortedSet);
		System.out.println("��ȡ����100�ļ��ϣ�����100���Ԫ��\t");
		sortedSet=treeSetCopy.tailSet(100,true);
		iteratorSet(sortedSet);
		System.out.println("��ȡ�ƶ���Χ�ڵļ���\t");
		sortedSet=treeSetCopy.subSet(87, 120);
		iteratorSet(sortedSet);
		//��ȡ����Ԫ��  4������
		System.out.println("��ȡ���ڵ���100��Ԫ��\t");
		System.out.println(treeSetCopy.ceiling(100));
		System.out.println("��ȡС�ڵ���100��Ԫ��\t");
		System.out.println(treeSetCopy.floor(100));
		System.out.println("��ȡ����100��Ԫ��\t");
		System.out.println(treeSetCopy.higher(100));
		System.out.println("��ȡС��100��Ԫ��\t");
		System.out.println(treeSetCopy.lower(100));
		//�鿴��ɾ��Ԫ��
		iteratorSet(treeSetCopy);
		System.out.println("�Ƴ����ϵ�һ��Ԫ��:"+treeSetCopy.pollFirst());
		System.out.println("�Ƴ��������һ��Ԫ��:"+treeSetCopy.pollLast());
		iteratorSet(treeSetCopy);
	}
	
}
