package com.practice.multi.threadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/17 16:53
 */
public class ThreadLocalTest {
	private final List<String> messages = new ArrayList<>();
	private final static ThreadLocal<ThreadLocalTest> HOLDER = ThreadLocal.withInitial(ThreadLocalTest::new);

	private static void add(String message) {
		HOLDER.get().messages.add(message);
	}

	private static void clear() {
		HOLDER.remove();
		System.out.println("size : " + HOLDER.get().messages.size());
	}

	public static void main(String[] args) {
		ThreadLocalTest.add("一枝花算不算浪漫");
		System.out.println(HOLDER.get().messages);
		ThreadLocalTest.clear();
	}
}
