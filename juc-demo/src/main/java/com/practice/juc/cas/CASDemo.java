package com.practice.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/2 22:06
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2021)+"" +
                "\t current value:"+ atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1998)+"" +
                "\t current value:"+ atomicInteger.get());
    }
}
