package com.xfs.leetcode;

/**
 * @author fansong Created on 2018/11/12 0012
 */
public class Q2 {
	/*
	 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
	 * 
	 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
	 * 
	 * 示例：
	 * 
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
	 */

	public static void main(String[] args) {

	}

	private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode curr = result;
		int flag = 0;
		while (l1 != null || l2 != null || flag > 0) {
			int value = flag;
			if (l1 != null) {
				value += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				value += l2.val;
				l2 = l2.next;
			}
			if (value >= 10) {
				flag = 1;
				value -= 10;
			} else {
				flag = 0;
			}
			curr.next = new ListNode(value);
			curr = curr.next;
		}
		return result.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
