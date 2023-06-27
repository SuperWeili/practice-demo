package com.practice.juc.blockqueue;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/11 18:30
 * volatile/cas/atomicInteger/blockQueue/线程交互/原子引用
 * 生产者消费者模式pro 高并发 自动判断
 */
public class ProdBlockDemo {
    public static void main(String[] args) {
        MySource mySource = new MySource(new ArrayBlockingQueue(1));
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"\t 生产线程启动");

            try {
                mySource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"prod").start();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName()+"\t 消费线程启动");

            try {
                mySource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"consumer").start();
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) {e.printStackTrace(); }
        System.out.println("5 秒钟时间一到，都停止");
        mySource.stop();
    }
}

class MySource {
    // 默认开启 进行生产+消费
    private volatile boolean FLAG = true;
    private LongAdder longAdder = new LongAdder();
    BlockingQueue blockingQueue = null;

    public MySource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(Thread.currentThread().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            longAdder.increment();
            data = longAdder.intValue() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，表示FLAG = FALSE, 生产结束");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = (String) blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (StringUtils.isBlank(result)){
                FLAG = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒钟没取到就推出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }
    }
    public void stop(){
        this.FLAG =false;
    }

}
