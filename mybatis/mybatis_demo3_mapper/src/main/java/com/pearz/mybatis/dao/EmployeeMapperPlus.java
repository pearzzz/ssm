package com.pearz.mybatis.dao;

import com.pearz.mybatis.bean.Employee;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:09 2022/1/12
 */
public interface EmployeeMapperPlus {

    public Employee getEmpById(int id);

    public Employee getEmpAndDept(int id);

    public Employee getEmpByIdStep(int id);

    public List<Employee> getEmpsByDid(int did);
}
