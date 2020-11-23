package com.ctsi.security.util;

import com.ctsi.security.domain.UserLoginDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public final class SecurityUtil {
    private SecurityUtil() {
    }

    public static Optional<String> getOptionalCurrentUserName() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map((authentication) -> {
            if (authentication.getPrincipal() instanceof UserDetails) {
                UserDetails springSecurityUser = (UserDetails)authentication.getPrincipal();
                return springSecurityUser.getUsername();
            } else {
                return authentication.getPrincipal() instanceof String ? (String)authentication.getPrincipal() : null;
            }
        });
    }

    public static String getCurrentUserName() {
        return getOptionalCurrentUserName().orElse(null);
    }

    public static Optional<Long> getOptionalCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication()).map((authentication) -> {
            if (authentication.getPrincipal() instanceof UserLoginDetail) {
            	UserLoginDetail springSecurityUser = (UserLoginDetail) authentication.getPrincipal();
                return springSecurityUser.getLoginId();
            } else {
                return null;
            }
        });
    }

    public static Long getCurrentUserId() {
        return getOptionalCurrentUserId().orElse(-1L);
    }

    public static Optional<UserLoginDetail> getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map((authentication) -> authentication.getPrincipal() instanceof UserLoginDetail ?
                        (UserLoginDetail) authentication.getPrincipal() : null);
    }

    public static Optional<Authentication> getCurrentAuthentication() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication());
    }

    public static Optional<String> getCurrentUserJWT() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .filter((authentication) -> authentication.getCredentials() instanceof String)
                .map((authentication) -> (String)authentication.getCredentials());
    }

    public static boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map((authentication) -> authentication.getAuthorities().stream()
                        .noneMatch((grantedAuthority) -> grantedAuthority.getAuthority()
                                .equals("ROLE_ANONYMOUS"))).orElse(false);
    }

    public static boolean isCurrentUserInRole(String authority) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map((authentication) -> authentication.getAuthorities().stream().anyMatch((grantedAuthority) -> {
            return grantedAuthority.getAuthority().equals(authority);
        })).orElse(false);
    }
}
