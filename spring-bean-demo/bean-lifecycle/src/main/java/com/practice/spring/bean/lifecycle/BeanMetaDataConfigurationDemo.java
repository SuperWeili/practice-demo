package com.practice.spring.bean.lifecycle;

import com.practice.spring.bean.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * Bean 元信息配置实例
 *
 * @author LW
 * @version 1.0
 * @date 2023/8/21 21:33
 */
public class BeanMetaDataConfigurationDemo {

	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 实例化基于properties 资源 beanDefiniteReader
		PropertiesBeanDefinitionReader beanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
		String location = "META-INF/user.properties";
		int beanNums = beanDefinitionReader.loadBeanDefinitions(location);
		System.out.println("已加载的beanDefinition的数量："+beanNums);
		User user = beanFactory.getBean("user", User.class);
		System.out.println(user);

	}
}
