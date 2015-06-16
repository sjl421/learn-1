package com.undergrowth.collection;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;


/**
 * Queue--����
 * PriorityQueue--����ʱ��������Ԫ�صĵ���˳��
 * @author Administrator
 *
 */
public class QueueTest {

	Queue<Integer> linkedList,arrayDeque,priorityQueue;
	
	@Before
	public void before(){
		linkedList=new LinkedList<Integer>();
		arrayDeque=new ArrayDeque<Integer>();
		priorityQueue=new PriorityQueue<Integer>(20,new IntegerComparator());
		//��ʼ��
		initQueue(linkedList);
		initQueue(arrayDeque);
		initQueue(priorityQueue);
	}

	/**
	 * ��ʼ������
	 * @param queue
	 */
	private void initQueue(Queue<Integer> queue) {
		// TODO Auto-generated method stub
		Collection<Integer> c=Arrays.asList(12,34,1,11,789,65);
		queue.addAll(c);
	}
	
	/**
	 * ����QueueԪ��
	 */
	@Test
	public void testQueue(){
		iteratorQueue(linkedList);
		iteratorQueue(arrayDeque);
		iteratorQueue(priorityQueue);
	}

	/**
	 * ��������Ԫ��
	 * @param queue
	 */
	private void iteratorQueue(Queue<Integer> queue) {
		// TODO Auto-generated method stub
		System.out.print(queue.getClass().getName()+"\t");
		for (Integer integer : queue) {
			System.out.print(integer+"\t");
		}
		System.out.println();
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
		iteratorQueue(linkedListCopy);
		System.out.println("�鿴����ͷԪ�أ�ɾ��Ԫ��:"+linkedListCopy.poll());
		System.out.println("�鿴����ͷԪ�أ�ɾ��Ԫ��:"+linkedListCopy.pollFirst());
		System.out.println("�鿴����βԪ�أ�ɾ��Ԫ��:"+linkedListCopy.pollLast());
		iteratorQueue(linkedListCopy);
		System.out.println("��Ӷ�ͷԪ��"+linkedListCopy.offerFirst(300));
		System.out.println("��Ӷ�βԪ��"+linkedListCopy.offer(400));
		System.out.println("��Ӷ�βԪ��"+linkedListCopy.offerLast(500));
		iteratorQueue(linkedListCopy);
	}
	
	
}
