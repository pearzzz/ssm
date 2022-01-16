package com.pearz.service.Impl;

import com.pearz.bean.Employee;
import com.pearz.mapper.EmployeeMapper;
import com.pearz.service.EmployeeService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:23 2022/1/15
 */

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Override
    public List<Employee> getAllEmps() {
        return mapper.getAllEmps();
    }

    @Override
    public void save(Employee employee) {
        mapper.addEmp(employee);
    }
}
