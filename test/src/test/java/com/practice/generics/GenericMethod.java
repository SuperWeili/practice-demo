package com.practice.generics;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/23 22:07
 */
public class GenericMethod {
	public static void main(String[] args) {
		GenericMethod genericMethod = new GenericMethod();
		Generic<Integer> generic1 = new Generic<>(123);
		Generic<String> generic2 = new Generic<>("123");
		genericMethod.genericMethod(generic1);
		genericMethod.genericMethod2(generic2,"hello world");

	}

	/**
	 * 说明：
	 * 1、public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
	 * 2、只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
	 * 3、<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
	 * 4、<T> 后面的这个T，代表这个方法的返回值类型
	 * 4、与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
	 */
	public <T> T genericMethod(T a) {
		System.out.println("我是genericMethod：" + a);
		return a;
	}

	public <T> T genericMethod1(Generic<T> generic) {
		System.out.println("我是genericMethod2：" + generic.getKey());
		T key = generic.getKey();
		return key;
	}

	public <T,V> T genericMethod2(Generic<T> generic,V value) {
		System.out.println("我是genericMethod2：" + generic.getKey() + "==> value：" + value);
		T key = generic.getKey();
		return key;
	}

	//这也不是一个泛型方法，这就是一个普通的方法，只是使用了Generic<Number>这个泛型类做形参而已。
	public void method1(Generic<? extends Number> generic){
		System.out.println(generic.getKey());
	}

	//这也不是一个泛型方法，这也是一个普通的方法，只不过使用了泛型通配符?
	//同时这也印证了泛型通配符章节所描述的，?是一种类型实参
	public void method2(Generic<?> generic) {
		System.out.println(generic.getKey());

	}

}

class Generic<T> {
	private T key;

	public Generic(T key) {
		this.key = key;
	}

	/**
	 * 1、这个虽然在方法中使用了泛型，但这并不是一个泛型方法。这只是类中一个普通的
	 * 成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。所以在这个方法中才
	 * 可以继续使用 T 这个泛型。
	 */
	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}
}
abstract class GenericFruit {
}

