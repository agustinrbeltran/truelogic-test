package com.arenteria.test.truelogic.integration.dao.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import com.arenteria.test.truelogic.integration.dao.BookDAO;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class BookMockDAOImpl implements BookDAO {


    @Override
    public List<BookEntity> fetchByIsbn(String... values) {
        return null;
    }

    @Override
    public BookEntity fetchOneByIsbn(String value) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByTitle(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchBySubtitle(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByPublished(Date... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByPublisher(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByPages(Integer... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByDescription(String... values) {
        return null;
    }

    @Override
    public List<BookEntity> fetchByInstock(Boolean... values) {
        return null;
    }

    @Override
    public void save(BookEntity o) throws DaoException {

    }

    public List<BookEntity> fetchAll() {
        //BookEntity bookEntity1 = new BookEntity(1,"Title1","Description 1","Author1","Content 1");
        //BookEntity bookEntity2 = new BookEntity(1,"Title1","Description 1","Author1","Content 1");

        LinkedList<BookEntity> books = new LinkedList<BookEntity>();

        return books;
    }
}
