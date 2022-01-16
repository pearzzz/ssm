package com.pearz.mapper;

import com.pearz.bean.Employee;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:04 2022/1/11
 */
public interface EmployeeMapper {

    /**
     * TODO 根据id返回员工信息
     * @return: com.pearz.mybatis.bean.Employee
    */
    public List<Employee> getAllEmps();

    public void addEmp(Employee employee);

}
