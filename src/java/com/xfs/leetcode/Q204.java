package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/12/3 0003
 */
public class Q204 {
	/**
	 * 统计所有小于非负整数n的质数的数量。
	 *
	 * 
	 *
	 * 示例 1：
	 *
	 * 输入：n = 10 输出：4 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。 示例 2：
	 *
	 * 输入：n = 0 输出：0 示例 3：
	 *
	 * 输入：n = 1 输出：0
	 * 
	 *
	 * 提示：
	 *
	 * 0 <= n <= 5 * 106
	 *
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-primes
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		if (n == 3) {
			return 1;
		}
		int count = 1;
		for (int i = 3; i < n; i++) {
			if (i % 2 == 0) {
				continue;
			}
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	public boolean isPrime(int i) {
		for (int j = 3; j < Math.sqrt(i) + 1; j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}
}
