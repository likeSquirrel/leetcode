package com.xfs.leetcode;

/**
 * @author fansong Created on 2018/11/23 0023
 */
public class Q10 {

	/*
	给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。

			'.' 匹配任意单个字符。
			'*' 匹配零个或多个前面的元素。
	匹配应该覆盖整个字符串 (s) ，而不是部分字符串。

	说明:

	s 可能为空，且只包含从 a-z 的小写字母。
	p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
	示例 1:

	输入:
	s = "aa"
	p = "a"
	输出: false
	解释: "a" 无法匹配 "aa" 整个字符串。
	示例 2:

	输入:
	s = "aa"
	p = "a*"
	输出: true
	解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
	示例 3:

	输入:
	s = "ab"
	p = ".*"
	输出: true
	解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
	示例 4:

	输入:
	s = "aab"
	p = "c*a*b"
	输出: true
	解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
	示例 5:

	输入:
	s = "mississippi"
	p = "mis*is*p*."
	输出: false
	*/

	public static void main(String[] args) {
		System.out.println(isMatch("aa","a*"));
	}

	/**
	 * 递归（考虑三种情况）
	 *
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}
		if (p.length() == 1) {
			return s.length() == 1 && (p.equals(s) || ".".equals(p));
		}
		if (p.charAt(1) != '*') {
			if (s.isEmpty()) {
				return false;
			}
			return (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
					&& isMatch(s.substring(1), p.substring(1));
		}

		while (!s.isEmpty()
				&& (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}


}
