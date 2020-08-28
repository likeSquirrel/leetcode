package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/7/2 0002
 */
public class Q378 {
	/**
	 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 请注意，它是排序后的第 k 小元素，而不是第 k
	 * 个不同的元素。
	 *
	 *  
	 *
	 * 示例：
	 *
	 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
	 *
	 * 返回 13。  
	 *
	 * 提示： 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
		System.out.println(kthSmallest(matrix, 8));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		// 使用二分查找法(有序使用二分)
		int n = matrix.length - 1;
		int l = matrix[0][0];
		int r = matrix[n][n];

		while (l < r) {
			int mid = (l + r) / 2;
			int count = 0;
			// 此处元素的右边和下面都比元素大
			int x = n;
			int y = 0;
			// 从左上角开始，因为mid值区分大小沿着右上到左下的对角线
			while (x >= 0 && y <= n) {
				if (matrix[x][y] <= mid) {
					// x这一行之前的数据都是小于mid的
					count += x + 1;
					y++;
				} else {
					// 不满足就左移一列
					x--;
				}
			}

			if (count < k) {
				l = mid + 1;
			} else {
				r = mid;
			}
		}

		return r;
	}
}
