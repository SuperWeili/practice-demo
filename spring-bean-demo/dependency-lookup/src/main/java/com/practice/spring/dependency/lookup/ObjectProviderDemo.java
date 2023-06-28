package com.practice.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通过{@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 * @author LW
 * @version 1.0
 * @date 2023/6/28 21:44
 */

public class ObjectProviderDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(ObjectProviderDemo.class);
		applicationContext.refresh();
		lookupByObjectProvider(applicationContext);
		applicationContext.close();
	}
	@Bean
	public String helloWorld() {
		return "helloWorld";
	}

	private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
		ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
		System.out.println( beanProvider.getObject());
	}

}
