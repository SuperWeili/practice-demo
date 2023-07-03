package com.practice.gc;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/18 21:35
 * G1垃圾收集器 横跨年轻代和老年代两个区（garbage-first heap）
 * g1 面向服务端应用的收集器 应用在多处理器和大容量内存环境中，在实现高吞吐量的同时，
 * 尽可能的满足垃圾收集暂停时间的要求
 * G1收集器的设计目标是取代CMS收集器，它是一个有整理内存过程的收集器，不会产生很多内存碎片
 * G1的stw跟可控，G1在停顿时间上添加了预测机制，用户可以指定期望停顿时间
 * 主要改变是eden，survivor和Tenured等内存区域不再是连续的了，而是变成了一个个大小一样
 * 的region，每个region从1M到32m不等，一个region有可能属于期间的任何一个内存区域
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
 *
 * G1整体采用标记-整理，局部通过复制算法，不会产生内存碎片
 * -XX:+UseG1GC
 */
public class G1Demo {
	public static void main(String[] args) {
		System.out.println("----------------------");
		byte[] bytes = new byte[1024*1024*1024];
	}
}
