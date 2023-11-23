package com.practice.multi.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/18 18:40
 * 线程执行 核心线程满了 队列满了 新进来的 立即执行。。。
 * 线程数量如何选择：： 1，看类型 如果是cpu密集的 那么就是核数+1个线程的线程池，2
 * 2 如果是io密集的话 分两种情况 （1） cpu核数*2 经可能的多 （2） （cpu核数）/（1-阻塞系数）  阻塞系数通常是0.8-0.9
 */
public class ThreadPoolFactory {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 100L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 1; i <= 6; i++) {
                int finalI = i;
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"号窗口，服务客户"+ finalI);
                    try { TimeUnit.SECONDS.sleep(4); } catch (InterruptedException e) {e.printStackTrace(); }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }

    }
}
