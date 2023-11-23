package com.practice.design.state.spring;

/**
 * @author LW
 * @version 1.0
 * @date 2023/3/1 20:36
 */
public interface OrderMachineService {

	void pay(String orderId);

	void ship(String orderId);

	void confirm(String orderId);
}
