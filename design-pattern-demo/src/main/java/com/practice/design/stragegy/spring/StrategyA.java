package com.practice.design.stragegy.spring;

import org.springframework.stereotype.Service;

/**
 * @author LW
 * @version 1.0
 * @date 2023/3/2 21:08
 */
@Service("strategyA")
public class StrategyA implements StrategyDemo{
	@Override
	public void execute() {
		System.out.println("执行策略A");
	}
}
