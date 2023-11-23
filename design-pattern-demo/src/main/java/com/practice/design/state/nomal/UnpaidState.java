package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 21:19
 * 为每个具体的状态创建一个子类，实现它们的行为和转换：
 */
public class UnpaidState extends OrderState{
	@Override
	public void pay(OrderContext orderContext) {
		System.out.println("订单已支付");
		orderContext.setState(new ShippedState());
	}

	@Override
	public void ship(OrderContext orderContext) {

	}

	@Override
	public void confirm(OrderContext orderContext) {

	}
}
