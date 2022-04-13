package com.example.libary;

public class Book_category {
    String name ;
    String author ;
    String price;
    String categoryName;

    public Book_category(String name, String author, String price, String categoryName) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.categoryName = categoryName;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
