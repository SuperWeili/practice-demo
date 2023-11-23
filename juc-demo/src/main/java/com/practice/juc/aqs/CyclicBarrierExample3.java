package com.practice.juc.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/17 16:26
 */
public class CyclicBarrierExample3 {

	/**
	 * 请求的数量
	 */
	private static final int THREAD_COUNT = 550;
	/**
	 * 需要同步的线程数量
	 */
	private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5, () -> {
		System.out.println("------当线程数达到之后，优先执行------");
	});

	public static void main(String[] args) throws InterruptedException {
		// 创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(10);

		for (int i = 0; i < THREAD_COUNT; i++) {
			final int threadNum = i;
			Thread.sleep(1000);
			threadPool.execute(() -> {
				try {
					test(threadNum);
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		threadPool.shutdown();
	}

	public static void test(int threadNum) throws InterruptedException, BrokenBarrierException {
		System.out.println("threadNum:" + threadNum + " is ready");
		CYCLIC_BARRIER.await();
		System.out.println("threadNum:" + threadNum + " is finish");
	}

}
