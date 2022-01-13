package com.pearz.mybatis.dao;

import com.pearz.mybatis.bean.Department;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 16:45 2022/1/13
 */
public interface DepartmentMapper {

    public Department getDeptById(int id);

    public Department getDeptByIdPlus(int id);

    public Department getDeptByIdStep(int id);
}
