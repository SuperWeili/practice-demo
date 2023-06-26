package com.practice.juc.reenterlock;

import java.util.concurrent.CountDownLatch;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/6 21:14
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"走了");
                countDownLatch .countDown();

            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"main 最后执行");
    }
}
