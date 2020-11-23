package com.ctsi.security.util;

import com.ctsi.security.consts.CookieConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * 操作cookie工具类
 *
 *
 */
public class CookieUtil {

    private CookieUtil(){}
    /**
     * 获取所有cookie
     *
     * @return
     */
    public static Cookie[] readCookies(HttpServletRequest request) {
        return request.getCookies();
    }

    /**
     * 设置一个或多个cookie
     *
     * @param cookies
     */
    public static void writeCookies(HttpServletResponse response, Cookie... cookies) {
        for (Cookie cookie : cookies) {
            response.addCookie(cookie);
        }
    }

    /**
     * 针对一个域名设置一个或多个cookie
     *
     * @param domain
     *            设置域名
     * @param cookies
     */
    public static void writeCookies(String domain, HttpServletResponse response, Cookie... cookies) {
        for (Cookie cookie : cookies) {
            cookie.setDomain(domain);
        }
        writeCookies(response, cookies);
    }

    /**
     * 针对一个域名、生命周期设置一个或多个cookie
     *
     * @param domain
     *            设置域名
     * @param expiry
     *            生命周期
     * @param cookies
     */
    public static void writeCookies(String domain, int expiry, HttpServletResponse response, Cookie... cookies) {
        for (Cookie cookie : cookies) {
            cookie.setDomain(domain);
            cookie.setMaxAge(expiry);
        }
        writeCookies(response, cookies);
    }

    /**
     * 删除一个或多个cookie
     *
     * @param cookies
     */
    public static void deleteCookies(HttpServletResponse response, Cookie... cookies) {
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
        }
        writeCookies(response, cookies);
    }

    /**
     * 设置关闭浏览器时清除一个或多个cookie
     *
     * @param cookies
     */
    public static void setSessionCookies(HttpServletResponse response, Cookie... cookies) {
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(-1);
        }
        writeCookies(response, cookies);
    }

    /**
     * 设置HTTPOnly属性的cookie
     *
     * @param cookie
     */
    public static void writeHttpOnlyCookie(HttpServletResponse response, Cookie cookie) {
        StringBuilder builder = new StringBuilder();
        builder.append(cookie.getName() + "=" + cookie.getValue() + ";");
        if (cookie.getMaxAge() >= 0) {
            builder.append("Max-Age=" + cookie.getMaxAge() + ";");
        }
        builder.append("Domain=" + cookie.getDomain() + ";");
        builder.append("Path=" + cookie.getPath() + ";");
        builder.append("Version=" + cookie.getVersion() + ";");
        if (cookie.getSecure()) {
            builder.append("Secure;");
        }
        builder.append("HTTPOnly;");
        response.addHeader("Set-Cookie", builder.toString());
    }

    public static void setToken(HttpServletResponse response, String jwt) {
        Cookie cookie = new Cookie(CookieConstant.TOKEN, jwt);
        cookie.setMaxAge(CookieConstant.TOKEN_TIME_OUT_SECONDS);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        CookieUtil.writeCookies(response, cookie);
    }

    public static String getToken(HttpServletRequest request) {
        // 校验token
        Cookie[] cookies = readCookies(request);
        String jwt = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CookieConstant.TOKEN)) {
                    // cookie.setMaxAge(0);
                    // CookieUtil.writeCookies(resp, cookies);
                    jwt = cookie.getValue();
                }
            }
        }
        return jwt;
    }

    public static void writeCookie(HttpServletResponse response, String key,String value,boolean httpOnly) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(10*365*24*60*60);
        cookie.setPath("/");
        cookie.setHttpOnly(httpOnly);
        writeCookies(response, cookie);
    }

    public static String getCookie(HttpServletRequest request,String key) {
        // 校验token
        Cookie[] cookies = readCookies(request);
        String username = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    // cookie.setMaxAge(0);
                    // CookieUtil.writeCookies(resp, cookies);
                    username = cookie.getValue();
                }
            }
        }
        return username;
    }


}

