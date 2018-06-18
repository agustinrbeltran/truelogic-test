package com.arenteria.test.truelogic.integration.dao.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.db.tables.Book;
import com.arenteria.test.truelogic.db.tables.records.BookRecord;
import java.sql.Date;
import java.util.List;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.integration.dao.BookDAO;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class BookDAOImpl extends DAOImpl<BookRecord, BookEntity, String> implements BookDAO {


    public BookDAOImpl() {
        super(Book.BOOK, BookEntity.class);
    }

    public BookDAOImpl(Configuration configuration) {
        super(Book.BOOK, BookEntity.class, configuration);
    }

    @Override
    protected String getId(BookEntity object) {
        return object.getIsbn();
    }

    public List<BookEntity> fetchByIsbn(String... values) {
        return fetch(Book.BOOK.ISBN, values);
    }

    public BookEntity fetchOneByIsbn(String value) {
        return fetchOne(Book.BOOK.ISBN, value);
    }

    public List<BookEntity> fetchByTittle(String... values) {
        return fetch(Book.BOOK.TITTLE, values);
    }

    public List<BookEntity> fetchBySubtittle(String... values) {
        return fetch(Book.BOOK.SUBTITTLE, values);
    }

    public List<BookEntity> fetchByPublished(Date... values) {
        return fetch(Book.BOOK.PUBLISHED, values);
    }

    public List<BookEntity> fetchByPublisher(String... values) {
        return fetch(Book.BOOK.PUBLISHER, values);
    }

    public List<BookEntity> fetchByPages(Integer... values) {
        return fetch(Book.BOOK.PAGES, values);
    }

    public List<BookEntity> fetchByDescription(String... values) {
        return fetch(Book.BOOK.DESCRIPTION, values);
    }

    public List<BookEntity> fetchByInstock(Boolean... values) {
        return fetch(Book.BOOK.INSTOCK, values);
    }

    @Override
    public void save(BookEntity o) throws DaoException {
        try{
            insert(o);
        }catch (Exception e){
            throw new DaoException();
        }
    }

    @Override
    public List<BookEntity> fetchAll() {
        return findAll();
    }

}
