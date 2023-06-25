package com.practice.juc.volatiles;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/2 21:35
 */
public class SingletonDemo {
    private volatile static SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法");
    }

    public static void main(String[] args) {

//
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
        for(int i = 1; i <= 30; i++){
            new Thread(() ->{
                SingletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
    //DCL(双端检索机制 也不是线程安全的  可能存在第一次进来后 instance未初始化完成)
    public static SingletonDemo getInstance(){
        if (instance==null){
            synchronized (SingletonDemo.class){
                if (instance==null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
