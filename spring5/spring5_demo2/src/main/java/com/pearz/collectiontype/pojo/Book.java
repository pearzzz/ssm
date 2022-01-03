package com.pearz.collectiontype.pojo;

import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 21:20 2022/1/2
 */
public class Book {
    private List<String> books;

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Book{" +
                "books=" + books +
                '}';
    }
}
