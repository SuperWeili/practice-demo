package com.practice.domain.impl;


import com.practice.configuration.WebSocketServlet;
import com.practice.domain.convert.UserConvert;
import com.practice.domain.model.dto.UserDTO;
import com.practice.infrastructure.mapper.UserMapper;
import com.practice.infrastructure.po.User;
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

	@Resource
	private UserConvert userConvert;

	@Override
	public void insertUser(List<UserDTO> userDtos) {
		List<User> users = userConvert.userDTOToPOList(userDtos);
		userMapper.insertUser(users);
		int count = count();
		webSocketServlet.onMessage(count);
	}

	@Override
	public int count() {
		return userMapper.count();
	}
}
