package com.ll;

class Quotation {
    String content;
    String author;
    int id;

    public Quotation(String content, String author, int id) {
        this.content = content;
        this.author = author;
        this.id = id;
    }

    public Quotation(int id) {
        this.id = id;
    }
}
