package com.practice.design.stragegy.nomal;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/14 16:28
 */
public class ConcreteStrategyB implements Strategy{
	@Override
	public void strategyMethod() {
		System.out.println("具体策略B的策略方法被访问！");
	}
}
