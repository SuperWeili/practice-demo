//package com.practice.bridging;
//
//import com.practice.design.bridging.sender.MsgSender;
//import com.practice.design.bridging.notification.Notification;
//import com.practice.design.bridging.notification.ServerNotification;
//import com.practice.design.bridging.sender.EmailMsgSender;
//import org.junit.jupiter.api.Test;
//
///**
// * @author LW
// * @version 1.0
// * @date 2023/9/19 22:16
// */
//public class BridgingTest {
//	@Test
//	public void test() {
//		MsgSender emailMsgSender = new EmailMsgSender();
//		Notification serverNotification = new ServerNotification(emailMsgSender);
//		serverNotification.notify("你好");
//
//	}
//}
