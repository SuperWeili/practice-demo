package com.practice.design.agent.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/8/16 14:53
 */
public class DebugInvocationHandler implements InvocationHandler {
	/**
	 * 代理类中的真实对象
	 */
	private final Object target;

	public DebugInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 调用方法之前，自己可以添加操作
		System.out.println("before method " + method.getName());

		Object invoke = method.invoke(target, args);
		// 调用方法之后，自己可以添加操作
		System.out.println("after method" + method.getName());
		return invoke;
	}
}
