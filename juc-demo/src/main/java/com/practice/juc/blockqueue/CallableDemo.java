package com.practice.juc.blockqueue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/17 21:17
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask<Integer>(myThread);
        Thread thread = new Thread(futureTask,"t1");
        thread.start();

        // 要求获得 该线程的计算结果  一般放到最后 否则会堵塞 直到计算完成
        Integer o = (Integer) futureTask.get();
        System.out.println(o);

    }
}
class MyThread implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("=================come in callable ");
        return 1024;
    }
}
