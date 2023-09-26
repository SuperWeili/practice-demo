package com.practice.design.observer;

/**
 * @author LW
 * @version 1.0
 * @date 2023/9/26 21:34
 */
public interface Subject {
	void registerObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObserver(Message message);

}
