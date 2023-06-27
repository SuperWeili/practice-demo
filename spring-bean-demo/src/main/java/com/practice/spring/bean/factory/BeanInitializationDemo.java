package com.practice.spring.bean.factory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * bean 初始化Demo {@link AnnotationConfigApplicationContext}
 *
 * @author LW
 * @version 1.0
 * @date 2023/6/27 22:25
 */
public class BeanInitializationDemo {

	public static void main(String[] args) {
		// 创建BeanFactory容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册configuration class （配置类）
		applicationContext.register(BeanInitializationDemo.class);
		// 启动Spring应用上下文
		applicationContext.refresh();
		// 依赖查找UserFactory
		UserFactory bean = applicationContext.getBean(UserFactory.class);
		// 关闭Spring上下文
		applicationContext.close();
	}

	@Bean(initMethod = "initUserFactory")
	public UserFactory userFactory(){
		return new DefaultUserFactory();
	}
}
