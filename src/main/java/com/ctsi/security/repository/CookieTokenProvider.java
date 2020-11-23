package com.ctsi.security.repository;

import com.ctsi.security.domain.UserLoginDetail;
import com.ctsi.ssdc.config.CtsiProperties;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CookieTokenProvider {
    private final Base64.Encoder encoder = Base64.getEncoder();
    private String secretKey;
    private long tokenValidityInMilliseconds;
    private long tokenValidityInMillisecondsForRememberMe;
    private final CtsiProperties ctsiProperties;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public CookieTokenProvider(CtsiProperties ctsiProperties) {
        this.ctsiProperties = ctsiProperties;
    }

    @PostConstruct
    public void init() {
        this.secretKey = this.encoder.encodeToString(this.ctsiProperties.getSecurity().getAuthentication().getJwt().getSecret().getBytes(StandardCharsets.UTF_8));
        this.tokenValidityInMilliseconds = 1000L * this.ctsiProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSeconds();
        this.tokenValidityInMillisecondsForRememberMe = 1000L * this.ctsiProperties.getSecurity().getAuthentication().getJwt().getTokenValidityInSecondsForRememberMe();
    }

    public String createToken(Authentication authentication, boolean rememberMe) {
        String authorities = (String)authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        long now = (new Date()).getTime();
        Date validity;
        if (rememberMe) {
            validity = new Date(now + this.tokenValidityInMillisecondsForRememberMe);
        } else {
            validity = new Date(now + this.tokenValidityInMilliseconds);
        }

        JwtBuilder builder = Jwts.builder().setSubject(authentication.getName()).claim("auth", authorities).claim("rem", rememberMe ? 1 : 0);
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserLoginDetail) {
            builder.claim("loginId", ((UserLoginDetail)principal).getLoginId());
            builder.claim("loginName",((UserLoginDetail)principal).getLoginName());
            builder.claim("username",((UserLoginDetail)principal).getUsername());
            builder.claim("isValid",((UserLoginDetail)principal).getIsValid());
            builder.claim("orgId",((UserLoginDetail)principal).getOrgId());
            builder.claim("orgParentId",((UserLoginDetail)principal).getOrgParentId());
            builder.claim("orgFullName",((UserLoginDetail)principal).getOrgFullName());
            builder.claim("password",((UserLoginDetail)principal).getPassword());
            builder.claim("telephone",((UserLoginDetail)principal).getTelephone());
            builder.claim("createTime",((UserLoginDetail)principal).getCreateTime());
        }

        return builder.signWith(SignatureAlgorithm.HS512, this.secretKey).setExpiration(validity).compact();
    }

    public Authentication getAuthentication(String token) {
    	System.out.println("**************"+token);
        Claims claims = (Claims) Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
        String authClaim = claims.get("auth").toString();
        Collection<? extends GrantedAuthority> authorities = (Collection) Arrays.stream(authClaim.split(",")).filter(StringUtils::isNotEmpty).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        UserLoginDetail principal = new UserLoginDetail();
        Optional.ofNullable(claims.get("createTime"))
                .ifPresent(createTime->principal.setCreateTime((String) createTime));
        Optional.ofNullable(claims.get("isValid"))
                .ifPresent(isValid->principal.setIsValid((Integer) isValid));
        if(null != claims.get("loginId")){
        	principal.setLoginId(Long.valueOf(claims.get("loginId").toString()));
        }
        Optional.ofNullable(claims.get("loginName"))
                .ifPresent(loginName->principal.setLoginName((String) loginName));
        Optional.ofNullable(claims.get("password"))
                .ifPresent(password->principal.setPassword((String) password));
        Optional.ofNullable(claims.get("telephone"))
                .ifPresent(telephone->principal.setTelephone((String)telephone));
        Optional.ofNullable(claims.get("username"))
                .ifPresent(username->principal.setUserName((String) username));
        if(null != claims.get("orgId")){
        	principal.setOrgId(Long.valueOf(claims.get("orgId").toString()));
        }
        if(null != claims.get("orgParentId")){
        	principal.setOrgParentId(Long.valueOf(claims.get("orgParentId").toString()));
        }
        Optional.ofNullable(claims.get("orgFullName"))
                .ifPresent(orgFullName->principal.setOrgFullName((String) orgFullName));
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(authToken);
            return true;
        }  catch (MalformedJwtException var4) {
            this.log.info("Invalid JWT token.");
            this.log.debug("Invalid JWT token trace: {}", var4);
        } catch (UnsupportedJwtException var6) {
            this.log.info("Unsupported JWT token.");
            this.log.debug("Unsupported JWT token trace: {}", var6);
        } catch (IllegalArgumentException var7) {
            this.log.info("JWT token compact of handler are invalid.");
            this.log.debug("JWT token compact of handler are invalid trace: {}", var7);
        }

        return false;
    }
}
