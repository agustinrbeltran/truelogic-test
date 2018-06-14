package com.arenteria.test.integration.dao;

import com.arenteria.test.core.exception.DaoException;
import com.arenteria.test.domain.entity.BookEntity;
import java.util.List;

public interface BookDAO {

    List<BookEntity> fetchById(Integer... values);

    BookEntity fetchOneById(Integer value) throws DaoException;

    List<BookEntity> fetchByTittle(String... values);

    List<BookEntity> fetchByDescription(String... values);

    List<BookEntity> fetchByAuthor(String... values);

    List<BookEntity> fetchByContent(String... values);

    void save(BookEntity o) throws DaoException;

    List<BookEntity> fetchAll();

}
