package com.practice.design.stragegy.nomal;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/14 16:31
 * 策略模式是准备一组算法，并将这组算法封装到一系列的策略类里面，作为一个抽象策略类的子类。策略模式的重心不是如何实现算法，
 * 而是如何组织这些算法，从而让程序结构更加灵活，具有更好的维护性和扩展性，现在我们来分析其基本结构和实现方法。
 */
public class StrategyPattern {
	public static void main(String[] args) {
		Context c = new Context();
		Strategy s = new ConcreteStrategyA();
		c.setStrategy(s);
		c.strategyMethod();
		System.out.println("===============");

		Strategy s1 = new ConcreteStrategyB();
		c.setStrategy(s1);
		c.strategyMethod();
	}
}
