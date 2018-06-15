package com.arenteria.test.truelogic.domain.dto;

import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {

    private Integer id;
    private String tittle;
    private String description;
    private String author;
    private String content;

    public BookDTO() {
        // Jackson deserialization
    }

    public BookDTO(Integer id, String tittle, String description, String author, String content) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.author = author;
        this.content = content;
    }

    public BookDTO(BookEntity bookEntity) {
        this.id = bookEntity.getId();
        this.tittle = bookEntity.getTittle();
        this.description = bookEntity.getDescription();
        this.author = bookEntity.getAuthor();
        this.content = bookEntity.getContent();
    }

    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getTittle() {
        return tittle;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getAuthor() {
        return this.author;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

}
