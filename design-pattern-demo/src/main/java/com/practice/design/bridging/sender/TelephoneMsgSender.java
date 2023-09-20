package com.practice.design.bridging.sender;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:04
 */
@Service
public class TelephoneMsgSender implements MsgSender {
	private List<String> phones;


	@Override
	public void send(String message) {
		System.out.println("TelephoneMsgSender 发送了消息："+message);
	}
}
