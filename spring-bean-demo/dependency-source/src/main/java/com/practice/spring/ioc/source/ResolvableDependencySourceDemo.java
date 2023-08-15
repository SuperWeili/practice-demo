package com.practice.spring.ioc.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author LW
 * @version 1.0
 * @date 2023/8/14 22:37
 */
public class ResolvableDependencySourceDemo {
	@Autowired
	private String value;

	@PostConstruct
	public void init() {
		System.out.println(value);
	}

	public static void main(String[] args) {
		// 创建bean容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ResolvableDependencySourceDemo.class);
		applicationContext.addBeanFactoryPostProcessor(configurableBeanFactory -> {
			configurableBeanFactory.registerResolvableDependency(String.class, "hello World!");
		});
		applicationContext.refresh();

//		if (beanFactory instanceof ConfigurableBeanFactory) {
//			ConfigurableListableBeanFactory configurableBeanFactory = ConfigurableListableBeanFactory.class.cast(beanFactory);
//			// 注册Resolvable Dependency
//			configurableBeanFactory.registerResolvableDependency(String.class, "hello World!");
//		}
		applicationContext.close();
	}
}
