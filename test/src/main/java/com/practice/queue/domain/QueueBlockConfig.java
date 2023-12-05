package com.practice.queue.domain;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LW
 * @version 1.0
 * @date 2023/12/5 21:51
 */
@Component
public class QueueBlockConfig {

	private  ArrayBlockingQueue<String> queue;


	public QueueBlockConfig(ArrayBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void add(String s) throws InterruptedException {
		if (StringUtils.isNoneBlank(s)) {
			queue.put(s);
		}
	}

	public void poll() throws InterruptedException {
		String take = queue.take();
		System.out.println("Consumer  start: "+take);
	}
}
