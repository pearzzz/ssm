package com.pearz.tx.dao.Impl;

import com.pearz.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:59 2022/1/5
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney(String name, int money) {
        String sql = "update t_account set money=money-? where username=?";
        jdbcTemplate.update(sql, money, name);
    }

    @Override
    public void addMoney(String name, int money) {
        String sql = "update t_account set money=money+? where username=?";
        jdbcTemplate.update(sql, money, name);
    }
}
