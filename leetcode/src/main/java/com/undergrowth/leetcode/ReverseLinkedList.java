package com.undergrowth.leetcode;

public class ReverseLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode1=new ListNode(1);
		ListNode listNode2=new ListNode(2);
		ListNode listNode3=new ListNode(3);
		ListNode listNode4=new ListNode(4);
		ListNode listNode=listNode1;
		listNode1.next=listNode2;
		listNode2.next=listNode3;
		listNode3.next=listNode4;
		listNode4.next=null;
		//正向遍历
		while(listNode!=null){
			System.out.println(listNode.val);
			listNode=listNode.next;
		}
		//反向遍历
		Solution solution=new Solution();
		listNode=solution.reverseList(listNode1);
		while(listNode!=null){
			System.out.println(listNode.val);
			listNode=listNode.next;
		}
	}

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 * 反转单链表-->
	 *   先处理头结点，接着处理当前结点和当前结点的后结点，将后结点指向自身的后结点，当前结点指向前结点，最终返回当前结点，即可
	 */
	
	 public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public static class Solution {
	    public ListNode reverseList(ListNode head) {
	        //判断头结点是否为空
	        if(head==null) return null;
	        //获取当前结点
	        ListNode current=head;
	        //获取下一个结点
	        ListNode post=head.next;
	        //头结点置为null
	        head.next=null;
	        //反转剩下的结点
	        while(post!=null){
	            ListNode tmp=post;
	            post=post.next;
	            tmp.next=current;
	            current=tmp;
	        }
	        //返回反转的链表
	        return current;
	    }
	}
}
