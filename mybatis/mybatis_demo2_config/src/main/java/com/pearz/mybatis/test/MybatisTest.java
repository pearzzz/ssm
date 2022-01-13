package com.pearz.mybatis.test;

import com.pearz.mybatis.bean.Employee;
import com.pearz.mybatis.dao.EmployeeMapperAnnotation;
import com.pearz.mybatis.dao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:43 2022/1/11
 */
public class  MybatisTest {

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
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //3、获取接口的实现类对象
            //会为接口自动的创建一个代理对象，代理对象去扶行增删改查方法
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmployeeMapperAnnotation mapper = session.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(employee);
        }
    }
}
