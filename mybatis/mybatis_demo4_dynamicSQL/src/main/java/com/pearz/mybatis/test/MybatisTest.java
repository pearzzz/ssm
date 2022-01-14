package com.pearz.mybatis.test;

import com.pearz.mybatis.bean.Department;
import com.pearz.mybatis.bean.Employee;
import com.pearz.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 22:53 2022/1/13
 */
public class MybatisTest {

    /**
     * TODO 根据xml配置文件（:全局配置文件）创建一个SqlSessionFactory对象
     * @param
     * @return: org.apache.ibatis.session.SqlSessionFactory
     */
    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testGetEmpsByIf() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            Employee employee = new Employee(null, "%e%", null, "1");

            List<Employee> emps = mapper.getEmpsByIf(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        }
    }

    @Test
    public void testGetEmpsByTrim() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            Employee employee = new Employee(null, "%e%", null, "1");

            List<Employee> emps = mapper.getEmpsByTrim(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        }
    }

    @Test
    public void testGetEmpsByChoose() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            Employee employee = new Employee(null, "%e%", null, "1");

            List<Employee> emps = mapper.getEmpsByChoose(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        }
    }

    @Test
    public void testUpdateEmps() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            Employee employee = new Employee(3, null, "123@111.com", "1");

            mapper.updateEmp(employee);
            openSession.commit();
        }
    }

    @Test
    public void testGetEmpsByForEach() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            List<Employee> employees = mapper.getEmpsByForEach(Arrays.asList(1, 2, 3, 4));

            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    @Test
    public void testAddEmps() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperDynamicSQL mapper = openSession.getMapper(EmployeeMapperDynamicSQL.class);

            List<Employee> employees = new LinkedList<>();
            Employee employee1 = new Employee(null, "ztx", "ztx@qq.com", "1", new Department(1));
            Employee employee2 = new Employee(null, "xh", "xh@qq.com", "0", new Department(0));
            employees.add(employee1);
            employees.add(employee2);

            mapper.addEmps(employees);
            openSession.commit();
        }
    }
}
