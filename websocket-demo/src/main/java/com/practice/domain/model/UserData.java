package com.practice.domain.model;


import com.practice.domain.model.dto.UserDTO;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/6/25 20:09
 */

public class UserData {

	List<UserDTO> userDtoList;

	public List<UserDTO> getUserDtoList() {
		return userDtoList;
	}

	public void setUserDtoList(List<UserDTO> userDtoList) {
		this.userDtoList = userDtoList;
	}

}
