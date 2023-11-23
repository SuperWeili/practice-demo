package com.practice.design.agent.jdk;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 15:04
 */
public class Work {
	public static void main(String[] args) {
		SmsService proxy = (SmsService)JdkProxyFactory.getProxy(new SmsServiceImpl());
		proxy.send("java");
	}
}
