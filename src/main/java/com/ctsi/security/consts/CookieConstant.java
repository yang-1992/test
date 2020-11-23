package com.ctsi.security.consts;

/**
 * cookie相关静态变量
 * @author fuxiang
 */
public class CookieConstant {
    private CookieConstant(){};

    public static final String USER_ID="userId";

    /**
     * 用户token
     */
    public static final String TOKEN="Authentication";

    /**
     * token失效时间
     */
    public static final Integer TOKEN_TIME_OUT_SECONDS=10*365*24*60*60;//10*365*24*60*60;
}
