package com.arenteria.test.truelogic.domain.entity;

import java.io.Serializable;
import java.sql.Date;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class BookEntity implements Serializable {

    private static final long serialVersionUID = -1797103497;

    private String  isbn;
    private String  title;
    private String  subtitle;
    private Date    published;
    private String  publisher;
    private Integer pages;
    private String  description;
    private Boolean instock;

    public BookEntity() {}

    public BookEntity(BookEntity value) {
        this.isbn = value.isbn;
        this.title = value.title;
        this.subtitle = value.subtitle;
        this.published = value.published;
        this.publisher = value.publisher;
        this.pages = value.pages;
        this.description = value.description;
        this.instock = value.instock;
    }

    public BookEntity(
        String  isbn,
        String  title,
        String  subtitle,
        Date    published,
        String  publisher,
        Integer pages,
        String  description,
        Boolean instock
    ) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
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

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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
        sb.append(", ").append(title);
        sb.append(", ").append(subtitle);
        sb.append(", ").append(published);
        sb.append(", ").append(publisher);
        sb.append(", ").append(pages);
        sb.append(", ").append(description);
        sb.append(", ").append(instock);

        sb.append(")");
        return sb.toString();
    }
}
