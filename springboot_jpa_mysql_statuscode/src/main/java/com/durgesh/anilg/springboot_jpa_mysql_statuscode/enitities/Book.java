package com.durgesh.anilg.springboot_jpa_mysql_statuscode.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int book_id;
    private String name;
    private String author;
    private double price;

    public Book(int book_id, String name, String author, double price) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.price = price;
    }


    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", book_id=" + book_id + ", name=" + name + ", price=" + price + "]";
    }

    
}
