package com.xfs.leetcode;

/**
 * @author fansong Created on 2021/3/30 0030
 */
public class Q74 {
	/**
	 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
	 *
	 * 每行中的整数从左到右按升序排列。 每行的第一个整数大于前一行的最后一个整数。  
	 *
	 * 示例 1：
	 *
	 *
	 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3 输出：true
	 * 示例 2：
	 *
	 *
	 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13 输出：false
	 *  
	 *
	 * 提示：
	 *
	 * m == matrix.length n == matrix[i].length 1 <= m, n <= 100 -104 <=
	 * matrix[i][j], target <= 104
	 *
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static void main(String[] args) {
		// int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
		// { 23, 30, 34, 60 } };
		int[][] matrix = { { 1, 3, 5 } };
		System.out.println(searchMatrix(matrix, 3));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int end = m * n - 1;
		int begin = 0;

		// 将二维数组坐标转为一维数组
		while (begin < end) {
			int mid = (end + begin) / 2;
			if (matrix[mid / n][mid % n] < target) {
				begin = mid + 1;
			} else {
				end = mid;
			}
		}

		return matrix[begin / n][begin % n] == target;
	}
}
