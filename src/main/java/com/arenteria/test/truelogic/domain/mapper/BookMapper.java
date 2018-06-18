package com.arenteria.test.truelogic.domain.mapper;

import com.arenteria.test.truelogic.domain.dto.BookDTO;
import com.arenteria.test.truelogic.domain.entity.AuthorEntity;
import com.arenteria.test.truelogic.domain.entity.BookAuthorEntity;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.integration.dao.AuthorDAO;
import com.arenteria.test.truelogic.integration.dao.BookAuthorDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class BookMapper {

    private final AuthorDAO authorDAO;
    private final BookAuthorDAO bookAuthorDao;

    public BookMapper(AuthorDAO authorDAO, BookAuthorDAO bookAuthorDAO){
        this.authorDAO = authorDAO;
        this.bookAuthorDao = bookAuthorDAO;
    }

    public BookDTO bookEntityToBookDTO(BookEntity bookEntity) {

        ArrayList<String> authors = new ArrayList<>();

        Collection<BookAuthorEntity> bookAuthorEntities = bookAuthorDao.fetchByBookIsbn(bookEntity.getIsbn());

        for (BookAuthorEntity bookAuthorEntity : bookAuthorEntities) {
            Integer id = bookAuthorEntity.getAuthorId();
            AuthorEntity authorEntity = authorDAO.fetchOneById(id);
            authors.add(authorEntity.getFullName());
        }

        return new BookDTO(bookEntity,authors);
    }

    public BookEntity bookDTOToBookEntity(BookDTO bookDTO) {
        if (bookDTO == null) {
            return null;
        } else {
            BookEntity bookEntity = new BookEntity(
                    bookDTO.getIsbn(),
                    bookDTO.getTittle(),
                    bookDTO.getSubtittle(),
                    bookDTO.getPublished(),
                    bookDTO.getPublisher(),
                    bookDTO.getPages(),
                    bookDTO.getDescription(),
                    bookDTO.getInstock()
            );

            return bookEntity;
        }
    }

    public List<BookDTO> bookEntitiesToBookDTOs(List<BookEntity> bookEntities) {
        return bookEntities.stream()
                .filter(Objects::nonNull)
                .map(this::bookEntityToBookDTO)
                .collect(Collectors.toList());
    }



    public List<BookEntity> bookDTOsToBookEntities(List<BookDTO> bookDTOs) {
        return bookDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::bookDTOToBookEntity)
                .collect(Collectors.toList());
    }

    public BookEntity bookEntityFromId(String isbn) {
        if (isbn.isEmpty()) {
            return null;
        }
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(isbn);
        return bookEntity;
    }
}
