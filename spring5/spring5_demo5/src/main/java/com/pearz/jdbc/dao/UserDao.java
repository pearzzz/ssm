package com.pearz.jdbc.dao;

import com.pearz.jdbc.pojo.User;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:13 2022/1/4
 */
public interface UserDao {

    /**
     * TODO 添加数据
     * @param
     * @return: void
    */
    void add(User user);

    /**
     * TODO 根据id删除数据
     * @param id
     * @return: void
    */
    void delete(int id);

    /**
     * TODO 更新数据
     * @param user
     * @return: void
    */
    void update(User user);

    /**
     * TODO 查询记录条数
     * @param
     * @return: int
    */
    int selectCount();

    /**
     * TODO 查询单条记录
     * @param id
     * @return: com.pearz.jdbc.pojo.User
    */
    User selectOne(int id);

    /**
     * TODO 查询所有记录
     * @param
     * @return: java.util.List<com.pearz.jdbc.pojo.User>
    */
    List<User> selectAll();

    /**
     * TODO 插入多条记录
     * @param
     * @return: void
     */
    void batchAdd(List<Object[]> batchArgs);
}
