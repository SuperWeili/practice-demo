package com.practice.juc.reenterlock;

import java.util.concurrent.CountDownLatch;

/**
 * @author LW
 * @version 1.0
 * @date 2022/5/26 16:09
 */
public class CountDownLatchDemo2 {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new FirstBatchWorker(countDownLatch));
			thread.start();
		}

		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new SecondBatchWorker(countDownLatch));
			thread.start();
		}

		while (countDownLatch.getCount()!=1){
			Thread.sleep(1000);
		}
		System.out.println("first is done");
		countDownLatch.countDown();
	}



}
class FirstBatchWorker implements Runnable{
	private CountDownLatch countDownLatch;

	public FirstBatchWorker(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("FirstBatchWorker execute!");
		countDownLatch.countDown();
	}
}

class SecondBatchWorker implements Runnable{
	private CountDownLatch countDownLatch;

	public SecondBatchWorker(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("SecondBatchWorke execute!");
		countDownLatch.countDown();
	}
}
