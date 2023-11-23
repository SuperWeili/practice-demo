package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 21:20
 */
public class PaidState extends OrderState{
	@Override
	public void pay(OrderContext orderContext) {
		System.out.println("订单已经支付过了，无需重复支付");
	}

	@Override
	public void ship(OrderContext orderContext) {
		System.out.println("订单已发货");
		orderContext.setState(new ShippedState()); // 改变状态为已发货
	}

	@Override
	public void confirm(OrderContext orderContext) {
		System.out.println("订单未发货，不能确认收货");
	}
}
