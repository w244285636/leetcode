package cn.wukai;
/**
 * 
 * @author wukai
 *123. 买卖股票的最佳时机 III
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入：prices = [3,3,5,0,0,3,1,4]
输出：6
解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2：
输入：prices = [1,2,3,4,5]
输出：4
解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3：
输入：prices = [7,6,4,3,1] 
输出：0 
解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
示例 4：
输入：prices = [1]
输出：0

提示：
1 <= prices.length <= 105
0 <= prices[i] <= 105
 */
public class MaxProfitIII {
	
	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(solution2(prices));
	}
	
	/*
	 * 若需要收益最大，则最多两段都需要有最大的收益，故将数组分成两部分，分别算最大收益，进行比较
	 * 此方法会造成超时
	 */
	public static int solution(int[] prices) {
		int ans = 0;
		int n = prices.length;
		for (int i = 0; i < prices.length; i++) {
			if (i != 0 && prices[i] == prices[i - 1]) {
				continue;
			}
			int left = getMaxProfit(prices, 0, i);
			int right = getMaxProfit(prices, i + 1, n - 1);
			if (ans < left + right) {
				ans = left + right;
			}
		}
		return ans;
	}
	
	private static int getMaxProfit(int[] prices,int start,int end) {
		if (start >= end) {
			return 0;
		}
		int maxProfit = 0;
		int minPrice = prices[start];
		for (int i = start; i <= end; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}
	
	
	/*
	 * 动态规划
	 */
	public static int solution2(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int n = prices.length;
		int buy1 = -prices[0];
		int sell1 = 0;
		int buy2 = -prices[0];
		int sell2 = 0;
		for (int i = 1; i < prices.length; i++) {
			buy1 = Math.max(buy1, -prices[i]);
			sell1 = Math.max(sell1, buy1 + prices[i]);
			buy2 = Math.max(buy2, sell1 - prices[i]);
			sell2 = Math.max(sell2, buy2 + prices[i]);
		}
		return sell2;
	}
}
