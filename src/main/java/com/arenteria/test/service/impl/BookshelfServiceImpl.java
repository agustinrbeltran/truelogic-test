package com.arenteria.test.service.impl;

import com.arenteria.test.core.exception.DaoException;
import com.arenteria.test.core.exception.ServiceException;
import com.arenteria.test.domain.dto.BookDTO;
import com.arenteria.test.domain.entity.BookEntity;
import com.arenteria.test.domain.mapper.BookMapper;
import com.arenteria.test.integration.dao.BookDAO;
import com.arenteria.test.service.BookshelfService;
import java.util.Collection;

public class BookshelfServiceImpl implements BookshelfService {

    private final BookDAO bookDAO;
    private final BookMapper bookMapper;

    public BookshelfServiceImpl(BookDAO bookDAO, BookMapper bookMapper) {
        this.bookDAO = bookDAO;
        this.bookMapper = bookMapper;
    }

    @Override
    public Collection<BookDTO> findBookByTittle(String tittle, Integer pageSize, Integer pageNum) {
        Collection<BookEntity> books = bookDAO.findByTittle(tittle, pageSize, pageNum);
        Collection<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
        return bookDTOs;
    }

    @Override
    public Collection<BookDTO> findBookByDescription(String description, Integer pageSize, Integer pageNum) {
        Collection<BookEntity> books = bookDAO.findByTittle(description, pageSize, pageNum);
        Collection<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
        return bookDTOs;
    }

    @Override
    public Collection<BookDTO> findAllBooks(Integer pageSize, Integer pageNum) {
        Collection<BookEntity> books = bookDAO.findAll(pageSize, pageNum);
        Collection<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
        return bookDTOs;
    }

    @Override
    public BookDTO findBookById(long id) throws ServiceException {
        BookDTO bookDTO = null;
        try {
            BookEntity bookEntity = bookDAO.findById(id);
            bookDTO = bookMapper.bookEntityToBookDTO(bookEntity);
        } catch (DaoException e) {
            throw new ServiceException();
        }

        return bookDTO;
    }

    @Override
    public void saveBook(BookDTO bookDTO) throws ServiceException {

        BookEntity bookEntity = bookMapper.bookDTOToBookEntity(bookDTO);
        try {
            bookDAO.create(bookEntity);
        } catch (DaoException e) {
            throw new ServiceException();
        }
    }
}
