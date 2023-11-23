package com.practice.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LW
 * @version 1.0
 * @date 2023/3/8 20:53
 * 给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，请你从数组中找出满足相加之和等于目标数target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 有序数组的两数之和 {

	// 双指针方法
	public static int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (target == sum) {
				return new int[]{i + 1, j + 1};
			}
			if (target > sum) {
				i++;
			} else {
				j--;
			}
		}
		return null;
	}

	public static int[] twoSum(int target, int[] numbers) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			if (map.get(numbers[i]) != null) {
				return new int[]{map.get(numbers[i]) + 1, i + 1};
			}
			map.put(target - numbers[i], i);
		}
		return null;
	}

	// 两数之和相似
	public static void main(String[] args) {
		int[] sum = {1, 34, 67, 100, 1201, 1234, 1567, 2345, 56787};
		int target = 3_546;
		int[] res = twoSum(sum, target);
		System.out.println(Arrays.toString(res));

		int[] twoSum = twoSum(target, sum);
		System.out.println(Arrays.toString(twoSum));

	}
}
