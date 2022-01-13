package com.pearz.mybatis.dao;

import com.pearz.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 21:01 2022/1/11
 */
public interface EmployeeMapperAnnotation {

    @Select("select * from tbl_employee where id = #{id}")
    public Employee getEmpById(int id);
}
