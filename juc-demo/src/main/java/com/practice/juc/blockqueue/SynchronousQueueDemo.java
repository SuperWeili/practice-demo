package com.practice.juc.blockqueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/11 17:26
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        new Thread(() ->{
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(() ->{
            try {
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) {e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+" "+ queue.take());
                System.out.println(Thread.currentThread().getName()+" "+ queue.take());

                System.out.println(Thread.currentThread().getName()+" "+ queue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }
}
