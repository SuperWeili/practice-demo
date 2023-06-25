package com.practice.infrastructure.po;

import lombok.*;

/**
 * @author LW
 * @version 1.0
 * @date 2022/12/20 17:26
 */

public class User {

	private Integer id;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
