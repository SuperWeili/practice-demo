package com.practice.design.bridging.notification;

import com.practice.design.bridging.MsgSender;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:08
 */
public abstract class Notification {

	protected MsgSender msgSender;

	public Notification(MsgSender msgSender) {
		this.msgSender = msgSender;
	}

	public abstract void notify(String message);
}
