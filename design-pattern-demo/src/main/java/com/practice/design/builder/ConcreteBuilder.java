package com.practice.design.builder;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/14 15:43
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 */
public class ConcreteBuilder extends Builder{

	@Override
	public void buildPartA() {
		product.setPartA("建造partA");
		System.out.println("aa");
	}

	@Override
	public void buildPartB() {
		product.setPartB("建造partB");
		System.out.println("bb");
	}

	@Override
	public void buildPartC() {
		product.setPartC("建造partC");
		System.out.println("cc");
	}
}
