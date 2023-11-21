package com.practice.kafka.domain;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/14 22:13
 */
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "${my.topic}", groupId = "${my.group}",id = "7xN7AbRJSRWnLe2TdqlIYg")
	public void listen(String message) {
		System.out.println("Received message: " + message);
	}

}


