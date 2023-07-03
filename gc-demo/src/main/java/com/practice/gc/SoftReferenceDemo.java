package com.practice.gc;

import java.lang.ref.SoftReference;

/**
 * @author LW
 * @version 1.0
 * @date 2022/1/6 20:49
 * 内存不够用就回收
 */
public class SoftReferenceDemo {
	public static void main(String[] args) {
//		enough();
		notEnough();
	}
	public static void enough(){
		Object o = new Object();
		SoftReference<Object> reference = new SoftReference<Object>(o);
		System.out.println(o);
		System.out.println(reference.get());
		o=null;
		System.gc();
		System.out.println(o);
		System.out.println(reference.get());

	}

	public static void notEnough(){
		Object o = new Object();
		SoftReference<Object> reference =  new SoftReference<Object>(o);
		System.out.println(o);
		System.out.println(reference.get());
		o=null;
//		System.gc();
		try {
			byte[] bytes = new byte[1024*1021*1024];
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			System.out.println(o);
			System.out.println(reference.get());
		}
	}
}
