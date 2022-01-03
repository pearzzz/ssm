package com.pearz.collectiontype.pojo;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 21:09 2022/1/2
 */
public class Course {
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
