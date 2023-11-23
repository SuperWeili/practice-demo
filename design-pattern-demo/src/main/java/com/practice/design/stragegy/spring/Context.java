package com.practice.design.stragegy.spring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author LW
 * @version 1.0
 * @date 2023/3/2 21:10
 */
@Component
public class Context {

	@Resource
	private Map<String,StrategyDemo> strategyMap;

	// 定义一个执行策略的方法，根据传入的参数从Map中获取对应的策略对象，并调用其抽象方法
	public void executeStrategy(String strategyName) {
		StrategyDemo strategy = strategyMap.get(strategyName);
		if (strategy != null) {
			strategy.execute();
		} else {
			System.out.println("没有找到对应的策略");
		}
	}


}
