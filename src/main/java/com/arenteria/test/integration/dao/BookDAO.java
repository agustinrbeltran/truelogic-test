package com.arenteria.test.integration.dao;

import com.arenteria.test.core.exception.DaoException;
import com.arenteria.test.domain.entity.BookEntity;
import java.util.Collection;

public interface BookDAO {

    Collection<BookEntity> findByTittle(String tittle, Integer pageSize, Integer pageNum);

    Collection<BookEntity> findByDescription(String description, Integer pageSize, Integer pageNum);

    Collection<BookEntity> findAll(Integer pageSize, Integer pageNum);

    BookEntity findById(long id) throws DaoException;

    void create(BookEntity bookEntity) throws DaoException;

}
