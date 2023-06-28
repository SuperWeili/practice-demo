package com.practice.netty;

import lombok.Data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LiWei
 * @date 2021/12/24 14:39
 * @version 1.0
 **/
@Data
public class RequestFuture {
    /**
     * 请求缓存类，key为每次的请求，requestFutureMap 为value
     */
    public static Map<Long, RequestFuture> requestFutureMap = new ConcurrentHashMap<>();

    private long id;

    // 参数
    private Object request;

    // 响应结果
    private Object result;

    private long timeOut = 5000;


    public static void addFuture(RequestFuture future) {
        requestFutureMap.put(future.getId(), future);
    }

    public Object get() {
//        Lock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//        lock.lock();
        synchronized (this){
            while (this.result == null) {
                try {
                    this.wait(timeOut);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return this.result;
    }

    public static void received(Response res) {
//        Lock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
        RequestFuture future = requestFutureMap.remove(res.getId());
        if (future != null) {
            future.setResult(res.getResult());
        }
//        lock.lock();
        synchronized (future){
            try {
                future.notify();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
