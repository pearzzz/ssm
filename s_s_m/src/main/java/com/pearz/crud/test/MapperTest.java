package com.pearz.crud.test;

import com.pearz.crud.bean.Department;
import com.pearz.crud.bean.Employee;
import com.pearz.crud.bean.EmployeeExample;
import com.pearz.crud.dao.DepartmentMapper;
import com.pearz.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @Description 测试dao层的工作
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:55 2022/1/17
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test1() {

        System.out.println(departmentMapper);

        //departmentMapper.insertSelective(new Department(null, "开发部"));
        //departmentMapper.insertSelective(new Department(null, "测试部"));

        //employeeMapper.insertSelective(new Employee(null, "pearz", "M", "pearz@163.com", 1));

        /*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null, uuid, "M", uuid+"@qq.com", 1));
        }*/

        //employeeMapper.insertSelective(new Employee(null, "ll", "W", "ll@163.com", 2));

        List<Employee> employees = employeeMapper.selectByExampleWithDept(null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
