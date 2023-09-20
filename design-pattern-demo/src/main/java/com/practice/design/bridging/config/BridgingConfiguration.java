package com.practice.design.bridging.config;

import com.practice.design.bridging.dict.NotificationType;
import com.practice.design.bridging.notification.NormalNotification;
import com.practice.design.bridging.notification.Notification;
import com.practice.design.bridging.notification.ServerNotification;
import com.practice.design.bridging.notification.UrgencyNotification;
import com.practice.design.bridging.sender.EmailMsgSender;
import com.practice.design.bridging.sender.MsgSender;
import com.practice.design.bridging.sender.TelephoneMsgSender;
import com.practice.design.bridging.sender.WeChatMsgSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/20 21:19
 */
@Configuration
public class BridgingConfiguration {

	@Bean
	public Map<NotificationType, Notification> notificationMap(NormalNotification normalNotification,
	                                                           ServerNotification serverNotification,
	                                                           UrgencyNotification urgencyNotification) {
		Map<NotificationType, Notification> map = new HashMap<>();
		map.put(NotificationType.NORMAL, normalNotification);
		map.put(NotificationType.SERVER, serverNotification);
		map.put(NotificationType.URGENCY, urgencyNotification);
		return map;

	}

	@Bean(name = "EMAIL")
	public EmailMsgSender emailMsgSender() {
		return new EmailMsgSender();
	}


	@Bean(name = "TELEPHONE")
	public MsgSender telephoneMsgSender() {
		return new TelephoneMsgSender();
	}


	@Bean(name = "WECHAT")
	public MsgSender wechatMsgsender() {
		return new WeChatMsgSender();
	}




}
