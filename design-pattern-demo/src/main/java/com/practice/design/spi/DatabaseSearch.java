package com.practice.design.spi;

import java.util.List;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/6 14:21
 */
public class DatabaseSearch implements Search{
	@Override
	public List<String> searchDoc(String keyword) {
		System.out.println("数据搜索 "+keyword);
		return null;
	}
}
