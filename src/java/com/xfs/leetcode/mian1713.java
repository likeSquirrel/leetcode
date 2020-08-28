package com.xfs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fansong Created on 2020/7/9 0009
 */
public class mian1713 {
	/**
	 *
	 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still
	 * didn’t
	 * boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
	 * 
	 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
	 * 
	 * 
	 * 
	 * 示例：
	 * 
	 * 输入： dictionary = ["looked","just","like","her","brother"] sentence =
	 * "jesslookedjustliketimherbrother" 输出： 7 解释： 断句后为"jess looked just like
	 * tim her brother"，共7个未识别字符。 提示：
	 * 
	 * 0 <= len(sentence) <= 1000 dictionary中总字符数不超过 150000。
	 * 你可以认为dictionary和sentence中只包含小写字母。
	 */

	public int respace(String[] dictionary, String sentence) {
		// 动态规划，未识别字符数dp[i]=dp[i-1]+1
		Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
		int[] dp = new int[sentence.length() + 1];
		for (int i = 1; i <= sentence.length(); i++) {
			dp[i] = dp[i - 1] + 1;
			for (int index = 0; index < i; index++) {
				// 遍历0-i的所有可能的字符串
				String s = sentence.substring(index, i);
				if (dictionarySet.contains(s)) {
					// 如果有字典字符串dp值，则比较当前位置dp和前面位置的dp
					dp[i] = Math.min(dp[index], dp[i]);
				}
			}
		}

		return dp[sentence.length()];

	}

	public static void main(String[] args) {
		Solution.respace(new String[] { "abc", "efg" }, "hhabcfefga");
	}

}

// 使用字典树
class Solution {
	public static int respace(String[] dictionary, String sentence) {
		// 构建字典树
		Trie trie = new Trie();
		for (String word : dictionary) {
			trie.insert(word);
		}
		// 状态转移，dp[i] 表示字符串的前 i 个字符的最少未匹配数
		int n = sentence.length();
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int idx : trie.search(sentence, i - 1)) {
				// 此处的坐标都是该位置前存在字典字符串的首字母的坐标
				dp[i] = Math.min(dp[i], dp[idx]);
			}
		}
		return dp[n];
	}
}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// 将单词倒序插入字典树
	public void insert(String word) {
		TrieNode cur = root;
		for (int i = word.length() - 1; i >= 0; i--) {
			int c = word.charAt(i) - 'a';
			if (cur.children[c] == null) {
				cur.children[c] = new TrieNode();
			}
			cur = cur.children[c];
		}
		cur.isWord = true;
	}

	// 找到 sentence 中以 endPos 为结尾的单词，返回这些单词的开头下标。
	public List<Integer> search(String sentence, int endPos) {
		List<Integer> indices = new ArrayList<>();
		TrieNode cur = root;
		for (int i = endPos; i >= 0; i--) {
			int c = sentence.charAt(i) - 'a';
			// 只往前找一个单词
			if (cur.children[c] == null) {
				break;
			}
			cur = cur.children[c];
			if (cur.isWord) {
				indices.add(i);
			}
		}
		return indices;
	}
}

class TrieNode {
	boolean isWord;
	TrieNode[] children = new TrieNode[26];

	public TrieNode() {
	}
}
