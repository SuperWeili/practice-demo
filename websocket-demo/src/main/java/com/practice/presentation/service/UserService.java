package com.practice.presentation.service;


import com.practice.infrastructure.po.User;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:23
 */
public interface UserService {

	int insertUser(List<User> users);

	int count();
}
