package com.practice.design.stragegy.nomal;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/14 16:27
 * 策略A
 */
public class ConcreteStrategyA implements Strategy{

	@Override
	public void strategyMethod() {
		System.out.println("具体策略A的策略方法被访问！");
	}
}
