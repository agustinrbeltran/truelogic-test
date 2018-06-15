package com.arenteria.test.truelogic.integration.dao.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.integration.dao.BookDAO;

import java.util.LinkedList;
import java.util.List;

public class BookMockDAOImpl implements BookDAO {
    @Override
    public List<BookEntity> fetchById(Integer... values) {
        return null;
    }

    @Override
    public BookEntity fetchOneById(Integer value) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByTittle(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByDescription(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByAuthor(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByContent(String... values) {
        return null;
    }

    @Override
    public void save(BookEntity o) throws DaoException {

    }

    @Override
    public List<BookEntity> fetchAll() {
        BookEntity bookEntity1 = new BookEntity(1,"Title1","Description 1","Author1","Content 1");
        BookEntity bookEntity2 = new BookEntity(1,"Title1","Description 1","Author1","Content 1");

        LinkedList<BookEntity> books = new LinkedList<BookEntity>();
        books.add(bookEntity1);
        books.add(bookEntity2);

        return books;
    }
}
