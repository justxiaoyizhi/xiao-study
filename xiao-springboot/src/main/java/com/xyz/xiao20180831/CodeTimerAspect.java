package com.xyz.xiao20180831;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class CodeTimerAspect {

    @Pointcut("@annotation(com.xyz.xiao20180831.CodeTimer)")
    public void lockAspect() {
    }

    @Around("lockAspect()")
    public Object codeTimer(ProceedingJoinPoint joinPoint) {
        Object output = null;

        Object obj = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) obj;
        Method method = methodSignature.getMethod();
        CodeTimer annotation = method.getAnnotation(CodeTimer.class);
        String value = annotation.value();
        String codeTimerName = StringUtils.isEmpty(value) ? method.getName() : value;


        long startTime = System.currentTimeMillis();

        try {
            output = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("aop exec code timer meet throwable", throwable);
        }

        log.info("+--------------------------------------------+");
        log.info(String.format("|   %s耗时%sms", codeTimerName, System.currentTimeMillis() -
                startTime));
        log.info("+--------------------------------------------+");

        return output;
    }
}
