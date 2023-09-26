package com.practice.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/26 21:37
 */
public class ConcreteSubject implements Subject{

	private List<Observer> observers = new ArrayList<>();
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObserver(Message message) {
		observers.forEach(observer -> observer.update(message));
	}
}
