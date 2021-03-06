package com.arenteria.test.truelogic.service.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.core.exception.ServiceException;
import com.arenteria.test.truelogic.domain.dto.BookDTO;
import com.arenteria.test.truelogic.domain.entity.AuthorEntity;
import com.arenteria.test.truelogic.domain.entity.BookAuthorEntity;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.domain.mapper.BookMapper;
import com.arenteria.test.truelogic.integration.dao.AuthorDAO;
import com.arenteria.test.truelogic.integration.dao.BookAuthorDAO;
import com.arenteria.test.truelogic.integration.dao.BookDAO;
import com.arenteria.test.truelogic.service.BookshelfService;

import java.util.List;

public class BookshelfServiceImpl implements BookshelfService {

    private final BookDAO bookDAO;
    private final AuthorDAO authorDAO;
    private final BookAuthorDAO bookAuthorDao;
    private final BookMapper bookMapper;

    public BookshelfServiceImpl(BookDAO bookDAO, AuthorDAO authorDAO, BookAuthorDAO bookAuthorDao) {
        this.bookDAO = bookDAO;
        this.authorDAO = authorDAO;
        this.bookAuthorDao = bookAuthorDao;
        this.bookMapper = new BookMapper(authorDAO, bookAuthorDao);
    }

    @Override
    public List<BookDTO> findBookByTitle(String title) throws ServiceException {
        try {
            List<BookEntity> books = bookDAO.fetchByTitle(title);
            List<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
            return bookDTOs;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<BookDTO> findBookByDescription(String description) throws ServiceException {
        try {
            List<BookEntity> books = bookDAO.fetchByDescription(description);
            List<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
            return bookDTOs;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<BookDTO> findAllBooks() throws ServiceException {
        try {
            List<BookEntity> books = bookDAO.fetchAll();
            List<BookDTO> bookDTOs = bookMapper.bookEntitiesToBookDTOs(books);
            return bookDTOs;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public BookDTO findBookByIsbn(String isbn) throws ServiceException {
        try {
            BookEntity bookEntity = bookDAO.fetchOneByIsbn(isbn);
            BookDTO response = bookMapper.bookEntityToBookDTO(bookEntity);
            return response;
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void saveBook(BookDTO bookDTO) throws ServiceException {

        try {
            AuthorEntity authorEntity;
            List<AuthorEntity> result;

            BookEntity bookEntity = bookMapper.bookDTOToBookEntity(bookDTO);
            bookDAO.save(bookEntity);

            for (String author : bookDTO.getAuthors()) {
                result = authorDAO.fetchByFullName(author);
                if (result.isEmpty()) {
                    authorEntity = new AuthorEntity();
                    authorEntity.setFullName(author);
                    authorDAO.save(authorEntity);
                } else {
                    authorEntity = result.get(0);
                }

                BookAuthorEntity bookAuthorEntity = new BookAuthorEntity(bookEntity.getIsbn(), authorEntity.getId());
                bookAuthorDao.save(bookAuthorEntity);
            }


        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }

    }
}
