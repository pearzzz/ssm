package com.pearz.spring5.test;

import com.pearz.spring5.pojo.Book;
import com.pearz.spring5.pojo.Order;
import com.pearz.spring5.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author pearz
 */
public class Test1Spring5 {

    @Test
    public void testAdd() {
        //1、加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        //2、获取配置创建的对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1OfBook.xml");
        Book book = context.getBean("book", Book.class);
        book.test();
    }

    @Test
    public void testOrder() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1OfOrder.xml");
        Order order = context.getBean("order", Order.class);
        order.test();
    }
}