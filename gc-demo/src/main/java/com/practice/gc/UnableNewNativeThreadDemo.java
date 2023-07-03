package com.practice.gc;

import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/12 21:55
 * 高并发请求服务器的时候，会出现 OOM -UnableNewNativeThread 这个错误
 *  准确的讲该native thread与对应的平台有关
 *  导致原因：
 *   1 你的应用创建了太多的线程，一个应用进程创建了多个线程，超过了系统承载的极限，
 *   2 你的服务器不允许你的应用程序创建这么多线程，linux系统默认单个进程 可以创建的线程数1024个
 * 解决办法：
 * 1，想办法降低你应用程序创建线程的数量，分析应用是否真的需要创建这么多线程，如果不是改代码，
 * 2  对于有的应用，该linux服务配置
 */
public class UnableNewNativeThreadDemo {
	// 在linux中运行看结果
	public static void main(String[] args) {
		for (int i = 1;  ; i++) {
			new Thread(() ->{
			try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) {e.printStackTrace(); }
			},""+i).start();
		}
	}
}
