package com.pearz.annotation.service;

import com.pearz.annotation.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 17:59 2022/1/3
 */
@Service
public class UserService {

    @Autowired
    @Qualifier(value = "userDaoImpl1")
    private UserDao userDao;

    @Value(value = "pearz")
    private String nane;

    public void add() {
        System.out.println("service add......" + nane);
        userDao.add();
    }
}
