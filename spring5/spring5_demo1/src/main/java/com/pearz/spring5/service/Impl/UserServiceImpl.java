package com.pearz.spring5.service.Impl;

import com.pearz.spring5.dao.UserDao;
import com.pearz.spring5.service.UserService;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:17 2022/1/2
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void testService() {
        System.out.println("service......");
        userDao.testDao();
    }
}
