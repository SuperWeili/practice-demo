package com.practice.juc.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/17 16:15
 */
public class CountDownLatchExample1 {

	// 请求的数量
	private static final int THREAD_COUNT = 550;

	public static void main(String[] args) throws InterruptedException {
		// 创建一个具有固定线程数量的线程池对象（如果这里线程池的线程数量给太少的话你会发现执行的很慢）
		ExecutorService threadPool = Executors.newFixedThreadPool(300);
		final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
		for (int i = 0; i < THREAD_COUNT; i++) {
			final int threadnum = i;
			threadPool.execute(() -> {
				try {
					test(threadnum);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					countDownLatch.countDown();// 表示一个请求已经被完成
				}

			});
		}
		countDownLatch.await();
		threadPool.shutdown();
		System.out.println("finish");
	}

	public static void test(int threadnum) throws InterruptedException {
		// 模拟请求的耗时操作
		Thread.sleep(1000);
		System.out.println("threadNum:" + threadnum);
		// 模拟请求的耗时操作
		Thread.sleep(1000);
	}
}
