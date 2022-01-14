package com.pearz.mybatis.dao;

import com.pearz.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 21:40 2022/1/13
 */

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpsByIf(Employee employee);

    public List<Employee> getEmpsByTrim(Employee employee);

    public List<Employee> getEmpsByChoose(Employee employee);

    public void updateEmp(Employee employee);

    public List<Employee> getEmpsByForEach(@Param("ids") List<Integer> ids);

    public void addEmps(@Param("emps") List<Employee> emps);
}
