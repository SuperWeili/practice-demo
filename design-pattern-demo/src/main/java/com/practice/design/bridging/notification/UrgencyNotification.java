package com.practice.design.bridging.notification;

import com.practice.design.bridging.MsgSender;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:12
 */
public class UrgencyNotification extends Notification{

	public UrgencyNotification(MsgSender msgSender) {
		super(msgSender);
	}

	@Override
	public void notify(String message) {
		msgSender.send(message);
	}
}
