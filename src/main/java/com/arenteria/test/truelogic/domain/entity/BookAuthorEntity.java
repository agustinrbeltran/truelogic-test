package com.arenteria.test.truelogic.domain.entity;

import java.io.Serializable;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookAuthorEntity implements Serializable {

    private static final long serialVersionUID = -22203243;

    private String  bookIsbn;
    private Integer authorId;

    public BookAuthorEntity() {}

    public BookAuthorEntity(BookAuthorEntity value) {
        this.bookIsbn = value.bookIsbn;
        this.authorId = value.authorId;
    }

    public BookAuthorEntity(
        String  bookIsbn,
        Integer authorId
    ) {
        this.bookIsbn = bookIsbn;
        this.authorId = authorId;
    }

    public String getBookIsbn() {
        return this.bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public Integer getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BookAuthorEntity (");

        sb.append(bookIsbn);
        sb.append(", ").append(authorId);

        sb.append(")");
        return sb.toString();
    }
}
