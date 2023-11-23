package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 21:22
 */
public class ShippedState extends OrderState{
	@Override
	public void pay(OrderContext orderContext) {
		System.out.println("订单已经支付过了，无需重复支付");
	}

	@Override
	public void ship(OrderContext orderContext) {
		System.out.println("订单已经发货过了，无需重复发货");
	}

	@Override
	public void confirm(OrderContext orderContext) {
		System.out.println("订单已收货");
		orderContext.setState(new ReceivedState());
	}
}
