package com.arenteria.test.truelogic.integration.dao;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import java.util.List;

public interface BookDAO {

    List<BookEntity> fetchById(Integer... values);

    BookEntity fetchOneById(Integer value);

    List<BookEntity> fetchByTittle(String... values);

    List<BookEntity> fetchByDescription(String... values);

    List<BookEntity> fetchByAuthor(String... values);

    List<BookEntity> fetchByContent(String... values);

    void save(BookEntity o) throws DaoException;

    List<BookEntity> fetchAll();

}
