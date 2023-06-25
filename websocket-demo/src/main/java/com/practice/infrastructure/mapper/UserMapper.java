package com.practice.infrastructure.mapper;


import com.practice.infrastructure.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:31
 */
@Mapper
public interface UserMapper {

	void insertUser(@Param("list") List<User> users);

	int count();
}
