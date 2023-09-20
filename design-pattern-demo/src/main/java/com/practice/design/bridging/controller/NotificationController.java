package com.practice.design.bridging.controller;

import com.practice.R;
import com.practice.design.bridging.config.MsgSenderFactory;
import com.practice.design.bridging.dict.MsgType;
import com.practice.design.bridging.dict.NotificationType;
import com.practice.design.bridging.notification.Notification;
import com.practice.design.bridging.sender.MsgSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/20 22:13
 */
@RestController
@RequestMapping("bridging")
public class NotificationController  {

	private final Map<NotificationType, Notification> notificationMap;

	private final MsgSenderFactory msgSenderFactory;


	public NotificationController(Map<NotificationType, Notification> notificationMap, MsgSenderFactory msgSenderFactory) {
		this.notificationMap = notificationMap;
		this.msgSenderFactory = msgSenderFactory;
	}

	@GetMapping("/notify")
	public R<String> notifyNo(@RequestParam NotificationType notificationType, @RequestParam MsgType msgType,
	                          @RequestParam String message){
		Notification normalNotification = notificationMap.get(notificationType);
		MsgSender msgSender = msgSenderFactory.getMsgSender(msgType);
		normalNotification.setMsgSender(msgSender);
		normalNotification.notify(message);
		return R.success();
	}
}
