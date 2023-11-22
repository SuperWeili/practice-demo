package com.practice.kafka.presentation.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/14 22:09
 */
@RestController
public class KafkaController {
	@Resource
	private KafkaTemplate<String, String> kafkaTemplate;

	@PostMapping("/send")
	public void sendMessage(@RequestParam("message") String message) {
		kafkaTemplate.send("testTopic", message);
	}
}
