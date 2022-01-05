package com.pearz.tx.service;

import com.pearz.tx.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:04 2022/1/5
 */

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * TODO a给b转账
     * @param a
     * @param b
     * @param money 钱数
     * @return: void
    */
    public void transferAtoB(String a, String b, int money) {
        userDao.reduceMoney(a, money);

        //模拟异常
        int i = 10 / 0;

        userDao.addMoney(b, money);
    }
}
