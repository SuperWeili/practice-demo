package com.practice.presentation.service;


import com.practice.domain.model.dto.UserDTO;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:23
 */
public interface UserService {

	void insertUser(List<UserDTO> users);

	int count();
}
