package com.practice.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author LW
 * @version 1.0
 * @date 2023/6/27 22:19
 */
//@Configuration//@Component
	//springboot 初始化
public class DefaultUserFactory implements UserFactory , InitializingBean , DisposableBean {

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

	@PreDestroy
	public void preDestroy() {
		System.out.println("@PreDestroy : UserFactory 销毁中。。。");
	}

	/**
	 * Invoked by the containing {@code BeanFactory} on destruction of a bean.
	 *
	 * @throws Exception in case of shutdown errors. Exceptions will get logged
	 *                   but not rethrown to allow other beans to release their resources as well.
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("DisposableBean#destroy(): UserFactory 销毁中。。。");
	}

	public void doDestroy() throws Exception {
		System.out.println("自定义销毁方法doDestroy(): UserFactory 销毁中。。。");
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("当前DefaultUserFactory 对象正在被回收");
	}
}
