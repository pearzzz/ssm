package com.pearz.aop.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:15 2022/1/4
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {

    @Before(value = "execution(* com.pearz.aop.aopanno.User.add(..))")
    public void before() {
        System.out.println("person before");
    }
}
