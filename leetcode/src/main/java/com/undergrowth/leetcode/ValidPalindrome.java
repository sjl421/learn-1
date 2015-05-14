package com.undergrowth.leetcode;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(solution.isPalindrome("race a car"));
		System.out.println(solution.isPalindrome("1a2"));
	}
	
	/**
	回文字符串-->
	    正向读与反向读都一致
	         只考虑字符(字母和数字)的顺序 忽略其他字符和大小写
	    在进行验证时 从左向右增加 从右向左减少 的比较左、右位置上的字符是否一致 不一致 就退出
	    一致 就继续比较 直至左边的位置超过右边
	**/
	public static class Solution {
	    public boolean isPalindrome(String s) {
	        if(s==null) return false;
	        if("".equals(s)) return true;
	        //转换为小写
	        s=s.toLowerCase();
	        //左、右的位置
	        int left=0,right=s.length()-1;
	        while(left<right){
	        	//过滤到无效字符
	            while(!isValid(s.charAt(left))){
	                left++;
	                if(left>=right) return true;
	            }
	            //过滤掉无效字符
	            while(!isValid(s.charAt(right))){
	                right--;
	                if(left>=right) return true;
	            }
	            //不相等 即返回
	            if(s.charAt(left)!=s.charAt(right)) return false;
	            //接着判断
	            left++;
	            right--;
	        }
	        
	        return true;
	    }
	    //判断是否是字符
	    public boolean isValid(char c){
	        if(c<='z' && c>='a') return true;
	        if(c<='9' && c>='0') return true;
	        return false;
	    }
	}

}
