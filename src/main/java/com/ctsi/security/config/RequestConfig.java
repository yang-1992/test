package com.ctsi.security.config;

import com.ctsi.space.utils.ApiResultUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author sjw
 * @version 1.0.0
 * @description 记录请求的入参和出参
 * @date 9:42
 * @copyright 中国电信集团系统集成有限责任公司
 */
@Configuration
@Aspect
public class RequestConfig {
    private final Logger logger = LoggerFactory.getLogger(RequestConfig.class);

    //空间资源的简称
    @Value(value = "ctsi.systemname")
    private String systemName;

    @Around("execution(* com.ctsi.*.web.*.*(..))")
    public Object dealRequest(ProceedingJoinPoint joinPoint) {
        Object result;
        //取到执行的方法
        String methName = joinPoint.getSignature().getName();
        //获取方法的参数
        Object[] arr = joinPoint.getArgs();
        List<Object> list = Arrays.asList(arr);
        //生成全全局流水号,以模块的简称开始拼接
        String traceCode = systemName + UUID.randomUUID().toString().replace("-", "");
        logger.info("[" + traceCode + ": methodName: " + methName + "]: 入参为:" + list.toString());
        try {
            result = joinPoint.proceed();
            logger.info(traceCode + ": methodName:" + methName + ": 返回结果为:" + result);
        } catch (Throwable throwable) {
            logger.error(traceCode + ":" + methName + ":返回出现异常");
            throwable.printStackTrace();
            result = ApiResultUtil.createErrorApiResult("服务器错误", 500, null);
        }
        return result;
    }
}
