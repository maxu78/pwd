package com.fiberhome.pwd.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * controller层日志输出aop
 */
@Component
@Aspect
public class LogAop {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${log.enabled: true}")
    private boolean isEnabled;

    @Pointcut("execution(public * com.fiberhome..*.controller..* (..))")
    public void log(){}

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        if(isEnabled) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            log.info("请求的URL: {}", request.getRequestURL());
            log.info("请求的IP: {}", request.getRemoteAddr());
            log.info("请求的参数: {}", Arrays.toString(joinPoint.getArgs()));
            log.info("请求的类名: {}", joinPoint.getSignature().getDeclaringTypeName());
            log.info("请求的方法名: {}", joinPoint.getSignature().getName());
            long sTime = System.currentTimeMillis();
            request.setAttribute("REQUEST_TIME", sTime);
        }
    }

    @AfterReturning("log()")
    public void after(JoinPoint joinPoint) {
        if(isEnabled) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            if (request.getAttribute("REQUEST_TIME") != null) {
                long sTime = (long) request.getAttribute("REQUEST_TIME");
                long eTime = System.currentTimeMillis();
                log.info("执行时间: {}ms", eTime - sTime);
            }
        }
    }
}
