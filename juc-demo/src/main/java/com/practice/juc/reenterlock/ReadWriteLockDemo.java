package com.practice.juc.reenterlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @author LW
 * @version 1.0
 * @date 2021/12/6 20:47
 * 多个线程读一个资源类，
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for(int i = 1; i <= 5; i++){
            int finalI = i;
            new Thread(() ->{
                myCache.put(finalI+"",finalI+"");

            },String.valueOf(i)).start();
        }

        for(int i = 1; i <= 5; i++){
            int finalI = i;
            new Thread(() ->{
                myCache.get(finalI+"");
            },String.valueOf(i)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        lock .writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入"+key);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 正在完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock .writeLock().unlock();
        }

    }

    public void get(String key){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取"+key);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) {e.printStackTrace(); }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.readLock().unlock();
        }

    }
}
