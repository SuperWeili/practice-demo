package com.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 */
@SpringBootApplication
@EnableScheduling
@MapperScan("com.practice.infrastructure.mapper")
public class WebSocketApp {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketApp.class, args);
	}
}
