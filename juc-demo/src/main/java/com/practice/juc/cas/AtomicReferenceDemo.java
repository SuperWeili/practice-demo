package com.practice.juc.cas;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/5 17:07
 * 原子引用 解决aba问题
 */
public class AtomicReferenceDemo {
	public static void main(String[] args) {
		User user1 = new User("aa", 22);
		User user2 = new User("bb", 25);
		AtomicReference<User> atomicReference = new AtomicReference<>();
		atomicReference.set(user1);
		boolean b = atomicReference.compareAndSet(user1, user2);
		System.out.println(b + atomicReference.get().toString());
	}
}

class User {
	String usrName;
	int age;

	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(String usrName, int age) {
		this.usrName = usrName;
		this.age = age;
	}
}