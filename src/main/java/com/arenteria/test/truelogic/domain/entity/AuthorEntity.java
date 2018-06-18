package com.arenteria.test.truelogic.domain.entity;

import java.io.Serializable;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = -1964853523;

    private Integer id;
    private String  fullName;

    public AuthorEntity() {}

    public AuthorEntity(AuthorEntity value) {
        this.id = value.id;
        this.fullName = value.fullName;
    }

    public AuthorEntity(
        Integer id,
        String  fullName
    ) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("AuthorEntity (");

        sb.append(id);
        sb.append(", ").append(fullName);

        sb.append(")");
        return sb.toString();
    }
}
