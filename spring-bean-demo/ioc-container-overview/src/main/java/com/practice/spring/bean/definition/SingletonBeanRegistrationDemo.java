package com.practice.spring.bean.definition;

import com.practice.spring.bean.factory.DefaultUserFactory;
import com.practice.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体bean 注册实例
 * @author LW
 * @version 1.0
 * @date 2023/6/28 20:54
 */
public class SingletonBeanRegistrationDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 创建一个外部UserFactory对象
		UserFactory defaultUserFactory = new DefaultUserFactory();
		SingletonBeanRegistry beanFactory = applicationContext.getBeanFactory();
		// 注册外部单例对象
		beanFactory.registerSingleton("userFactory",defaultUserFactory);
		applicationContext.refresh();

		UserFactory userFactory = applicationContext.getBean("userFactory", UserFactory.class);
		System.out.println("defaultUserFactory == userFactory "+(defaultUserFactory==userFactory));
		applicationContext.close();
	}
}
