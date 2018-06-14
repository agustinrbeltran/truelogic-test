package com.arenteria.test.domain.entity;

import java.io.Serializable;

public class BookEntity implements Serializable {

    private static final long serialVersionUID = 1210666508;

    private Integer id;
    private String tittle;
    private String description;
    private String author;
    private String content;

    public BookEntity() {
    }

    public BookEntity(BookEntity value) {
        this.id = value.id;
        this.tittle = value.tittle;
        this.description = value.description;
        this.author = value.author;
        this.content = value.content;
    }

    public BookEntity(
            Integer id,
            String tittle,
            String description,
            String author,
            String content
    ) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.author = author;
        this.content = content;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return this.tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Book (");

        sb.append(id);
        sb.append(", ").append(tittle);
        sb.append(", ").append(description);
        sb.append(", ").append(author);
        sb.append(", ").append(content);

        sb.append(")");
        return sb.toString();
    }
}
