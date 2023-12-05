package com.practice.queue.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2023/12/5 22:30
 */
@Configuration
public class Config {

	@Bean
	public ArrayBlockingQueue<String> arrayBlockingQueue(){
		return new ArrayBlockingQueue<>(100000);
	}

	@Bean(destroyMethod = "shutdown")
	public ExecutorService executorService() {
		return new ThreadPoolExecutor(
				2, // 核心线程数
				4, // 最大线程数
				60L, // 线程空闲时间（单位：秒）
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5) // 线程池的工作队列
		);
	}
}
