package com.arenteria.test.truelogic.domain.dto;

import com.arenteria.test.truelogic.domain.entity.AuthorEntity;
import com.fasterxml.jackson.annotation.JsonProperty;


public class AuthorDTO {
    private Integer id;
    private String fullName;


    public AuthorDTO() {
        // Jackson deserialization
    }

    public AuthorDTO(Integer id, String fullName) {

        this.id = id;
        this.fullName = fullName;

    }

    public AuthorDTO(AuthorEntity authorEntity) {
        this.id = authorEntity.getId();
        this.fullName = authorEntity.getFullName();
    }


    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getFullName() {
        return fullName;
    }

}
