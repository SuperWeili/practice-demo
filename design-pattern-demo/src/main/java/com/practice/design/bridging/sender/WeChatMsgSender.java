package com.practice.design.bridging.sender;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:06
 */
@Service
public class WeChatMsgSender implements MsgSender {
	private List<String> accounts;

	public WeChatMsgSender(List<String> accounts) {
		this.accounts = accounts;
	}

	public WeChatMsgSender() {
	}

	@Override
	public void send(String message) {
		System.out.println("WeChatMsgSender 发送了消息："+message);
	}
}
