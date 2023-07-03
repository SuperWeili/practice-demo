package com.practice.gc;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/18 21:18
 * cms 标记清除算法
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 * 初始化标记，并发标记，重新标记，并发清除
 */
public class CMSDemo {
	public static void main(String[] args) {
		System.out.println("----------------------");
		byte[] bytes = new byte[1024*1024*1024];
	}
}
