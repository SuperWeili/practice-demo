package com.practice.design.state.nomal;

/**
 * @author LW
 * @version 1.0
 * @date 2023/2/28 21:25
 */
public interface OrderService {

	void pay(String orderId);

	void ship(String orderId);

	void confirm(String orderId);
}
