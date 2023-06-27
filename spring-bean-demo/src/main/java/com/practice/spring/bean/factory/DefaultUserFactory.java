package com.practice.spring.bean.factory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author LW
 * @version 1.0
 * @date 2023/6/27 22:19
 */
//@Configuration//@Component
	//springboot 初始化
public class DefaultUserFactory implements UserFactory , InitializingBean {

	@PostConstruct
	public void init() {
		System.out.println("UserFactory 初始化中..");
	}

	public void initUserFactory(){
		System.out.println("自定义初始化方法initUserFactory（）:UserFactory 初始化中.. " );
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean#afterPropertiesSet() :UserFactory 初始化中.. " );

	}
}
