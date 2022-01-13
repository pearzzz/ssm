package com.pearz.mybatis.test;

import com.pearz.mybatis.bean.Department;
import com.pearz.mybatis.bean.Employee;
import com.pearz.mybatis.dao.DepartmentMapper;
import com.pearz.mybatis.dao.EmployeeMapper;
import com.pearz.mybatis.dao.EmployeeMapperAnnotation;
import com.pearz.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:43 2022/1/11
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
    public void test() throws IOException {
        //1、根据xml配置文件（:全局配置文件）创建一个SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2、获取sqlsession实例，能直接执行已经映射的sql语句
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Employee employee = session.selectOne("com.pearz.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        }
    }

    @Test
    public void test1() throws IOException {
        //1、获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //2、获取SqlSession对象
        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            //3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去扶行增删改查方法
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void tsetAdd() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee(null, "redz", "redz@gmail.com", "1");
            mapper.addEmp(employee);
            System.out.println(employee.getId());

            openSession.commit();
        }
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee(1, "redz", "redz@gmail.com", "0");
            mapper.updateEmp(employee);

            openSession.commit();
        }
    }

    @Test
    public void tsetDelete() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            mapper.deleteEmpById(1);

            openSession.commit();
        }
    }

    @Test
    public void testGetEmpByIdAndLastName() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpByIdAndLastName(2, "redz");
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmpByMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Map<String, Object> map = new HashMap();
            map.put("id", 2);
            map.put("lastName", "redz");

            Employee employee = mapper.getEmpByIdAndLastName(2, "redz");
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmpByLastName() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            List<Employee> employees = mapper.getEmpByLastName("%e%");
            System.out.println(employees);
        }
    }

    @Test
    public void testGetEmpByIdReturnMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Map<String, Object> employees = mapper.getEmpByIdReturnMap(2);
            System.out.println(employees);
        }
    }

    @Test
    public void testGetEmpByLastNameReturnMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Map<Integer, Object> employees = mapper.getEmpByLastNameReturnMap("%e%");
            System.out.println(employees);
        }
    }

    @Test
    public void testGetEmpByIdPlus() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = mapper.getEmpById(3);
            System.out.println(employee);
        }
    }

    @Test
    public void testGetEmpAndDept() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);
            Employee employee = mapper.getEmpByIdStep(3);
            System.out.println(employee.getLastName());
        }
    }

    @Test
    public void testGetDeptByIdPlus() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            Department dept = mapper.getDeptByIdPlus(1);
            System.out.println(dept);
        }
    }

    @Test
    public void testGetDeptByIdStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession openSession = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            Department dept = mapper.getDeptByIdStep(2);
            System.out.println(dept);
        }
    }
}
