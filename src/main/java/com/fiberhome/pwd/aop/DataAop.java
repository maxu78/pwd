package com.fiberhome.pwd.aop;

import com.fiberhome.pwd.pojo.ResponseInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * aop包装controller层返回结果
 */
@Component
@Aspect
public class DataAop {

    @Pointcut("execution(* com.fiberhome..*.controller..* (..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable{
        Object obj = pjp.proceed();
        ResponseInfo info = new ResponseInfo();
        info.setStatus("200");
        info.setData(obj);
        return info;
    }
}
