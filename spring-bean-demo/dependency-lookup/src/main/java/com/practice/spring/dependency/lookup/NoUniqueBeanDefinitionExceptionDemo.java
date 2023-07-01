package com.practice.spring.dependency.lookup;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author LW
 * @version 1.0
 * @date 2023/7/1 18:18
 */
public class NoUniqueBeanDefinitionExceptionDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

		applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
		applicationContext.refresh();

		// 存在两个bean 通过单一查找会抛出异常
		Object bean1 = applicationContext.getBean(String.class);
		applicationContext.close();

	}

	@Bean
	public String bean1(){
		return "bean1";
	}

	@Bean
	public String bean2(){
		return "bean2";
	}
}
