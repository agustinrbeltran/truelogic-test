package com.arenteria.test.integration.dao.impl;

import com.arenteria.test.core.exception.DaoException;
import com.arenteria.test.domain.entity.BookEntity;
import com.arenteria.test.integration.dao.BookDAO;
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
        return null;
    }

    @Override
    public BookEntity findById(long id) throws DaoException {
        return null;
    }

    @Override
    public void create(BookEntity bookEntity) throws DaoException {
    }
}
