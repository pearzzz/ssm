package com.pearz.service;

import com.pearz.bean.Employee;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:22 2022/1/15
 */
public interface EmployeeService {

    public List<Employee> getAllEmps() throws IOException;

    public void save(Employee employee) throws IOException;
}
