package com.practice.queue.domain;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LW
 * @version 1.0
 * @date 2023/12/5 21:55
 */
@Service
public class Producer implements Runnable{

	@Resource
	private QueueBlockConfig queueBlockConfig;


	@Override
	public void run() {
		for (int i = 0; i < 9000; i++) {
			System.out.println("Producing product with ID: " + i);
			try {
				queueBlockConfig.add("id: "+i);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
