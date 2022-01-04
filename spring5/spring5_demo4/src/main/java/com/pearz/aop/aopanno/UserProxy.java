package com.pearz.aop.aopanno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 9:47 2022/1/4
 */

@Component
@Aspect
public class UserProxy {

    @Pointcut(value = "execution(* com.pearz.aop.aopanno.User.add(..))")
    public void pointdemo() {
    }

    @Before(value = "pointdemo()")
    public void before() {
        System.out.println("before");
    }

    @AfterReturning(value = "execution(* com.pearz.aop.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @After(value = "execution(* com.pearz.aop.aopanno.User.add(..))")
    public void after() {
        System.out.println("after");
    }

    @AfterThrowing(value = "execution(* com.pearz.aop.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around(value = "execution(* com.pearz.aop.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around before");
        proceedingJoinPoint.proceed();
        System.out.println("around after");
    }
}
