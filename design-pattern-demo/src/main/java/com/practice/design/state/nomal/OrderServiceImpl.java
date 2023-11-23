package com.practice.design.state.nomal;

import org.springframework.stereotype.Service;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 21:26
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public void pay(String orderId) {
		// 创建一个待支付状态的订单上下文
		OrderContext orderContext = new OrderContext(orderId, new UnpaidState());
		orderContext.pay();
	}

	@Override
	public void ship(String orderId) {
		// 创建一个已支付状态的订单上下文
		OrderContext context = new OrderContext(orderId, new PaidState());
		context.ship(); // 调用发货操作
	}

	@Override
	public void confirm(String orderId) {
		// 创建一个已发货状态的订单上下文
		OrderContext context = new OrderContext(orderId, new ShippedState());
		context.confirm(); // 调用确认收货操作
	}
}
