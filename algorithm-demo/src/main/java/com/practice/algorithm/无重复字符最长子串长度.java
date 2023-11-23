package com.practice.algorithm;

import java.util.HashMap;

/**
 * @author LW
 * @version 1.0
 * @date 2022/6/7 21:47
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class 无重复字符最长子串长度 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

	/**
	 * 以这个字符串为例：abcabcbb，当i等于3时，也就是指向了第二个a,
	 * 此时我就需要查之前有没有出现过a, 如果出现了是在哪一个位置出现的。
	 * 然后通过last[index] 查到等于1, 也就是说，如果start 依然等于0的话，
	 * 那么当前窗口就有两个a了，也就是字符串重复了，所以我们需要移动当前窗口的start指针，
	 * 移动到什么地方呢？移动到什么地方，窗口内就没有重复元素了呢？
	 * 对了，就是a上一次出现的位置的下一个位置，就是1 + 1 = 2。当start == 2,
	 * 当前窗口就没有了重复元素，那么以当前字符为结尾的最长无重复子串就是bca,
	 * 然后再和之前的res取最大值。然后i指向后面的位置，按照同样思路计算。
	 *
	 */
	public static int lengthOfLongestSubstring(String s) {
		// 记录字符上一次出现的位置 初始都是0
		int[] last = new int[128];

		int n = s.length();

		int res = 0;
		// 窗口开始位置
		int start = 0;
		for (int i = 0; i < n; i++) {
			// 转成ascII码
			int index = s.charAt(i);
			start = Math.max(start, last[index]);
			res = Math.max(res, i - start + 1);
			last[index] = i + 1;
		}
		return res;
	}

	/**
	 *
	 */
	public static int lengthOfLongestSubstring2(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int max = 0, start = 0;
		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			if (map.containsKey(ch)){
				//+1因为要去掉最前面一个重复的 从下一个从头开始
				start = Math.max(map.get(ch)+1,start);
			}
			// 当前位置减去起始的第一次出现的位置长度 和原始保存的长度相比 去最长  ***真牛逼
			max = Math.max(max,end - start + 1);
			map.put(ch,end);
		}
		return max;
	}
}
