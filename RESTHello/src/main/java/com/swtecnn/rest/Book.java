package com.swtecnn.rest;

public class Book {

    String author;
    String name;

    public Book(String a, String n){
        author = a;
        name = n;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
