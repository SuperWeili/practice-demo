package com.practice.juc.reenterlock.cp;

import java.util.concurrent.BlockingQueue;


/**
 * @author LiWei
 * @version 1.0
 * @date 2022/7/27 17:21
 */
public class Producer implements Runnable {
	private final BlockingQueue<String> queue;

	private static final String EXIT_MSG = "Good bye!";

	public Producer(BlockingQueue<String> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(5L);
				String msg = "Message" + i;
				System.out.println("Produced new item: " + msg);
				queue.put(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			System.out.println("Time to say good bye!");
			queue.put(EXIT_MSG);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

