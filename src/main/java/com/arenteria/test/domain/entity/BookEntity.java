package com.arenteria.test.domain.entity;

public class BookEntity {

    private long id;
    private String tittle;
    private String description;
    private String content;

    public BookEntity(){}

    public BookEntity(long id, String tittle, String description, String content) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
