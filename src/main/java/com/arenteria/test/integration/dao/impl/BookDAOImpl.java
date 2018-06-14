package com.arenteria.test.integration.dao.impl;

import java.util.List;

import com.arenteria.test.core.exception.DaoException;
import com.arenteria.test.domain.entity.BookEntity;
import com.arenteria.test.integration.dao.BookDAO;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.jooq.sources.tables.Book;
import org.jooq.sources.tables.records.BookRecord;


public class BookDAOImpl extends DAOImpl<BookRecord, BookEntity, Integer> implements BookDAO {

    public BookDAOImpl() {
        super(Book.BOOK, BookEntity.class);
    }

    public BookDAOImpl(Configuration configuration) {
        super(Book.BOOK, BookEntity.class, configuration);
    }

    @Override
    protected Integer getId(BookEntity object) {
        return object.getId();
    }

    public List<BookEntity> fetchById(Integer... values) {
        return fetch(Book.BOOK.ID, values);
    }

    public BookEntity fetchOneById(Integer value) throws DaoException {
        BookEntity bookEntity = fetchOne(Book.BOOK.ID, value);
        if (bookEntity == null) {
            throw new DaoException();
        }
        return bookEntity;
    }

    public List<BookEntity> fetchByTittle(String... values) {
        return fetch(Book.BOOK.TITTLE, values);
    }

    public List<BookEntity> fetchByDescription(String... values) {
        return fetch(Book.BOOK.DESCRIPTION, values);
    }

    public List<BookEntity> fetchByAuthor(String... values) {
        return fetch(Book.BOOK.AUTHOR, values);
    }

    public List<BookEntity> fetchByContent(String... values) {
        return fetch(Book.BOOK.CONTENT, values);
    }

    public void save(BookEntity o) throws DaoException {
        try {
            this.insert(o);
        } catch (Exception e) {
            throw new DaoException();
        }
    }

    public List<BookEntity> fetchAll() {
        return findAll();
    }
}
