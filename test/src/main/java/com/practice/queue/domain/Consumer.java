package com.practice.queue.domain;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LW
 * @version 1.0
 * @date 2023/12/5 22:17
 */
@Service
public class Consumer implements Runnable{

	@Resource
	private QueueBlockConfig queueBlockConfig;


	@Resource
	private ExecutorService executorService;


	@Override
	public void run() {
		while (true) {
			try {
				queueBlockConfig.poll();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
