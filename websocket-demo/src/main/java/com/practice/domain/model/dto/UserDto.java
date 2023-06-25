package com.practice.domain.model.dto;


import com.practice.infrastructure.po.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author LW
 * @version 1.0
 * @date 2023/2/15 20:30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private List<User> users;
}
