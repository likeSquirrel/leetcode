package com.xfs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fansong Created on 2021/1/22 0022
 */
public class Q989 {
	/**
	 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
	 *
	 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
	 *
	 *  
	 *
	 * 示例 1：
	 *
	 * 输入：A = [1,2,0,0], K = 34 输出：[1,2,3,4] 解释：1200 + 34 = 1234 示例 2：
	 *
	 * 输入：A = [2,7,4], K = 181 输出：[4,5,5] 解释：274 + 181 = 455 示例 3：
	 *
	 * 输入：A = [2,1,5], K = 806 输出：[1,0,2,1] 解释：215 + 806 = 1021 示例 4：
	 *
	 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1 输出：[1,0,0,0,0,0,0,0,0,0,0]
	 * 解释：9999999999 + 1 = 10000000000  
	 *
	 * 提示：
	 *
	 * 1 <= A.length <= 10000 0 <= A[i] <= 9 0 <= K <= 10000 如果 A.length >
	 * 1，那么 A[0] != 0
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		int[] A = { 1, 2 };
		System.out.println(addToArrayForm(A, 998).toString());
	}

	public static List<Integer> addToArrayForm(int[] A, int K) {

		List<Integer> result = Arrays.stream(A).boxed()
				.collect(Collectors.toList());
		Collections.reverse(result);
		List<Integer> kList = Arrays.stream((K + "").chars().toArray()).boxed()
				.map(c -> c - '0').collect(Collectors.toList());
		Collections.reverse(kList);
		int x = 0;
		int maxLength = Math.max(kList.size(), result.size());
		for (int i = 0; i < maxLength; i++) {
			int a = 0;
			int b = 0;
			boolean add = true;
			if (i < result.size()) {
				a = result.get(i);
				add = false;
			}
			if (i < kList.size()) {
				b = kList.get(i);
			}
			int sum = a + b + x;
			if (sum >= 10) {
				sum = sum % 10;
				x = 1;
			} else {
				x = 0;
			}
			if (add) {
				result.add(sum);
			} else {
				result.set(i, sum);
			}
		}
		if (x > 0) {
			result.add(x);
		}

		Collections.reverse(result);
		return result;

	}

	public List<Integer> addToArrayForm2(int[] A, int K) {
		List<Integer> res = new ArrayList<Integer>();
		int n = A.length;
		for (int i = n - 1; i >= 0; --i) {
			int sum = A[i] + K % 10;
			K /= 10;
			if (sum >= 10) {
				K++;
				sum -= 10;
			}
			res.add(sum);
		}
		for (; K > 0; K /= 10) {
			res.add(K % 10);
		}
		Collections.reverse(res);
		return res;
	}
}
