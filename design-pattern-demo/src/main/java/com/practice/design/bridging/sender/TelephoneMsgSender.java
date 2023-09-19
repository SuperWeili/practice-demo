package com.practice.design.bridging.sender;

import com.practice.design.bridging.MsgSender;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:04
 */
public class TelephoneMsgSender implements MsgSender {
	private List<String> phones;

	public TelephoneMsgSender(List<String> phones) {
		this.phones = phones;
	}

	@Override
	public void send(String message) {
		System.out.println("TelephoneMsgSender 发送了消息："+message);
	}
}
