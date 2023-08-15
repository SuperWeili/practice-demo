package com.practice.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean 初始化Demo {@link AnnotationConfigApplicationContext}
 *
 * @author LW
 * @version 1.0
 * @date 2023/6/27 22:25
 */
public class BeanDemo {

	public static void main(String[] args) {
		// 创建BeanFactory容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册configuration class （配置类）
		applicationContext.register(BeanDemo.class);
		// 启动Spring应用上下文
		applicationContext.refresh();
		// 非延迟初始化在Spring应用上下文启动完成后，被初始化
		System.out.println("Spring 应用上下文已被启动。。");
		// 依赖查找UserFactory
		User bean = (User) applicationContext.getBean(User.class);
		System.out.println(bean);
		System.out.println("Spring 应用上下文准备关闭。。");
		// 关闭Spring上下文
		applicationContext.close();
		System.out.println("Spring 应用上下文已被关闭。。");
	}

	@Bean("user")
	public User user() {
		User user = new User();
		user.setAge(1);
		user.setName("user的name");
		user.setAddress("user的address");
		return user;
	}

	@Bean("user")
	public SuperUser superUser() {
		SuperUser superUser = new SuperUser();
		superUser.setAddress("superUser的address");
		return superUser;
	}
}
