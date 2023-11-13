package com.practice.netty;

import lombok.Data;

/**
 * @author LiWei
 * @date 2021/12/24 14:56
 * @version 1.0
 **/
@Data
public class Response {
    private long id;
    private Object result;

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("result", result)
                .toString();
    }
}
