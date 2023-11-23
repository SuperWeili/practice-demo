package com.practice.design.spi;

import java.util.List;

/**
 * @author LiWei
 * @version 1.0
 * @date 2022/6/6 14:18
 */
public interface Search {
	List<String> searchDoc(String keyword);
}
