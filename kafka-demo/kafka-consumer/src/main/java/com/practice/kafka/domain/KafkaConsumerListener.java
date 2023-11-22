package com.practice.kafka.domain;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/14 22:13
 */
@Component
public class KafkaConsumerListener {

	@KafkaListener(topics = "${my.topic}", groupId = "test")
	public void listen(String message) {
		System.out.println("Received message: " + message);
	}

}


