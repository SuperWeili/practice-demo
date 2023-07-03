package com.practice.gc;

import java.util.concurrent.TimeUnit;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/29 21:15
 * jps -l
 * jinfo -flags pidjava
 * java -XX:+PrintFlagsInitial jvm调优 非常非常重要
 * java -XX:+PrintFlagsFinal := 人为修改过
 * java -XX:+PrintCommandLineFlags -version 看垃圾回收器
 */
public class HelloGc {
    public static void main(String[] args) {
        System.out.println("==========");
        try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) {e.printStackTrace(); }
    }
}
