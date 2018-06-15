package com.arenteria.test.truelogic.domain.mapper;

import com.arenteria.test.truelogic.domain.dto.BookDTO;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class BookMapper {

    public BookDTO bookEntityToBookDTO(BookEntity bookEntity) {
        return new BookDTO(bookEntity);
    }

    public BookEntity bookDTOToBookEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        } else {
            BookEntity bookEntity = new BookEntity(
                    bookDTO.getId(),
                    bookDTO.getTittle(),
                    bookDTO.getDescription(),
                    bookDTO.getAuthor(),
                    bookDTO.getContent()
            );

            return bookEntity;
        }
    }

    public Collection<BookDTO> bookEntitiesToBookDTOs(Collection<BookEntity> bookEntities) {
        return bookEntities.stream()
                .filter(Objects::nonNull)
                .map(this::bookEntityToBookDTO)
                .collect(Collectors.toList());
    }



    public Collection<BookEntity> bookDTOsToBookEntities(Collection<BookDTO> bookDTOs) {
        return bookDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::bookDTOToBookEntity)
                .collect(Collectors.toList());
    }

    public BookEntity bookEntityFromId(Integer id) {
        if (id == null) {
            return null;
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(id);
        return bookEntity;
    }
}
