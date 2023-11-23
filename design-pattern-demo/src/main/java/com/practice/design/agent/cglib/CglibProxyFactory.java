package com.practice.design.agent.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 15:25
 */
public class CglibProxyFactory {

	public static Object getProxy(Class<?> clazz){
		// 创建动态代理增强类
		Enhancer enhancer = new Enhancer();
		// 设置类加载器
		enhancer.setClassLoader(clazz.getClassLoader());
		// 设置被代理类
		enhancer.setSuperclass(clazz);
		// 设置方法拦截器
		enhancer.setCallback(new DebugMethodInterceptor());

		return enhancer.create();

	}
}
