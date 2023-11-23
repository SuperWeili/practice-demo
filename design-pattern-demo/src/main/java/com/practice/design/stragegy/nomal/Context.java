package com.practice.design.stragegy.nomal;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/14 16:28
 * 环境类
 */
public class Context {

	private Strategy strategy;

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void strategyMethod(){
		strategy.strategyMethod();
	}
}
