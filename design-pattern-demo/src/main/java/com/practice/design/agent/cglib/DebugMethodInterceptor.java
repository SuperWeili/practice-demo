package com.practice.design.agent.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 15:21
 */
public class DebugMethodInterceptor implements MethodInterceptor {

	/**
	 * @param o           代理对象（增强的对象）
	 * @param method      被拦截的方法（需要增强的方法）
	 * @param objects        方法入参
	 * @param methodProxy 用于调用原始方法
	 */
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		// 调用方法之前，我们可以添加自己的操作
		System.out.println("before method "+ method.getName());
		Object invokeSuper = methodProxy.invokeSuper(o, objects);

		// 调用方法之后，我们可以添加自己的操作
		System.out.println("after method "+ method.getName());
		return invokeSuper;
	}
}
