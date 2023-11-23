package com.practice.design.agent.cglib;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 15:20
 */
public class AliSmsService {

	public String send(String message) {
		System.out.println("send message: " + message);
		return message;
	}
}
