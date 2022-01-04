package com.pearz.aop.test;

import com.pearz.aop.aopanno.User;
import com.pearz.aop.aopxml.Book;
import com.pearz.aop.config.ConfigAop;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:04 2022/1/4
 */
public class AopTest {

    @Test
    public void test1() {
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigAop.class);
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.add();
    }
}
