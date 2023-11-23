package com.practice.design.state.spring;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 22:36
 */
public enum OrderState {
	// 待支付
	UNPAID,
	// 已支付
	PAID,
	// 已发货
	SHIPPED,
	// 已收货
	RECEIVED;
}
