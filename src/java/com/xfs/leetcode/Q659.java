package com.xfs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fansong Created on 2020/12/4 0004
 */
public class Q659 {
	/**
	 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
	 *
	 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
	 *
	 * 
	 *
	 * 示例 1：
	 *
	 * 输入: [1,2,3,3,4,5] 输出: True 解释: 你可以分割出这样两个连续子序列 : 1, 2, 3 3, 4, 5
	 * 
	 *
	 * 示例 2：
	 *
	 * 输入: [1,2,3,3,4,4,5,5] 输出: True 解释: 你可以分割出这样两个连续子序列 : 1, 2, 3, 4, 5 3, 4,
	 * 5
	 * 
	 *
	 * 示例 3：
	 *
	 * 输入: [1,2,3,4,4,5] 输出: False
	 * 
	 *
	 * 提示：
	 *
	 * 输入的数组长度范围为 [1, 10000]
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6 };
		System.out.println(isPossible(nums));
	}

	// 贪心算法：尽量组成长的子序列
	public static boolean isPossible(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		// 可能出现负数，所以使用map
		Map<Integer, Integer> numsCount = new HashMap<>();
		// 获取所有数字出现的次数
		for (int i : nums) {
			numsCount.put(i, numsCount.getOrDefault(i, 0) + 1);
		}
		// x为尾的子序列个数
		Map<Integer, Integer> endCount = new HashMap<>();

		for (int x : nums) {
			int count = numsCount.getOrDefault(x, 0);
			if (count > 0) {
				int prevEndCount = endCount.getOrDefault(x - 1, 0);
				if (prevEndCount > 0) {
					// 正常往后加
					numsCount.put(x, numsCount.getOrDefault(x, 0) - 1);
					endCount.put(x - 1, prevEndCount - 1);
					endCount.put(x, endCount.getOrDefault(x, 0) + 1);
				} else {
					int count1 = numsCount.getOrDefault(x + 1, 0);
					int count2 = numsCount.getOrDefault(x + 2, 0);
					// 组成新的子序列需要后两个数字个数都大于0
					if (count1 > 0 && count2 > 0) {
						numsCount.put(x, numsCount.getOrDefault(x, 0) - 1);
						numsCount.put(x + 1,
								numsCount.getOrDefault(x + 1, 0) - 1);
						numsCount.put(x + 2,
								numsCount.getOrDefault(x + 2, 0) - 1);
						endCount.put(x + 2,
								endCount.getOrDefault(x + 2, 0) + 1);
					} else {
						return false;
					}
				}
			}
		}

		return true;
	}
}
