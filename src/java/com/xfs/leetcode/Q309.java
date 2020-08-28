package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/7/10 0010
 */
public class Q309 {
	/**
	 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
	 *
	 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
	 *
	 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 示例:
	 *
	 * 输入: [1,2,3,0,2] 输出: 3 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1,2,3,0,2 }));
	}

	public static int maxProfit(int[] prices) {
		// 考点：动态规划和状态转换
		// 三个状态：1.持有股票；2.没有股票，且在冷冻期；3.没有股票且不在冷冻期
		// 计算三个状态的动态规划公式
		int length = prices.length;
		if (length == 0) {
			return 0;
		}
		int[][] dp = new int[length][3];
		// 购买股票初始化状态应该是付的
		dp[0][0] = -prices[0];
		for (int i = 1; i < length; i++) {
			// 持有股票
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
			// 没有股票，且在冷冻期
			dp[i][1] = dp[i - 1][0] + prices[i];
			// 没有股票且不在冷冻期
			dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
		}

		// 最后肯定是返回无股票状态
		return Math.max(dp[length - 1][1], dp[length - 1][2]);

	}
}
