package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/7/1 0001
 */
public class Q718 {
	/**
	 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
	 *
	 * 示例 1:
	 *
	 * 输入: A: [1,2,3,2,1] B: [3,2,1,4,7] 输出: 3 解释: 长度最长的公共子数组是 [3, 2, 1]。 说明:
	 *
	 * 1 <= len(A), len(B) <= 1000 0 <= A[i], B[i] < 100
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
//		int[] a = { 1, 2, 3, 2, 1 };
//		int[] b = { 3, 2, 1, 4, 7 };

		int[] a = { 1, 1, 1, 1, 1 };
		int[] b = { 1, 1, 1, 1, 1 };

		System.out.println(findLength(a, b));
	}

	// 提示：假设a[i]=b[j],那么a[i:]与b[j:]的最长公共数组的长度是a[i+1:]与b[j+1:]的最长公共数组的长度加一
	public static int findLength(int[] A, int[] B) {
		int[][] dp = new int[A.length + 1][B.length + 1];
		int max = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = B.length - 1; j >= 0; j--) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max;
	}
}
