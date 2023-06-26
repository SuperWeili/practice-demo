package com.practice.juc.reenterlock.cp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/7/27 17:19
 */
public class ConsumerProducer {

	public static void main(String[] args) {// 使用较小的队列，以更好地在输出中展示其影响
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
