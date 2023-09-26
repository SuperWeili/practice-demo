package com.practice.design.observer;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/26 21:41
 */
public class ConcreteObserverTwo implements Observer{
	@Override
	public void update(Message message) {
		System.out.println("ConcreteObserverTwo is notify");
	}
}
