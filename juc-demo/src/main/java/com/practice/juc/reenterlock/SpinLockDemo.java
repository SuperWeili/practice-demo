package com.practice.juc.reenterlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/5 19:17
 * 自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread =Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" come in");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"invked myUnLock");

    }
    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() ->{
            spinLockDemo.myLock();
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) {e.printStackTrace(); }
            spinLockDemo.myUnLock();
        },"aa").start();
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {e.printStackTrace(); }
        new Thread(() ->{
            spinLockDemo.myLock();
            spinLockDemo.myUnLock();
        },"bbb").start();

    }
}
