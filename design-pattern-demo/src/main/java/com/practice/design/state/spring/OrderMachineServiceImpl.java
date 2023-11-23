package com.practice.design.state.spring;

import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 22:38
 */
@Service
public class OrderMachineServiceImpl implements OrderMachineService {

	@Resource
	private StateMachine<OrderState, OrderEvent> stateMachine;

	@Override
	public void pay(String orderId) {
		stateMachine.start(); // 启动状态机
		stateMachine.sendEvent(OrderEvent.PAY); // 发送支付事件
		System.out.println("订单" + orderId + "已支付");
		stateMachine.stop(); // 停止状态机
	}

	@Override
	public void ship(String orderId) {
		stateMachine.start();
		stateMachine.sendEvent(OrderEvent.SHIP);
		System.out.println("订单" + orderId + "已发货");
		stateMachine.stop();
	}

	@Override
	public void confirm(String orderId) {
		stateMachine.start();
		stateMachine.sendEvent(OrderEvent.CONFIRM);
		System.out.println("订单" + orderId + "已收货");
		stateMachine.stop();
	}
}
