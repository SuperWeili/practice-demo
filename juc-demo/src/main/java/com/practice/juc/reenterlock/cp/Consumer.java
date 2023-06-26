package com.practice.juc.reenterlock.cp;

import java.util.concurrent.BlockingQueue;


/**
 * @author LiWei
 * @version 1.0
 * @date 2022/7/27 17:41
 */
public class Consumer implements Runnable {
	private BlockingQueue<String> queue;

	private static final String EXIT_MSG = "Good bye!";

	public Consumer(BlockingQueue<String> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			String msg;
			while (!EXIT_MSG.equalsIgnoreCase((msg = queue.take()))) {
				System.out.println("Consumed item: " + msg);
				Thread.sleep(10L);
			}
			System.out.println("Got exit message, bye!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}