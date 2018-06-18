package com.arenteria.test.truelogic.domain.dto;

import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    private String isbn;
    private String title;
    private String subtitle;
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
            String title,
            String subtitle,
            ArrayList<String> authors,
            Date published,
            String publisher,
            Integer pages,
            String description,
            Boolean instock) {

        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.published = published;
        this.publisher = publisher;
        this.pages = pages;
        this.description = description;
        this.instock = instock;

    }

    public BookDTO(BookEntity bookEntity, List<String> authors) {
        this.isbn = bookEntity.getIsbn();
        this.title = bookEntity.getTitle();
        this.authors = authors;
        this.published = bookEntity.getPublished();
        this.publisher = bookEntity.getPublisher();
        this.pages = bookEntity.getPages();
        this.description = bookEntity.getDescription();
        this.instock = bookEntity.getInstock();
    }


    @JsonProperty
    public String getTitle() {
        return title;
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
    public String getSubtitle() {
        return subtitle;
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
