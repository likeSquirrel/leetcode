package com.xfs.leetcode;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fansong Created on 2020/7/21 0021
 */
public class Q95 {
	/**
	 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
	 *
	 *  
	 *
	 * 示例：
	 *
	 * 输入：3
	 * 输出：
	 * [
	 *   [1,null,3,2],
	 *   [3,2,null,1],
	 *   [3,1,null,null,2],
	 *   [2,1,3],
	 *   [1,null,2,null,3]
	 * ]
	 * 解释：
	 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
	 *
	 *    1         3     3      2      1
	 *     \       /     /      / \      \
	 *      3     2     1      1   3      2
	 *     /     /       \                 \
	 *    2     1         2                 3
	 *  
	 *
	 * 提示：
	 *
	 * 0 <= n <= 8
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */



	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> treeNodes = new ArrayList<>();
		if (n == 0) {
			return treeNodes;
		}

		return generateTrees(1, n);
	}

	public List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> treeNodeList = new ArrayList<>();
		if (start > end) {
			treeNodeList.add(null);
			return treeNodeList;
		}

		for (int i = start; i <= end; i++) {
			// 递归获取左边的树
			List<TreeNode> leftNodes = generateTrees(start, i - 1);
			// 递归获取右边的树
			List<TreeNode> rightNodes = generateTrees(i + 1, end);
			// 将左右两边的树排列组合
			for (TreeNode lNode : leftNodes) {
				for (TreeNode rNode : rightNodes) {
					treeNodeList.add(new TreeNode(i, lNode, rNode));
				}
			}
		}

		return treeNodeList;

	}

}

@Data
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
