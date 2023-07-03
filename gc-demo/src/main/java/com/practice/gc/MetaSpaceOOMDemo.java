package com.practice.gc;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


/**
 * @author LW
 * @version 1.0
 * @date 2022/1/13 20:51
 * jvm参数
 *  -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 *  *  java 8 及之后的版本使用metaSpace来替代永久代
 *  metaspace是方法区在hotSpot中的实现
 */
public class MetaSpaceOOMDemo {
	static class OOMDemo{

	}
	public static void main(String[] args) {
		int i =0;
		try {
			while (true){
				i++;
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(OOMDemo.class);
				enhancer.setUseCache(false);
				enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> method.invoke(o,args));
				enhancer.create();
			}
		}catch (Throwable throwable){
			System.out.println("======多少次后发生了异常："+i);
			throwable.printStackTrace();
		}
	}
}
