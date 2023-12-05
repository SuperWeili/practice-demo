package com.practice.queue.domain;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author LW
 * @version 1.0
 * @date 2023/12/5 22:35
 */
@RestController
public class Controller {

	@Resource
	private Producer producer;

	@PostMapping("/queue/add")
	public void add(){
		producer.run();
	}
}
