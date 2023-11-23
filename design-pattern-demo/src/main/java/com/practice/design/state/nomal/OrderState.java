package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 20:14
 * 订单系统作为示例，首先，我们需要定义一个抽象的状态类：
 */
public abstract class OrderState {

	// 支付
	public abstract void pay(OrderContext orderContext);

	// 发货
	public abstract void ship(OrderContext orderContext);

	// 确认收获
	public abstract void confirm(OrderContext orderContext);


}
