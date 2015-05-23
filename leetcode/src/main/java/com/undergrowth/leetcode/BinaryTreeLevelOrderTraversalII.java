package com.undergrowth.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.undergrowth.leetcode.BinaryTreeLevelOrderTraversal.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7},
	 * 
	 * 3 / \ 9 20 / \ 15 7
	 * 
	 * 
	 * 
	 * return its bottom-up level order traversal as:
	 * 
	 * [ [15,7], [9,20], [3] ]
	 * 
	 * 
	 * 
	 * confused what "{1,#,2,3}" means? > read more on how binary tree is
	 * serialized on OJ.
	 * 
	 * Definition for a binary tree node. public class TreeNode { int val;
	 * TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static class Solution {
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> result = new ArrayList<List<Integer>>(); //记录每一层的结果数
			if (root == null)
				return result;
			int curNum=0; //记录当前层的结点个数
			int lastNum=1;//记录上一层的结点的个数
			//记录当前层的结点的值
			List<Integer> curVal=new ArrayList<Integer>();
			//记录当前层结点
			LinkedList<TreeNode> curNodeList=new LinkedList<TreeNode>();
			curNodeList.add(root);
			while(!curNodeList.isEmpty()){//遍历所有层的结点
				//获取链表中的结点
				TreeNode curNode=curNodeList.poll();
				curVal.add(curNode.val);
				lastNum--;
				//判断结点的左结点是否为空
				if(curNode.left!=null){
					curNodeList.add(curNode.left);
					curNum++;
				}
				//判断结点的右结点是否为空
				if(curNode.right!=null){
					curNodeList.add(curNode.right);
					curNum++;
				}
				//判断当前层的结点是否遍历完毕
				if(lastNum==0){
					lastNum=curNum;
					curNum=0;
					result.add(curVal);//添加到结果集
					curVal=new ArrayList<Integer>();
					
				}
				
			}
			
			return result;
		}
	}
}
