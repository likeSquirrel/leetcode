package com.xfs.leetcode;

import java.util.LinkedList;

/**
 * @author fansong Created on 2020/6/30 0030
 */
public class QOffer9 {

	/**
	 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
	 *
	 *  
	 *
	 * 示例 1：
	 *
	 * 输入：
	 * ["CQueue","appendTail","deleteHead","deleteHead"]
	 * [[],[3],[],[]]
	 * 输出：[null,null,3,-1]
	 * 示例 2：
	 *
	 * 输入：
	 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
	 * [[],[],[5],[2],[],[]]
	 * 输出：[null,-1,null,null,5,2]
	 * 提示：
	 *
	 * 1 <= values <= 10000
	 * 最多会对 appendTail、deleteHead 进行 10000 次调用
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	/**
	 * Your CQueue object will be instantiated and called as such:
	 * CQueue obj = new CQueue();
	 * obj.appendTail(value);
	 * int param_2 = obj.deleteHead();
	 */
}

//总结：活用linklist,两个栈可以实现列表倒序
class CQueue {
	private LinkedList<Integer> stack1;
	private LinkedList<Integer> stack2;

	public CQueue() {
		stack1 = new LinkedList<>();
		stack2 = new LinkedList<>();

	}

	public void appendTail(int value) {
		stack1.add(value);
	}

	public int deleteHead() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				return -1;
			}
			while (!stack1.isEmpty()) {
				stack2.add(stack1.pop());
			}
			return stack2.pop();
		} else {
			return stack2.pop();
		}
	}
}
