package com.practice.domain.impl;


import com.practice.configuration.WebSocketServlet;
import com.practice.infrastructure.po.User;
import com.practice.infrastructure.po.mapper.UserMapper;
import com.practice.presentation.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:25
 */
@AllArgsConstructor
@Component
@NoArgsConstructor
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	@Resource
	private WebSocketServlet webSocketServlet;

	@Override
	public int insertUser(List<User> users) {

		int i = userMapper.insertUser(users);
		int count = count();
		webSocketServlet.onMessage(count);
		return i;
	}

	@Override
	public int count() {
		return userMapper.count();
	}
}
