package com.undergrowth.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactorialTrailingZeros {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();/*
											 * System.out.println(5+"--"+"0的个数"+
											 * solution.trailingZeroes(5));
											 * System
											 * .out.println(7+"--"+"0的个数"+solution
											 * .trailingZeroes(7));
											 * System.out.println
											 * (125+"--"+"0的个数"
											 * +solution.trailingZeroes(125));
											 * System
											 * .out.println(Integer.MAX_VALUE
											 * +"--"
											 * +"0的个数"+solution.trailingZeroes
											 * (Integer.MAX_VALUE));
											 * System.out.println
											 * (Long.MAX_VALUE);
											 * System.out.println
											 * (Double.MAX_VALUE);
											 * System.out.println("使用除余法");
											 * System
											 * .out.println(5+"--"+"0的个数"+solution
											 * .trailingZeroesDivide(5));
											 * System.
											 * out.println(7+"--"+"0的个数"+solution
											 * .trailingZeroesDivide(7));
											 * System.
											 * out.println(125+"--"+"0的个数"
											 * +solution
											 * .trailingZeroesDivide(125));
											 * System
											 * .out.println(Integer.MAX_VALUE
											 * +"--"
											 * +"0的个数"+solution.trailingZeroesDivide
											 * (Integer.MAX_VALUE));
											 * System.out.println
											 * ("使用BigInteger计算阶乘--"
											 * +solution.fact
											 * (BigInteger.valueOf(100)));
											 */
		// System.out.println("使用BigInteger计算阶乘--"+solution.fact(BigInteger.valueOf(200)));
		//System.out.println(Integer.MAX_VALUE);
		System.out.println(solution.factFor(19));;
		List<Integer> resuList=solution.fact(1000);
		for (int i = resuList.size()-1; i >=0 ; i--) {
			System.out.print(resuList.get(i));;
		}
		System.out.println();
		System.out.println("使用BigInteger计算阶乘--"+solution.fact(BigInteger.valueOf(1000)));
	}

	/**
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * 
	 * Note: Your solution should be in logarithmic time complexity.
	 * 
	 * 计算n的阶乘中尾部0的个数 1、计算出n的阶乘 然后使用除余法 算出尾数0的个数--当n很大时 对于Integer会溢出
	 * 2、使用质因子2和5，因为n!中尾数为0的都是有质因子2*5组成的 只用计算质因子2和5的个数 就知道尾部有多少个0了
	 * 5!--2*3*2*2*5--120--一个0--一个5 7！--2*3*2*2*5*2*3*7--一个0--一个5 在进行阶乘计算时
	 * 2的个数明显多于5的个数 所以只用计算n!中5的个数即可 n!中5的个数--floor(n/5)--即可 但是对于25、125、625之类的而言
	 * --又多个很多个5 多以对于此类情况 需使用 25--floor(n/5)+floor(n/25)
	 * 125--floor(n/5)+floor(n/25)+floor(n/125)
	 * 所以最终计算n!中尾部0的个数=floor(n/5)+floor(n/25)+floor(n/125)....+floor(n/k)
	 * k为小于等于n的5的指数
	 * 
	 * @author u1
	 * 
	 */
	public static class Solution {
		public int trailingZeroes(int n) {
			long start = System.currentTimeMillis();
			int base = 0;
			int num = 0; // 如果使用int 会溢出 需使用long
			while (n != 0) {
				base = n / 5;
				num += base;
				n = base;
			}
			System.out.println("花费时间"
					+ String.valueOf(System.currentTimeMillis() - start));
			return num;
		}

		/**
		 * 使用除余法 此种方式不行 数太大 就会溢出
		 * 
		 * @param n
		 * @return
		 */
		public int trailingZeroesDivide(int n) {
			long start = System.currentTimeMillis();
			int num = 0;
			double sum = 1;
			for (int i = 1; i <= n; i++) {
				sum *= i;
			}
			System.out.println("sum值为--" + sum);
			while (sum > 0) {
				if (sum % 10 == 0) {
					num++;
					sum = sum / 10;
				} else {
					break;
				}
			}
			System.out.println("花费时间"
					+ String.valueOf(System.currentTimeMillis() - start));
			return num;
		}

		/**
		 * 使用BigInteger
		 */
		public BigInteger fact(BigInteger val) {
			long start = System.currentTimeMillis();
			BigInteger result = BigInteger.ONE;
			for (BigInteger index = BigInteger.ONE; index.compareTo(val) < 1; index = index
					.add(BigInteger.ONE)) {
				result = result.multiply(index);
			}
			System.out.println("BigInteger花费时间-->"
					+ String.valueOf(System.currentTimeMillis() - start));
			return result;
		}

		public int factFor(int n) {
			int sum = 1;
			for (int i = 1; i <= n; i++) {
				sum *= i;
			}
			// System.out.println(sum);
			return sum;
		}

		/**
		 * 计算阶乘
		 */
		public List<Integer> fact(int n) {
			long start = System.currentTimeMillis();
			List<Integer> resuList = new ArrayList<Integer>();
			List<Integer> tmpList = new ArrayList<Integer>();
			Map<Integer, Integer> bitResultMap=new HashMap<Integer, Integer>();
			//若为19 则直接计算返回
			if (n <= 12) {
				resuList.add(factFor(n));
				return resuList;
			}
			int fact19=factFor(12);
			//若大于19 则将19的每一位数与后面数分别相乘 放入list中 然后在进行进位处理
			//拆分19阶乘的每一位数
			tmpList.clear();
			fact19 = splitNum(tmpList, fact19);
			//分别相乘
			for(int count=13;count<=n;count++){
				for(int i=0;i<tmpList.size();i++){
					bitResultMap.put(i, tmpList.get(i)*count);
				}
				tmpList.clear();
				//处理进位
				for (int i = 0; i < bitResultMap.size(); i++) {
					int value=bitResultMap.get(i);
					//获取进位
					if(value>10) { 
						if(bitResultMap.get(i+1)==null) bitResultMap.put(i+1,0);
						bitResultMap.put(i+1, bitResultMap.get(i+1)+value/10);
						bitResultMap.put(i, value%10);
					}
				}
				//恢复tmp值
				for (int i = 0; i < bitResultMap.size(); i++){
					tmpList.add(bitResultMap.get(i));
				}
				
				
			}
			resuList=tmpList;
			System.out.println("花费时间"
					+ String.valueOf(System.currentTimeMillis() - start));
			return resuList;
		}

		private int splitNum(List<Integer> tmpList, int fact19) {
			for(;fact19!=0;fact19=fact19/10){
				tmpList.add(fact19%10);
			}
			return fact19;
		}
	}
}
