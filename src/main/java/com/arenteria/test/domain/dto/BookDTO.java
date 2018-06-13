package com.arenteria.test.domain.dto;

import com.arenteria.test.domain.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {

    private long id;
    private String tittle;
    private String description;
    private String content;

    public BookDTO() {
        // Jackson deserialization
    }

    public BookDTO(long id, String tittle, String description, String content) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
        this.content = content;
    }

    public BookDTO(BookEntity bookEntity) {
        this.id = bookEntity.getId();
        this.tittle = bookEntity.getTittle();
        this.description = bookEntity.getDescription();
        this.content = bookEntity.getContent();
    }

    public long getId() {
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
    public String getContent() {
        return content;
    }

}
