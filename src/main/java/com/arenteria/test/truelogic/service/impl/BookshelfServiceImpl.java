package com.arenteria.test.truelogic.service.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.core.exception.ServiceException;
import com.arenteria.test.truelogic.domain.dto.BookDTO;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.domain.mapper.BookMapper;
import com.arenteria.test.truelogic.integration.dao.BookDAO;
import com.arenteria.test.truelogic.service.BookshelfService;

import java.util.Collection;

public class BookshelfServiceImpl implements BookshelfService {

    private final BookDAO bookDAO;
    private final BookMapper bookMapper;

    public BookshelfServiceImpl(BookDAO bookDAO, BookMapper bookMapper) {
        this.bookDAO = bookDAO;
        this.bookMapper = bookMapper;
    }

    @Override
    public Collection<BookDTO> findBookByTittle(String tittle) {
        Collection<BookEntity> books = bookDAO.fetchByTittle(tittle);
        Collection<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
        return bookDTOs;
    }

    @Override
    public Collection<BookDTO> findBookByDescription(String description) {
        Collection<BookEntity> books = bookDAO.fetchByDescription(description);
        Collection<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
        return bookDTOs;
    }

    @Override
    public Collection<BookDTO> findAllBooks() {
        Collection<BookEntity> books = bookDAO.fetchAll();
        Collection<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
        return bookDTOs;
    }

    @Override
    public BookDTO findBookById(Integer id) {

        BookEntity bookEntity = bookDAO.fetchOneById(id);

        BookDTO response = null;

        if (bookEntity != null) {
            response = bookMapper.bookEntityToBookDTO(bookEntity);
        }

        return response;

    }

    @Override
    public void saveBook(BookDTO bookDTO) throws ServiceException {

        try {
            BookEntity bookEntity = bookMapper.bookDTOToBookEntity(bookDTO);
            bookDAO.save(bookEntity);
        } catch (DaoException e) {
            throw new ServiceException();
        }

    }
}