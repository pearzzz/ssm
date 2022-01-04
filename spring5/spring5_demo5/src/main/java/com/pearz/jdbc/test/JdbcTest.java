package com.pearz.jdbc.test;

import com.pearz.jdbc.pojo.User;
import com.pearz.jdbc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:19 2022/1/4
 */
public class JdbcTest {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setUserId(1);
        user.setUsername("pearz");
        user.setUstatus("tiger");

        userService.add(user);
    }

    @Test
    public void tsetDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.delete(1);
    }

    @Test
    public void testUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);

        User user = new User();
        user.setUserId(2);
        user.setUsername("pearz");
        user.setUstatus("tiger");

        userService.update(user);
    }

    @Test
    public void testFindCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.finCount());
    }

    @Test
    public void testFindOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.findOne(2));
    }

    @Test
    public void testFindAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User> users = userService.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testBatchAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);

        List<Object[]> args = new LinkedList<>();
        Object[] arg1 = {3, "tx", "tiger"};
        Object[] arg2 = {4, "ll", "tiger"};
        Object[] arg3 = {5, "hh", "ox"};
        args.add(arg1);
        args.add(arg2);
        args.add(arg3);

        userService.batchAdd(args);
    }
}
