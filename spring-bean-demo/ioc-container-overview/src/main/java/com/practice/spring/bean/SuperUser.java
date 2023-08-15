package com.practice.spring.bean;

import com.google.common.base.MoreObjects;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LW
 * @version 1.0
 * @date 2023/7/2 19:50
 */
@Component
public class SuperUser {

//	@Value("${address:SuperUser的地址}")
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("address", address)
				.toString();
	}
}
