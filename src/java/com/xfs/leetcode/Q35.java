package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/7/17 0017
 */
public class Q35 {
	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 *
	 * 你可以假设数组中无重复元素。
	 *
	 * 示例 1:
	 *
	 * 输入: [1,3,5,6], 5 输出: 2 示例 2:
	 *
	 * 输入: [1,3,5,6], 2 输出: 1 示例 3:
	 *
	 * 输入: [1,3,5,6], 7 输出: 4 示例 4:
	 *
	 * 输入: [1,3,5,6], 0 输出: 0
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/search-insert-position
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 2, 4, 6, 9 }, 2));
	}

	public static int searchInsert(int[] nums, int target) {
		int lIdx = 0;
		int length = nums.length;
		int rIdx = length - 1;
		int idx = 0;

		while (lIdx <= rIdx) {
			idx = (rIdx - lIdx) / 2 + lIdx;
			if (target > nums[idx]) {

				if (idx + 1 < length && target <= nums[idx + 1]) {
					return idx;
				}
				lIdx = ++idx;
			} else if (target == nums[idx]) {
				return idx;
			} else {

				if (idx > 1 && target >= nums[idx - 1]) {
					return idx;
				}
				rIdx = --idx;
			}
		}

		return Math.max(idx, 0);
	}

}
