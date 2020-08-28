package com.xfs.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fansong Created on 2018/11/12 0012
 */
public class Q1 {
	/*
	 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
	 * 
	 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
	 * 
	 * 示例:
	 * 
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
	 */
	public static void main(String[] args) {
		int[] nums = { 2, 4, 14, 7, 11, 15 };
		int target = 9;
		System.out.println(Arrays.toString(twoSum2(nums, target)));
	}

	private static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
				}
			}
		}
		return result;
	}

	private static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
			} else {
				map.put(nums[i], i);
			}
		}

		return result;
	}

}
