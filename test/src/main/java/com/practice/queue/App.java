package com.practice.queue;

import com.practice.queue.domain.Consumer;
import com.practice.queue.domain.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LW
 * @version 1.0
 * @date 2023/12/5 21:45
 */
@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private Producer producer;

	@Autowired
	private Consumer consumer;
	public static void main(String[] args) {
		SpringApplication.run(App.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
