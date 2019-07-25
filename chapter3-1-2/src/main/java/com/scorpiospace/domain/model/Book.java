package com.scorpiospace.domain.model;

/**
 * @ClassName Book
 * @Description TODO
 * @Author zq
 * @Date 2019/7/22 15:02
 * @Version 1.0
 **/
public class Book {
    private String bookName;
    private String autor;
    private String price;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Book(String bookName, String autor, String price) {
        this.bookName = bookName;
        this.autor = autor;
        this.price = price;
    }
}
