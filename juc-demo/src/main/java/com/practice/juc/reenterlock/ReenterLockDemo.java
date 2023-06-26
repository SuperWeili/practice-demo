package com.practice.juc.reenterlock;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/5 18:49
 * 可重入锁也叫递归锁
 * 指的是同一下线程外层函数获得锁之后，内层递归函数仍然能获得该锁的代码
 * 在同一个线程下，进入内层方法会自动获取锁，
 * 也就是说，线程可以进入任何一个它已经拥有的锁的同步的代码块
 * 可重入锁 最大有嗲那就是避免死锁
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("============");
        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();

    }
}

class Phone implements Runnable {
    ReentrantLock lock = new ReentrantLock();

    public synchronized void sendSms() throws Exception {
        System.out.println(Thread.currentThread().getName() + " invoked sendSms");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + " invoked sendEmail");

    }


    @Override
    public void run() {
        try {
            get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void get() throws Exception {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
