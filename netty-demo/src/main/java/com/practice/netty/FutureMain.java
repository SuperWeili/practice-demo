package com.practice.netty;

import java.util.ArrayList;

/**
 * @author LiWei
 * @date 2021/12/24 14:36
 * @version 1.0
 * 主线程类，主线程模拟发送请求，开启额外线程获取响应结果
 * 并异步的将结果响应给主线程
 **/
public class FutureMain {
    public static void main(String[] args) {
        ArrayList<RequestFuture> reqs = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            long id = i;
            RequestFuture req = new RequestFuture();
            req.setId(id);
            // 设置请求内容
            req.setRequest("hello world");
            RequestFuture.addFuture(req);
            reqs.add(req);
            sendMsg(req);
            SubThread subThread = new SubThread(req);
            subThread.start();
        }
        for (RequestFuture req : reqs) {
            Object o = req.get();
            System.out.println(o.toString());
        }
    }
    public static void sendMsg(RequestFuture req){
        System.out.println("客户端发送数据，请求id为===="+req.getId());
    }
}
