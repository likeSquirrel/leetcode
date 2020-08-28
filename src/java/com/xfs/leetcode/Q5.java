package com.xfs.leetcode;

/**
 * @author fansong Created on 2018/11/14 0014
 */
public class Q5 {
	/*
	 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
	 * 
	 * 示例 1：
	 * 
	 * 输入: "babad" 输出: "bab" 注意: "aba"也是一个有效答案。
	 *
	 * 示例 2：
	 * 
	 * 输入: "cbbd" 输出: "bb"
	 */

	public static void main(String[] args) {
		System.out.println(longestPalindrome("cbbdabba"));

	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			// 有中间的数
			int len1 = expandAroundCenter(s, i, i);
			// 没有中间的数
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			// 通过长度找到下标
			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int left, int right) {
		// 判断i的两边是否一样
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		// 返回回文的长度
		return right - left - 1;
	}
}
