package com.practice.multi.thread;

import lombok.AllArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/27 20:50
 * 产生死锁的原因， 资源不够， 资源分配不当
 * liunx ps -ef|grep xxx
 * windows 下java运行程序， jpa = java ps
 * 查看异常信息 jstack
 * jps 定位进程号，jstack找到死锁
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"aaa").start();
        new Thread(new HoldLockThread(lockB,lockA),"BBB").start();

    }
}
@AllArgsConstructor
class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockA+"尝试获取："+lockB);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {e.printStackTrace(); }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t 自己持有:"+lockB+"尝试获取："+lockA);
                try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) {e.printStackTrace(); }
            }
        }
    }
}
