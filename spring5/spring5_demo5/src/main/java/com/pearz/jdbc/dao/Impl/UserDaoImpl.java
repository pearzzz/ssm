package com.pearz.jdbc.dao.Impl;

import com.pearz.jdbc.dao.UserDao;
import com.pearz.jdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:13 2022/1/4
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into t_user value(?,?,?)";
        Object[] args = {user.getUserId(), user.getUsername(), user.getUstatus()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public void delete(int id) {
        String sql = "delete from t_user where user_id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void update(User user) {
        String sql = "update t_user set username=?,ustatus=? where user_id=?";
        Object[] args = {user.getUsername(), user.getUstatus(), user.getUserId()};
        jdbcTemplate.update(sql, args);
    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public User selectOne(int id) {
        String sql = "select * from t_user where user_id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return user;
    }

    @Override
    public List<User> selectAll() {
        String sql = "select * from t_user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into t_user value(?,?,?)";
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }
}
