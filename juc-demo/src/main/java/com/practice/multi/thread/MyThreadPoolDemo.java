package com.practice.multi.thread;

import java.util.concurrent.*;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/18 18:08
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        // 手写线程池
        ExecutorService executorService = new ThreadPoolExecutor(2,
                5, 100, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 0; i < 20; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

    }

    private static void thread() {
        // 池子里 五个线程
//        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // 就一个
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 10; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
