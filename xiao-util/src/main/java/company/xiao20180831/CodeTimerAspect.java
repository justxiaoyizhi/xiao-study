package company.xiao20180831;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class CodeTimerAspect {

    @Pointcut("@annotation(CodeTimerAnnotation)")
    public void lockAspect() {
    }

    @Around("lockAspect()")
    public Object codeTimer(ProceedingJoinPoint joinPoint) {
        Object output = null;

        Object obj = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) obj;
        Method method = methodSignature.getMethod();
        String name = method.getName();


        long startTime = System.currentTimeMillis();

        try {
            output = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("aop exec code timer meet throwable", throwable);
        }

        System.out.println("\n-------------------\nCodeTimer\n-------------------");
        System.out.printf("%s = %sms\n", name, System.currentTimeMillis() - startTime);

        return output;
    }
}
