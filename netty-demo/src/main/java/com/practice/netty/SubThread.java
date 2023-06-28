package com.practice.netty;

import lombok.Data;

import java.util.concurrent.TimeUnit;

/**
 * @author LiWei
 * @date 2021/12/24 15:03
 * @version 1.0
 * 子线程模拟netty异步响应结果
 **/
@Data
public class SubThread extends Thread {
    private RequestFuture request;

    public SubThread(RequestFuture request) {
        this.request = request;
    }

    @Override
    public void run() {
        Response response = new Response();
        response.setId(request.getId());
        response.setResult("server response "+ Thread.currentThread().getId());
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        RequestFuture.received(response);
    }
}
