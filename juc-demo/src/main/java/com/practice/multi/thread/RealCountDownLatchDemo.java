package com.practice.multi.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/7/27 10:49
 */
@Slf4j
public class RealCountDownLatchDemo {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 76, 4, 2, 45, 45, 343, 5, 45, 35, 543, 534);
		AtomicInteger atomicInteger = handleLogin(integers);
		System.out.println("==========="+atomicInteger.get());

	}

	public static AtomicInteger handleLogin(List<?> paramList) {
		// 使用线程池中线程分批处理业务逻辑，并行处理任务提高终端响应速度
		CountDownLatch latch = new CountDownLatch(paramList.size());
		AtomicInteger atomicInteger = new AtomicInteger(0);
		for (Object param : paramList) {
			ThreadUtils.execute(() -> {
				try {
					log.info("业务逻辑处理，参数：{}", param);
					// 业务逻辑正常处理......
					atomicInteger.addAndGet((Integer) param);
				} catch (Exception e) {
					log.error("调用下游系统出现错误，异常逻辑处理......");
				} finally {
					// 业务逻辑处理完毕，计数器减一【当前线程处理任务完毕，线程释放进入线程池，等待处理下一个任务】
					latch.countDown();
				}
			});
		}
		// 主线程需要等待子任务线程执行完，结果汇总之后，主线程继续往下执行
		try {
			latch.await();
		} catch (Exception e) {
			log.error("等待超时", e);
			throw new RuntimeException("系统处理超时，请稍后再试");
		}
		System.out.println("执行完成");
//		ThreadUtils.shutDown();
		return atomicInteger;
	}
}
