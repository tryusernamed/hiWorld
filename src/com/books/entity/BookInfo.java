package com.books.entity;

/**
 * 图书类
 */
public class BookInfo {
    private int Id; // 序号

    private String name; // 书名

    private String author; // 作者

    private String buyDate; // 购买日期

    private String typeName; // 分类名称

    public BookInfo() {
    }

    public BookInfo(int id, String name, String author, String buyDate, String typeName) {
        Id = id;
        this.name = name;
        this.author = author;
        this.buyDate = buyDate;
        this.typeName = typeName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
