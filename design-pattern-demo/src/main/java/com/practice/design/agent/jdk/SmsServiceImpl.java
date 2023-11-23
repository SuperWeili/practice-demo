package com.practice.design.agent.jdk;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 14:52
 */
public class SmsServiceImpl implements SmsService{
	@Override
	public String send(String message) {
		System.out.println("send message: "+message);
		return message;
	}
}
