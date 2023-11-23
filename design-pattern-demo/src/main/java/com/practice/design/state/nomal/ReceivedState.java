package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 21:23
 */
public class ReceivedState extends OrderState{
	@Override
	public void pay(OrderContext orderContext) {
		System.out.println("订单已经完成了，无需再支付");
	}

	@Override
	public void ship(OrderContext orderContext) {
		System.out.println("订单已经完成了，无需再发货");
	}

	@Override
	public void confirm(OrderContext orderContext) {
		System.out.println("订单已经完成了，无需再确认收货");
		// 这里可以做一些评价或者退款等操作
	}
}
