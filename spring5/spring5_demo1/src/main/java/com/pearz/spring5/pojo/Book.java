package com.pearz.spring5.pojo;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 18:00 2022/1/2
 */
public class Book {
    private String bookName;
    private String author;

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void test() {
        System.out.println("《" + bookName + "》" + " " + author);
    }
}
