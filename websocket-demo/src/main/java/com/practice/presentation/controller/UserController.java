package com.practice.presentation.controller;


import com.practice.configuration.WebSocketServlet;
import com.practice.domain.model.dto.UserDto;
import com.practice.presentation.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:22
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService service;

	@Resource
	private WebSocketServlet webSocketServlet;

	@PostMapping("/add")
	public int addUser(@RequestBody UserDto dto) {
		return service.insertUser(dto.getUsers());
	}

	@RequestMapping("/web")
	public void b() throws IOException {
		webSocketServlet.onMessage(1);
	}

}
