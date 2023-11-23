package com.practice.algorithm;

import java.util.HashMap;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/24 21:09
 * 给定一个整数数组，和一个目标值target 在数组中找出目标值的 和
 * eg：nums = [2,7,11,16] ,target = 9
 * nums[0]+num[1] = 9
 * 所以返回【0，1】
 */
public class 两数之和 {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
//		System.out.println(Arrays.toString(twosSum1(nums, target)));

	}

	/**
	 * 此方法垃圾 55ms左右
	 *
	 * @param nums   数组
	 * @param target 目标
	 * @return 数组
	 */
	public static int[] twosSum1(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target - nums[i] == nums[j]) {
					return new int[]{i, j};
				}
			}
		}
		return null;
	}

	//正解  此方法 速度2ms
	public static int[] twoSum2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int partnerNumber = target - nums[i];
			if (map.containsKey(partnerNumber)) {
				return new int[]{map.get(partnerNumber), i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
}

