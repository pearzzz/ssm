package com.pearz.jdbc.service;

import com.pearz.jdbc.dao.UserDao;
import com.pearz.jdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:13 2022/1/4
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add(User user) {
        userDao.add(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }
    
    public int finCount() {
        return userDao.selectCount();
    }

    public User findOne(int id) {
        return userDao.selectOne(id);
    }

    public List<User> findAll() {
        return userDao.selectAll();
    }

    public void batchAdd(List<Object[]> batchArgs) {
        userDao.batchAdd(batchArgs);
    }
}
