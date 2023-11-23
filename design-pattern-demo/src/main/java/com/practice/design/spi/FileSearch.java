package com.practice.design.spi;

import java.util.List;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/6 14:19
 */
public class FileSearch implements Search{
	@Override
	public List<String> searchDoc(String keyword) {
		System.out.println("文件搜索："+keyword);
		return null;
	}
}
