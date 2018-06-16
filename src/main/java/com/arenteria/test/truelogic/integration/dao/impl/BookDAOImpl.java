package com.arenteria.test.truelogic.integration.dao.impl;

import java.util.List;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.db.tables.Book;
import com.arenteria.test.truelogic.db.tables.records.BookRecord;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.integration.dao.BookDAO;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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

    public BookEntity fetchOneById(Integer value) {
        return fetchOne(Book.BOOK.ID, value);
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
