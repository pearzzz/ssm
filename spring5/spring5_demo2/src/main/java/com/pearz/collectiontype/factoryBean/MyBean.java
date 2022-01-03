package com.pearz.collectiontype.factoryBean;

import com.pearz.collectiontype.pojo.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:54 2022/1/3
 */
public class MyBean implements FactoryBean<Course> {

    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("Java程序设计");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
