package com.practice.juc.aqs;

import java.util.concurrent.*;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/17 16:16
 */
public class CyclicBarrierExample2 {

	/**
	 * 请求的数量
	 */
	private static final int THREAD_COUNT = 550;
	/**
	 * 需要同步的线程数量
	 */
	private static final CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(5);

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

	public static void test(int threadCount) throws InterruptedException, BrokenBarrierException {
		System.out.println("threadCount:" + threadCount + "is ready");
		try {
			//等待60秒，保证子线程完全执行结束
			CYCLIC_BARRIER.await(60, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("-----CyclicBarrierException------");
		}
		System.out.println("threadCount: " + threadCount + " is finish");
	}
}
