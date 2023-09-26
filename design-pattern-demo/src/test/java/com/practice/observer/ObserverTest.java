package com.practice.observer;

import com.practice.design.observer.ConcreteObserverOne;
import com.practice.design.observer.ConcreteObserverTwo;
import com.practice.design.observer.ConcreteSubject;
import com.practice.design.observer.Message;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/26 21:42
 */
public class ObserverTest {
	public static void main(String[] args) {
		ConcreteSubject concreteSubject = new ConcreteSubject();
		concreteSubject.registerObserver(new ConcreteObserverOne());
		concreteSubject.registerObserver(new ConcreteObserverTwo());
		concreteSubject.notifyObserver(new Message());

	}
}
