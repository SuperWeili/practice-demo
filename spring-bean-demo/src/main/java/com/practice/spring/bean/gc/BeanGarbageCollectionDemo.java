package com.practice.spring.bean.gc;

import com.practice.spring.bean.factory.BeanInitializationDemo;
import com.practice.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author LW
 * @version 1.0
 * @date 2023/6/28 20:46
 */
public class BeanGarbageCollectionDemo {

	public static void main(String[] args) throws InterruptedException {
		// 创建BeanFactory容器
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		// 注册configuration class （配置类）
		applicationContext.register(BeanInitializationDemo.class);
		// 启动Spring应用上下文
		applicationContext.refresh();
		// 关闭Spring上下文
		applicationContext.close();
		Thread.sleep(5000L);
		System.gc();
		Thread.sleep(5000L);
	}
}
