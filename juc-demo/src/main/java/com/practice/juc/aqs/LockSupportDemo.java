package com.practice.juc.aqs;

import java.util.concurrent.locks.LockSupport;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/24 22:11
 */
public class LockSupportDemo {
	static Object object = new Object();

	public static void main(String[] args) {
		Thread a = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " 进来了");
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "被唤醒");

		}, "A");
		a.start();
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + " ...通知");
			LockSupport.unpark(a);

		}, "B").start();
	}
}
