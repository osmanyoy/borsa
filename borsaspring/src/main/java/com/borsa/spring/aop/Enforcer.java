package com.borsa.spring.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Enforcer {

    @Pointcut("execution(* com.borsa.spring.aop.Callee.*(..)) && args(str)")
    public void mmmm(final String str) {

    }

    @After("mmmm(str)")
    public void afterMethod(final JoinPoint joinPointParam,
                            final String str) {
        System.out.println("After " + joinPointParam.toLongString());
    }

    @Before("mmmm(str)")
    public void beforeMethod(final JoinPoint joinPointParam,
                             final String str) {
        System.out.println("Before " + joinPointParam.toLongString());
    }

    @AfterReturning(value = "mmmm(str)", returning = "response")
    public void afterReturningMethod(final JoinPoint joinPointParam,
                                     final String str,
                                     final String response) {
        System.out.println("After Returning " + joinPointParam.toLongString());
    }

    @AfterThrowing(value = "mmmm(str)", throwing = "exp")
    public void afterThrowingMethod(final JoinPoint joinPointParam,
                                    final String str,
                                    final Exception exp) {
        System.out.println("After Returning " + joinPointParam.toLongString());
    }

    @Around("mmmm(str)")
    public Object afterThrowingMethod(final ProceedingJoinPoint joinPointParam,
                                      final String str) {
        try {
            Object[] argsLoc = joinPointParam.getArgs();
            String strInput = (String) argsLoc[0] + " *input değiştirildi*";
            Object[] test = new Object[1];
            test[0] = strInput;
            Object proceedLoc = joinPointParam.proceed(test);
            //            Object proceedLoc = joinPointParam.proceed();
            if (proceedLoc instanceof String) {
                String stringLoc = (String) proceedLoc + " *output değişti*";
                return stringLoc;
            }
            return proceedLoc;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    Logger log = LoggerFactory.getLogger("aspect");

    @Around("within(com.borsa.spring.MyRest) && @annotation(annoTestParam)")
    public Object afterThrowingMethod(final ProceedingJoinPoint joinPointParam,
                                      final MyAnnoTest annoTestParam) {
        try {
            this.log.info("annotation : " + annoTestParam.testStr());
            Object proceedLoc = joinPointParam.proceed();
            return proceedLoc;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

}