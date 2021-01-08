package cn.wukai;

import java.util.Iterator;

/**
 * 
 * @author wukai
 * 121. 买卖股票的最佳时机
 *给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class MaxProfit {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(solution2(prices));
	}
	
	/*
	 * 暴力解法 o(n2)时间复杂度
	 */
	public static int solution(int[] prices) {
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				int tmp = prices[j] - prices[i];
				if (tmp > max) {
					max = tmp;
				}
			}
		}
		
		return max;
	}
	
	/*
	 * 只进行一次价格遍历，当前点若小于最小价格，那么就需要设置当前点为最小价格，若大于则用当
	 * 前点减去最小价格，该值若大于最大利润则取此值
	 */
	public static int solution2(int[] prices) {
		
		int minPrice = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}else if (prices[i] - minPrice > max) {
				max = prices[i] - minPrice;
			}
		}
		return max;
	}
}
