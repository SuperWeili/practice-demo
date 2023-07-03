package com.practice.gc;

import java.nio.ByteBuffer;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/12 21:43
 * 分配到本地内存，内存不够报错 在堆内存以外new对象，由于不需要内存拷贝 所以速度相对比较快
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 */
public class DirectBufferMemoryDemo {
	public static void main(String[] args) {
		System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");
		ByteBuffer allocate = ByteBuffer.allocateDirect(6 * 1024 * 1024);
	}
}
