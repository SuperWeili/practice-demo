package com.practice.design.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/6 14:29
 */
public class SearchMain {
	public static void main(String[] args) {
		ServiceLoader<Search> load = ServiceLoader.load(Search.class);
		Iterator<Search> iterator = load.iterator();
		while (iterator.hasNext()){
			Search next = iterator.next();
			next.searchDoc("Hello");
		}
	}
}
