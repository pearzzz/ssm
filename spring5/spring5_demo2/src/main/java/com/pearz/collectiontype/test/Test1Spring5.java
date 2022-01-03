package com.pearz.collectiontype.test;

import com.pearz.collectiontype.pojo.Book;
import com.pearz.collectiontype.pojo.Course;
import com.pearz.collectiontype.pojo.Order;
import com.pearz.collectiontype.pojo.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 20:59 2022/1/2
 */
public class Test1Spring5 {

    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println(order);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
