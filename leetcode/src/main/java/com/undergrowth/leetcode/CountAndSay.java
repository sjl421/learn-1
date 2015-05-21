package com.undergrowth.leetcode;

public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		for(int i=1;i<=10;i++)
		System.out.println(solution.countAndSay(i));
	}

	/**
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
	 * nth sequence.
	 * 
	 * 算出n的序列 类似于
	 * 1---> 1   1个1---11
	 * 2--->11   2个1---21
	 * 3--->21   --一个2 一个1 1211
	 * 4--->1211 ---一个1 一个2 2个1 ---> 111221
	 * n--->数字的个数和数字的组合     
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 * 
	 * @author Administrator
	 * 
	 */
	public static class Solution {
		public String countAndSay(int n) {
			String s="1"; //记录当前数字的下一个数字数字的序列 由数字的个数和数字组成
			if(n==1) return s;
			int count=0;
			int i;
			StringBuilder builder=new StringBuilder();
			while(++count<n) //不选等于n 因为n序列 由n-1已经算出来
			{
				builder.setLength(0);
				int numRepeat=1;
				//通过前一个数字的序列  算出此数字的序列
				for(i=1;i<s.length();i++){
					//计算字符序列中出现重复的次数
					if(s.charAt(i)==s.charAt(i-1)) numRepeat++;
					else { //如果不重复
						builder.append(numRepeat).append(s.charAt(i-1));
						numRepeat=1;
					}
				}
				//计算完当前数字的序列后 添加最后一个数字
				s=builder.append(numRepeat).append(s.charAt(i-1)).toString()	;
			}
			
			return s;
		}
	}
}
