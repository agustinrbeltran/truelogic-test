package com.arenteria.test.integration.dao.impl;

import com.arenteria.test.core.exception.DaoException;
import com.arenteria.test.domain.entity.BookEntity;
import com.arenteria.test.integration.dao.BookDAO;

import java.util.ArrayList;
import java.util.Collection;

public class BookDAOImpl implements BookDAO {


    @Override
    public Collection<BookEntity> findByTittle(String tittle, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public Collection<BookEntity> findByDescription(String description, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public Collection<BookEntity> findAll(Integer pageSize, Integer pageNum) {
        Collection<BookEntity> books = new ArrayList<BookEntity>();
        BookEntity bookEntity1 = new BookEntity(1, "Titulo1", "Primer libro", "Contenido fruta.");
        BookEntity bookEntity2 = new BookEntity(1, "Titulo2", "Segundo libro", "Contenido fruta 2.");
        books.add(bookEntity1);
        books.add(bookEntity2);
        return books;
    }

    @Override
    public BookEntity findById(long id) throws DaoException {
        return null;
    }

    @Override
    public void create(BookEntity bookEntity) throws DaoException {
    }
}
