package com.undergrowth.leetcode;

import com.undergrowth.leetcode.ReverseLinkedList.ListNode;
import com.undergrowth.leetcode.ReverseLinkedList.Solution;

public class RemoveLinkedListElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode22 = new ListNode(2);
		ListNode listNode4 = new ListNode(4);
		ListNode listNode = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode22;
		listNode22.next = listNode4;
		listNode4.next = null;
		// 正向遍历
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
		// 删除元素后遍历
		Solution solution = new Solution();
		listNode = solution.removeElements(listNode1,2);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}

	/**
	 * Definition for singly-linked list. public class ListNode { int val;
	 * ListNode next; ListNode(int x) { val = x; } }
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class Solution {
		public ListNode removeElements(ListNode head, int val) {
			ListNode current = head, tmp;
			// 排除对首的值相等的情况
			while (head != null && head.val == val) {
				head = head.next;
			}
			current = head;
			// 再排除不是对首的值相等的情况
			while (current != null && current.next != null) {
				if (current.next.val == val) {
					tmp = current.next.next;
					current.next = tmp;
				} else {
					current = current.next;
				}
			}
			return head;
		}
	}
}
