package com.ctsi.security.config;

import com.ctsi.security.consts.CookieConstant;
import com.ctsi.security.repository.CookieTokenProvider;
import com.ctsi.security.util.CookieUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户身份认证过滤器
 * @author wuzhl
 *
 */
@Component
@Slf4j
public class UsernamePasswordJwtCookieFilter extends GenericFilterBean {

    @Autowired
    private CookieTokenProvider cookieTokenProvider;
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String jwt = CookieUtil.getToken(request);//获取token
        Authentication authentication = null;
        String serverName = request.getServerName();
        try {
            if (StringUtils.hasText(jwt) && this.cookieTokenProvider.validateToken(jwt)){
              authentication = this.cookieTokenProvider.getAuthentication(jwt);
              SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ExpiredJwtException var5) {
            log.info("Expired JWT token");
            //清cookie
            removeCookie(serverName,response);
        }catch (SignatureException var3) {
            this.log.info("Invalid JWT signature.");
            //清cookie
            removeCookie(serverName,response);
        }finally {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    private void removeCookie(String serverName,HttpServletResponse response){
        Cookie token = new Cookie(CookieConstant.TOKEN, null);
        token.setPath("/");
		if (serverName.indexOf(".") > 0 
				&& (serverName.charAt(0) < '0' || serverName.charAt(0) > '9')
				) {
			serverName = serverName.substring(serverName.indexOf(".") + 1, serverName.length());
	        token.setDomain(serverName);
		}
        CookieUtil.deleteCookies(response, token);
    }
    
}
