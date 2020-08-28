package com.xfs.leetcode;

import java.util.Arrays;

/**
 * @author fansong Created on 2018/11/13 0013
 */
public class Q4 {
	/*
	 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
	 *
	 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
	 *
	 * 你可以假设 nums1 和 nums2 不同时为空。
	 *
	 * 示例 1:
	 *
	 * nums1 = [1, 3] nums2 = [2]
	 *
	 * 中位数是 2.0 示例 2:
	 *
	 * nums1 = [1, 2] nums2 = [3, 4]
	 *
	 * 中位数是 (2 + 3)/2 = 2.5
	 */

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 4 };
		System.out.print(findMedianSortedArrays(nums1, nums2));
	}

	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result = 0;
		// 合并两个数组排序找中值
		int[] total = Arrays.copyOf(nums1, nums1.length + nums2.length);
		System.arraycopy(nums2, 0, total, nums1.length, nums2.length);
		Arrays.sort(total);
		if (total.length % 2 == 0) {
			int index = total.length / 2 - 1;
			result = (double) (total[index] + total[index + 1]) / 2;
		} else {
			result = total[total.length / 2];
		}

		return result;
	}
}
