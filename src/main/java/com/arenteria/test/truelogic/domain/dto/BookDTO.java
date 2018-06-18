package com.arenteria.test.truelogic.domain.dto;

import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    private String isbn;
    private String tittle;
    private String subtittle;
    private List<String> authors;
    private Date published;
    private String publisher;
    private Integer pages;
    private String description;
    private Boolean instock;

    public BookDTO() {
        // Jackson deserialization
    }

    public BookDTO(
            String isbn,
            String tittle,
            String subtittle,
            ArrayList<String> authors,
            Date published,
            String publisher,
            Integer pages,
            String description,
            Boolean instock) {

        this.isbn = isbn;
        this.tittle = tittle;
        this.subtittle = subtittle;
        this.authors = authors;
        this.published = published;
        this.publisher = publisher;
        this.pages = pages;
        this.description = description;
        this.instock = instock;

    }

    public BookDTO(BookEntity bookEntity, List<String> authors) {
        this.isbn = bookEntity.getIsbn();
        this.tittle = bookEntity.getTittle();
        this.authors = authors;
        this.published = bookEntity.getPublished();
        this.publisher = bookEntity.getPublisher();
        this.pages = bookEntity.getPages();
        this.description = bookEntity.getDescription();
        this.instock = bookEntity.getInstock();
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
    public String getIsbn() {
        return isbn;
    }

    @JsonProperty
    public String getSubtittle() {
        return subtittle;
    }

    @JsonProperty
    public List<String> getAuthors() {
        return authors;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    public Date getPublished() {
        return published;
    }

    @JsonProperty
    public String getPublisher() {
        return publisher;
    }

    @JsonProperty
    public Integer getPages() {
        return pages;
    }

    @JsonProperty
    public Boolean getInstock() {
        return instock;
    }


}
