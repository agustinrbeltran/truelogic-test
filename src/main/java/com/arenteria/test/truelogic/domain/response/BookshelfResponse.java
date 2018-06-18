package com.arenteria.test.truelogic.domain.response;

import com.arenteria.test.truelogic.domain.dto.BookDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookshelfResponse {

    List<BookDTO> bookshelf;

    public BookshelfResponse(List<BookDTO> bookshelf){
        this.bookshelf = bookshelf;
    }

    @JsonProperty
    List<BookDTO> getBookshelf(){
        return bookshelf;
    }
}
