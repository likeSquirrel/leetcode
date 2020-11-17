package com.xfs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fansong Created on 2020/11/16 0016
 */
public class Q406 {
	/**
	 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
	 * 编写一个算法来重建这个队列。
	 *
	 * 注意： 总人数少于1100人。
	 *
	 * 示例
	 *
	 * 输入: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	 *
	 * 输出: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 *
	 */

	public static void main(String[] args) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 },
				{ 5, 2 } };
		people = reconstructQueue(people);
		printArray(people);
	}

	private static void printArray(int[][] people) {
		System.out.print("{");
		for (int[] person : people) {
			System.out.print("{");
			for (int i : person) {
				System.out.print(i + " ");
			}
			System.out.print("},");
		}
		System.out.print("}");
		System.out.println("");
	}

	public static int[][] reconstructQueue(int[][] people) {
		// 排序h升序，k降序
		Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

		// 因为k本来就是身高排序，所以根据k的大小排序即可
		List<int[]> list = new ArrayList<>();
		for (int[] i : people) {
			list.add(i[1], i);
		}

		return list.toArray(new int[people.length][]);

	}
}
