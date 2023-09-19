package com.practice.spring.bean;

import com.google.common.base.MoreObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LW
 * @version 1.0
 * @date 2023/7/2 19:50
 */
//@Component
public class User extends SuperUser{

//	@Value("${name:User的name}")
	private String name;

//	@Value("${age:user的age}")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("name", name)
				.add("age", age)
				.toString();
	}
}
