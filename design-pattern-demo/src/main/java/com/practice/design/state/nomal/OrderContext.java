package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 20:15
 * <p>
 * 定义一个上下文类，来维护当前的状态对象，并且提供一些方法来触发事件和改变状态：
 */
public class OrderContext {

	//当前的状态对象
	private OrderState state;

	// 订单编号
	private String orderId;

	public OrderContext(String orderId, OrderState state) {
		this.state = state;
		this.orderId = orderId;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	// 支付操作（委托给当前的状态对象）
	public void pay() {
		state.pay(this);
	}

	// 发货操作（委托给当前的状态对象）
	public void ship() {
		state.ship(this);
	}

	public void confirm() {
		state.confirm(this);
	}
}
