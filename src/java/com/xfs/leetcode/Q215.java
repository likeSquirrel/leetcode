package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/6/29 0029
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2 输出: 5 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4 输出: 4 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q215 {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 8, 2, 3, 3 };
		System.out.println(findKthLargestAnswer(nums, 5));
	}

	public static int findKthLargest(int[] nums, int k) {
		Integer[] boxedArray = Arrays.stream(nums).boxed()
				.sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

		return boxedArray[k - 1];
	}

	/**
	 * 考点：堆排序
	 */
	public static int findKthLargestAnswer(int[] nums, int k) {
		int heapSize = nums.length;
		buildMaxHeap(nums, heapSize);
		for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
			swap(nums, 0, i);
			--heapSize;
			maxHeapify(nums, 0, heapSize);
		}
		return nums[0];
	}

	public static void buildMaxHeap(int[] a, int heapSize) {
		for (int i = heapSize / 2; i >= 0; --i) {
			maxHeapify(a, i, heapSize);
		}
	}

	public static void maxHeapify(int[] a, int i, int heapSize) {
		int l = i * 2 + 1, r = i * 2 + 2, largest = i;
		if (l < heapSize && a[l] > a[largest]) {
			largest = l;
		}
		if (r < heapSize && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			swap(a, i, largest);
			maxHeapify(a, largest, heapSize);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
