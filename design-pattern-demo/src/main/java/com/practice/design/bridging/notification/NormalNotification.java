package com.practice.design.bridging.notification;

import com.practice.design.bridging.MsgSender;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:13
 */
public class NormalNotification extends Notification{

	public NormalNotification(MsgSender msgSender) {
		super(msgSender);
	}

	@Override
	public void notify(String message) {

	}
}
