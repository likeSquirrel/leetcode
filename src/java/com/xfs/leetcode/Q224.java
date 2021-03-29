package com.xfs.leetcode;

import java.util.Stack;

/**
 * @author fansong Created on 2021/3/10 0010
 */
public class Q224 {
	/**
	 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
	 *
	 *  
	 *
	 * 示例 1：
	 *
	 * 输入：s = "1 + 1" 输出：2 示例 2：
	 *
	 * 输入：s = " 2-1 + 2 " 输出：3 示例 3：
	 *
	 * 输入：s = "(1+(4+5+2)-3)+(6+8)" 输出：23  
	 *
	 * 提示：
	 *
	 * 1 <= s.length <= 3 * 105 s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 s 表示一个有效的表达式
	 *
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/basic-calculator
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		System.out.println(calculate(" (1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int opt = 1;
		int num = 0;
		int length = s.length();
		for (int i = 0; i < length; i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int tempNum = ch - '0';
				while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
					tempNum = tempNum * 10 + s.charAt(i + 1) - '0';
					i++;
				}
				num += opt * tempNum;
			} else if (ch == '-') {
				opt = -1;
			} else if (ch == '+') {
				opt = 1;
			} else if (ch == '(') {
				// 保存到栈中
				stack.push(num);
				stack.push(opt);
				// 充值num和opt
				num = 0;
				opt = 1;
			} else if (ch == ')') {
				// 计算
				int tempOpt = stack.pop();
				int tempNum = stack.pop();
				num = num * tempOpt + tempNum;
			}
		}

		return num;
	}

}
