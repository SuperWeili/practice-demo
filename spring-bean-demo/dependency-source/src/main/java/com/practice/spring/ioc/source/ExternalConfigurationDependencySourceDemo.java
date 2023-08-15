package com.practice.spring.ioc.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @author LW
 * @version 1.0
 * @date 2023/8/15 22:19
 */
@Configuration
@PropertySource(value = "META-INF/default.properties",encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {
	@Value("${user.id:-1}")
	private Long id;

	@Value("${user.name:lw}")
	private String name;

	@Value("${user.resource:classpath://default.properties}")
	private Resource resource;


	public static void main(String[] args) {
		// 创建bean容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ExternalConfigurationDependencySourceDemo.class);
		applicationContext.refresh();
		ExternalConfigurationDependencySourceDemo bean = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);
		System.out.println(bean.id);
		System.out.println(bean.resource);
		System.out.println(bean.name);
		applicationContext.close();
	}
}