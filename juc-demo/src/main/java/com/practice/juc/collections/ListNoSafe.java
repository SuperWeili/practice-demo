package com.practice.juc.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author LW
 * @version 1.0
 * @date 2021/12/5 17:47
 */
public class ListNoSafe {

    public static void main(String[] args) {

        // 高并发下报错 ConcurrentModificationException
        ArrayList<String> objects = new ArrayList<>();
        // 1。0. 解决
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<Object> objects1 = Collections.synchronizedSet(new HashSet<>());
        CopyOnWriteArraySet copy= new CopyOnWriteArraySet();

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for(int i = 1; i <= 30; i++){
            new Thread(() ->{
                copyOnWriteArrayList.add(UUID.randomUUID().toString());
                System.out.println(copyOnWriteArrayList);
            },String.valueOf(i)).start();
        }

    }

}
