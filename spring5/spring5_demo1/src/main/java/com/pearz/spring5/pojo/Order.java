package com.pearz.spring5.pojo;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:16 2022/1/2
 */
public class Order {
    private String orderName;
    private String address;

    public Order(String orderName, String address) {
        this.orderName = orderName;
        this.address = address;
    }

    public void test() {
        System.out.println(orderName + "-" + address);
    }
}
