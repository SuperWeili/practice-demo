package com.practice.juc.blockqueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/11 16:56
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
        /**
         * 1
         * 添加移除 都报异常add，remove
         */
//        System.out.println(arrayBlockingQueue.add("a"));
//        System.out.println(arrayBlockingQueue.add("b"));
//        System.out.println(arrayBlockingQueue.add("c"));
//        System.out.println(arrayBlockingQueue.element());
//        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());

        /**
         * 2
         * offer 返回true false poll 返回null
         */
//        System.out.println(arrayBlockingQueue.offer("a"));
//        System.out.println(arrayBlockingQueue.offer("b"));
//        System.out.println(arrayBlockingQueue.offer("c"));
//        System.out.println(arrayBlockingQueue.offer("d"));
//        Object peek = arrayBlockingQueue.peek();
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());
//        System.out.println(arrayBlockingQueue.poll());

        /**
         * 3
         * 无返回 超出就阻塞
         */
//        arrayBlockingQueue.put("a");
//        arrayBlockingQueue.put("a");
//        arrayBlockingQueue.put("a");
////        arrayBlockingQueue.put("a");
//        System.out.println(arrayBlockingQueue);
//        System.out.println("==================");
//        arrayBlockingQueue.take();
//        arrayBlockingQueue.take();
//        arrayBlockingQueue.take();
//        arrayBlockingQueue.take();

        /**
         * 4 时间限制 过时不厚
         */
        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));

        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));

        System.out.println(arrayBlockingQueue.offer("a", 2L, TimeUnit.SECONDS));



    }
}
