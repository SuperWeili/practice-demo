package com.practice.design.state.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 22:36
 */
@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderState, OrderEvent> {

	@Override
	public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> states) throws Exception {
		states.withStates()
				.initial(OrderState.UNPAID) // 初始状态为待支付
				.states(EnumSet.allOf(OrderState.class)); // 定义所有的状态集合
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> transitions) throws Exception {
		transitions.withExternal()
				.source(OrderState.UNPAID).target(OrderState.PAID).event(OrderEvent.PAY) // 待支付 -> 已支付，触发事件为支付
				.and()
				.withExternal()
				.source(OrderState.PAID).target(OrderState.SHIPPED).event(OrderEvent.SHIP) // 已支付 -> 已发货，触发事件为发货
				.and()
				.withExternal()
				.source(OrderState.SHIPPED).target(OrderState.RECEIVED).event(OrderEvent.CONFIRM); // 已发货 -> 已收货，触发事件为确认收货

	}
}
