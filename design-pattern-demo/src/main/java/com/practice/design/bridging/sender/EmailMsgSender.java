package com.practice.design.bridging.sender;

import com.practice.design.bridging.MsgSender;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:05
 */
public class EmailMsgSender implements MsgSender {
	private List<String> emails;

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	@Override
	public void send(String message) {
		System.out.println("EmailMsgSender 发送了消息："+message);
	}
}
