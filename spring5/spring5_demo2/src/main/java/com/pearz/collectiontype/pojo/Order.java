package com.pearz.collectiontype.pojo;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 13:27 2022/1/3
 */
public class Order {
    private String oname;

    public Order() {
        System.out.println("1.无参构造器");
    }

    public void initMethod() {
        System.out.println("3.init");
    }

    public void destroyMethod() {
        System.out.println("5.destroy");
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2.set");
    }
}
