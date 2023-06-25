package com.practice.infrastructure.po.mapper;


import com.practice.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:31
 */
@Mapper
public interface UserMapper {

	int insertUser(List<User> users);

	int count();
}
