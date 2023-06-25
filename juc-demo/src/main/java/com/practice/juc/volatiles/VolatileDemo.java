package com.practice.juc.volatiles;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/1 21:10
 *  * 1.添加volatile 具有可见性
 *  * 2.没有原子性 （不可分割 ，某个线程正在做的时候 不可被分割 需要整体完整 ，要么成功 要么失败，保证数据的完整一致性）
 */
public class VolatileDemo {
    public static void main(String[] args) {
//        volatileSee();

        DataDemo dataDemo = new DataDemo();
        for(int i = 1; i <= 20; i++){
            new Thread(() ->{
                for (int j = 1; j <= 1000; j++) {
                    dataDemo.addPlus();
                    dataDemo.addAtomic();
                }
            },String.valueOf(i)).start();
        }
        // 线程都执行湾 来判断
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally value:"+dataDemo.number);
        System.out.println(Thread.currentThread().getName()+"\t addAtomic finally value:"+dataDemo.atomicInteger);

    }

    //可见性
    private static void volatileSee() {
        DataDemo dataDemo = new DataDemo();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dataDemo.addNumber();
            System.out.println(Thread.currentThread().getName() + "\t update=========");
        }, "AAA").start();

        //MAIN 线程
        while (dataDemo.number==0){
            //main 线程一直循环 volatile 回写到主内存  立马跳出循环
        }
        System.out.println(Thread.currentThread().getName() + "\t it over");
    }
}

class DataDemo {

    volatile int  number = 0;
    //并发下 值不丢失
    AtomicInteger atomicInteger = new AtomicInteger();

    void addNumber() {
        this.number = 60;
    }
    void addPlus(){
        number++;
    }
    void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}