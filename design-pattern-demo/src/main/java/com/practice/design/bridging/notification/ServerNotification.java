package com.practice.design.bridging.notification;

import com.practice.design.bridging.sender.MsgSender;
import org.springframework.stereotype.Service;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/19 22:10
 */
@Service("SERVER")
public class ServerNotification extends Notification{

	public ServerNotification() {
	}

	@Override
	public void notify(String message) {
		msgSender.send(message);
	}
}
