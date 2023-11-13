package com.practice.job;

/**
 * @author LW
 * @version 1.0
 * @date 2023/11/13 21:04
 */
public interface WithType<T extends Enum<T>> {
	T getType();
}
