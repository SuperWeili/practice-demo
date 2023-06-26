package com.practice.juc.reenterlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/6 21:32
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("*******************召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            int finalI = i;
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到"+ finalI +"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
