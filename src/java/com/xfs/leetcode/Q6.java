package com.xfs.leetcode;

/**
 * @author fansong Created on 2018/11/19 0019
 */
public class Q6 {
	/*
	 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
	 * 
	 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
	 * 
	 * L C I R G E T O E S I I E D H N
	 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRGETOESIIEDHN"。
	 * 
	 * 请你实现这个将字符串进行指定行数变换的函数：
	 * 
	 * string convert(string s, int numRows); 示例 1:
	 * 
	 * 输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRGETOESIIEDHN" 示例 2:
	 * 
	 * 输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:
	 * 
	 * L D R E O E I I E C I H N T S G
	 */

	public static void main(String[] args) {
		System.out.println(convert("ab", 1));

	}

	public static String convert(String s, int numRows) {
		if ("".equals(s)) {
			return "";
		}
		int i = 0;
		int j = 0;
		// 设计一个字符串数组，每一行对应一个下标
		String[] resultArrays = new String[numRows];
		while (j < s.length()) {
			if (resultArrays[i] == null) {
				resultArrays[i] = s.charAt(j) + "";
			} else {
				resultArrays[i] += s.charAt(j);
			}
			int cycle = numRows * 2 - 2;
			// 排除分母为0的情况
			if (cycle == 0) {
				j++;
				continue;
			}
			if (j % cycle >= numRows - 1) {
				i--;
			} else {
				i++;
			}
			j++;
		}
		StringBuilder result = new StringBuilder();
		for (String temp : resultArrays) {
			if (temp != null) {
				result.append(temp);
			}
		}
		return result.toString();
	}

}
