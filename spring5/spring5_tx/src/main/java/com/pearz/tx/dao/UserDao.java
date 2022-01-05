package com.pearz.tx.dao;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:57 2022/1/5
 */
public interface UserDao {

    /**
     * TODO 减钱
     * @param money
     * @return: void
    */
    void reduceMoney(String name, int money);

    /**
     * TODO 加钱
     * @param money
     * @return: void
    */
    void addMoney(String name, int money);
}
