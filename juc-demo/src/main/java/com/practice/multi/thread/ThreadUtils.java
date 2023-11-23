package com.practice.multi.thread;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.*;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/7/27 10:31
 */
public class ThreadUtils {
	private static ExecutorService executorService;

	static {
		ThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
				.namingPattern("basicThreadFactory-%d").build();

		/*
		 * 构建一个线程池
		 * 获取服务器CPU的核数：Runtime.getRuntime().availableProcessors()
		 * 线程池定义大小：CPU * 2 + 1
		 */
		executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2 + 1,
				Runtime.getRuntime().availableProcessors() * 2 + 1, 0L,
				TimeUnit.SECONDS, new LinkedBlockingDeque<>(10000), basicThreadFactory
		);
	}

	public static void execute(Runnable task) {
		executorService.execute(task);
	}

	public static void shutDown() {
		executorService.shutdown();
	}
}
