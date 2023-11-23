package com.practice.algorithm;

/**
 * @author LW
 * @version 1.0
 * @date 2022/11/16 14:21
 * 1,1,2,3,5,8,13,21,34
 * 参数是n 计算第n个数的值
 * <p>
 * 不使用库函数 计算正数的平方根
 */
public class 正数的平方根 {

	public static void main(String[] args) {
		System.out.println(test2(5));
		int a = 0;
		long b = 123;
		long c = 123;


		test3(10);
	}

	public static int test2(int n) {

		if (n <= 2) {
			return 1;
		} else {
			int num1 = 1;
			int num2 = 1;
			for (int i = 2; i < n - 1; i++) {
				num2 = num1 + num2;
				num1 = num2 - num1;
			}
			return num1 + num2;
		}
	}

	public static double test3(double n) {
		double start = 0;
		double end = n;
		double mid = (start + end) / 2;
		if (end == mid)
			while (true) {
				double a = mid * mid;
				if (a > n) {
					end = (start + end) / 2;
				}
				if (a <= n) {
					start = (start + end) / 2;
				}
				mid = (start + end) / 2;
				String s = String.valueOf(mid);

				System.out.println(mid);
			}
		return 2.0D;
	}

}
