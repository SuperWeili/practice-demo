package com.practice.design.builder;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/14 15:48
 * 客户类
 */
public class Client {
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		Product construct = director.construct();
		construct.show();
	}
}
