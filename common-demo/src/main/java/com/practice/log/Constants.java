package com.practice.log;

/**
 *
 */
public class Constants {

    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 令牌有效期（分钟）
     */
    public final static long TOKEN_EXPIRE = 60;


    /**
     * 缓存token前缀
     */
    public final static String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 令牌自定义标识
     */
    public static final String TOKEN_AUTHENTICATION = "Authorization";

    /**
     * 授权信息字段
     */
    public static final  String AUTHORIZATION_HEADER = "authorization";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 用户ID字段
     */
    public static final String DETAILS_USERID = "userid";

    /**
     * 用户名字段
     */
    public static final String DETAILS_USERNAME = "username";

    /**
     * 姓名字段
     */
    public static final String DETAILS_NICKNAME = "nickname";

    /**
     * 日志ID字段
     */
    public static final String DETAILS_LOGID = "logid";
}
