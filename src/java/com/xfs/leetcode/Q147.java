package com.xfs.leetcode;

/**
 * @author fansong Created on 2020/11/20 0020
 */
public class Q147 {
	/**
	 * 插入排序算法：
	 *
	 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
	 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 重复直到所有输入数据插入完为止。  
	 *
	 * 示例 1：
	 *
	 * 输入: 4->2->1->3 输出: 1->2->3->4 示例 2：
	 *
	 * 输入: -1->5->3->4->0 输出: -1->0->3->4->5
	 *
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/insertion-sort-list
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		// 不能创建一个新的listNode，题目是移动
		// 创建一个头结点最小值
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode latestSorted = head;
		ListNode cur = head.next;
		while (cur != null) {
			int valToAdd = cur.val;
			if (valToAdd >= latestSorted.val) {
				latestSorted = latestSorted.next;
			} else {
				ListNode temp = node;
				while (temp.next.val <= valToAdd) {
					temp = temp.next;
				}
				// 将节点插入
				latestSorted.next = cur.next;
				cur.next = temp.next;
				temp.next = cur;
			}
			cur = latestSorted.next;

		}

		return node.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
