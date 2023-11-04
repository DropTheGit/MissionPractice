package com.ll;

class Quotation {
    String content;
    String author;
    int id;

    public Quotation(String content, String author, int id) {
        this.content = content;
        this.author = author;
        this.id = id;
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public Quotation(int id) {
        this.id = id;
    }
}
