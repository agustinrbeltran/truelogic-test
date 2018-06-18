package com.arenteria.test.truelogic.domain.entity;

import java.io.Serializable;
import java.sql.Date;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -1797103497;

    private String  isbn;
    private String  tittle;
    private String  subtittle;
    private Date    published;
    private String  publisher;
    private Integer pages;
    private String  description;
    private Boolean instock;

    public BookEntity() {}

    public BookEntity(BookEntity value) {
        this.isbn = value.isbn;
        this.tittle = value.tittle;
        this.subtittle = value.subtittle;
        this.published = value.published;
        this.publisher = value.publisher;
        this.pages = value.pages;
        this.description = value.description;
        this.instock = value.instock;
    }

    public BookEntity(
        String  isbn,
        String  tittle,
        String  subtittle,
        Date    published,
        String  publisher,
        Integer pages,
        String  description,
        Boolean instock
    ) {
        this.isbn = isbn;
        this.tittle = tittle;
        this.subtittle = subtittle;
        this.published = published;
        this.publisher = publisher;
        this.pages = pages;
        this.description = description;
        this.instock = instock;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTittle() {
        return this.tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSubtittle() {
        return this.subtittle;
    }

    public void setSubtittle(String subtittle) {
        this.subtittle = subtittle;
    }

    public Date getPublished() {
        return this.published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInstock() {
        return this.instock;
    }

    public void setInstock(Boolean instock) {
        this.instock = instock;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BookEntity (");

        sb.append(isbn);
        sb.append(", ").append(tittle);
        sb.append(", ").append(subtittle);
        sb.append(", ").append(published);
        sb.append(", ").append(publisher);
        sb.append(", ").append(pages);
        sb.append(", ").append(description);
        sb.append(", ").append(instock);

        sb.append(")");
        return sb.toString();
    }
}
