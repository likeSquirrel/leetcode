package com.xfs.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fansong Created on 2018/11/12 0012
 */
public class Q3 {
	/*
	 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
	 *
	 * 示例 1:
	 *
	 * 输入: "abcabcbb" 输出: 3 解释: 无重复字符的最长子串是 "abc"，其长度为 3。 示例 2:
	 *
	 * 输入: "bbbbb" 输出: 1 解释: 无重复字符的最长子串是 "b"，其长度为 1。 示例 3:
	 *
	 * 输入: "pwwkew" 输出: 3 解释: 无重复字符的最长子串是 "wke"，其长度为 3。 请注意，答案必须是一个子串，"pwke"
	 * 是一个子序列 而不是子串。
	 */

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring2("abccccbbefgh"));
	}

	private static int lengthOfLongestSubstring(String s) {
		int max = 0;
		char[] chars = s.toCharArray();
		List<Character> temp = new ArrayList<>();
		int tempIndex = 0;
		for (int i = 0; i < chars.length;) {
			if (temp.contains(chars[i])) {
				if (temp.size() > max) {
					max = temp.size();
				}
				temp.clear();
				i = tempIndex + 1;
			} else {
				if (temp.size() == 0) {
					tempIndex = i;
				}
				temp.add(chars[i]);
				i++;
			}
		}
		if (temp.size() > max) {
			max = temp.size();
		}
		return max;
	}

	private static int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		int i = 0, j = 0, max = 0;
		Set<Character> characters = new HashSet<>();
		while (i < n && j < n) {
			if (!characters.contains(s.charAt(j))) {
				characters.add(s.charAt(j++));
				max = Math.max(max, j - i);
			} else {
				characters.remove(s.charAt(i++));
			}
		}
		return max;
	}
}
