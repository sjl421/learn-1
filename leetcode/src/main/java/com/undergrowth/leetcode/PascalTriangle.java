package com.undergrowth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		List<List<Integer>> resList=solution.generate(5);
		for (List<Integer> list : resList) {
			System.out.print("[");
			for (Integer integer : list) {
				System.out.print(integer+" ");
			}
			System.out.println("]");
		}
	}

	/**
	 * Given numRows, generate the first numRows of Pascal's triangle.
		For example, given numRows = 5,
		 Return 
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]
		
		杨辉三角、帕斯卡三角
	 * @author u1
	 *
	 */
	public static class Solution {
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> result=new ArrayList<List<Integer>>();
	        List<Integer> pre=new ArrayList<Integer>();
	        if(numRows<=0) return result;
	        pre.add(1);//第一行
	        result.add(pre);
	        //然后从第二行开始 不断计算每行除第一个数字和最后一个数字的值 
	        //计算方式为 当前行的元素=上一行同等位置和同等位置前一个的两元素之和
	        for(int i=2;i<=numRows;i++){
	        	List<Integer> cur=new ArrayList<Integer>();//记录当前行的值
	        	cur.add(1);//添加当前行的第一个元素的值
	        	//计算当前行其他元素的和
	        	for(int j=0;j<pre.size()-1;j++){
	        		cur.add(pre.get(j)+pre.get(j+1)); 
	        	}
	        	cur.add(1);//添加当前行的最后一个值
	        	result.add(cur);//添加当前行到返回集合中
	        	pre=cur;
	        }
	        
	        return result;
	    }
	}
}
