package com.practice.design.agent.cglib;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 15:29
 */
public class Work {
	public static void main(String[] args) {
		AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
		proxy.send("java");
	}
}
