package com.practice.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/23 22:40
 */
public class Test_Wildcard_Character {
	public static void main(String[] args) {
		List<Dog> dogs = new ArrayList<>();
		test(dogs);
		// 报错
//		test1(dogs);
		ArrayList<?> objects = new ArrayList();
		objects.add(null);
	}

	static void test(List<? extends Animal> list){
		for (Animal animal : list) {
			System.out.println(animal);
		}
	}

	static void test1(List<Animal> list){
		for (Animal animal : list) {
			System.out.println(animal);
		}
	}
}
class Animal {
	@Override
	public String toString() {
		return "Animal";
	}
}
class Dog extends Animal {
	@Override
	public String toString() {
		return "dog";
	}
}
