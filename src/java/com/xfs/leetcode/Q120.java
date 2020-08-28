package com.xfs.leetcode;

import java.util.List;

/**
 * @author fansong Created on 2020/7/14 0014
 */
public class Q120 {
	/**
	 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
	 *
	 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
	 *
	 *  
	 *
	 * 例如，给定三角形：
	 *
	 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
	 *
	 *  
	 *
	 * 说明：
	 *
	 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
	 *
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/triangle
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n + 1][n + 1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				// 此处动态规划与i无关，可以使用一维数组动态规划
				dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1])
						+ triangle.get(i).get(j);
			}
		}

		return dp[0][0];
	}
}
