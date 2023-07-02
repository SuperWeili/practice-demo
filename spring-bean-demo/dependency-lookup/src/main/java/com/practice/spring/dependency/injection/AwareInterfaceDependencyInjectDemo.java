package com.practice.spring.dependency.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link  org.springframework.beans.factory.Aware} 接口回调的方式注入bean
 *
 * @author LW
 * @version 1.0
 * @date 2023/7/2 20:20
 */
public class AwareInterfaceDependencyInjectDemo implements BeanFactoryAware, ApplicationContextAware {

	private static BeanFactory beanFactory;

	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		// 创建beanFactory的容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注册配置类
		context.register(AwareInterfaceDependencyInjectDemo.class);

		context.refresh();
		System.out.println(beanFactory == context.getBeanFactory());
		System.out.println(applicationContext == context);
		context.close();
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		AwareInterfaceDependencyInjectDemo.beanFactory = beanFactory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		AwareInterfaceDependencyInjectDemo.applicationContext = applicationContext;
	}
}
