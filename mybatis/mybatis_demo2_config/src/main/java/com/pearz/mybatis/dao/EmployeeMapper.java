package com.pearz.mybatis.dao;

import com.pearz.mybatis.bean.Employee;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:04 2022/1/11
 */
public interface EmployeeMapper {

    /**
     * TODO 根据id返回员工信息
     * @param id 员工id
     * @return: com.pearz.mybatis.bean.Employee
    */
    public Employee getEmpById(int id);
}
