package com.pearz.annotation.dao.Impl;

import com.pearz.annotation.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:27 2022/1/3
 */

@Repository(value = "userDaoImpl1")
public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("dao add......");
    }
}
