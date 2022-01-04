package com.pearz.aop.aopanno;

import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 9:46 2022/1/4
 */

@Component
public class User {
    public void add() {
        System.out.println("add......");
    }
}
