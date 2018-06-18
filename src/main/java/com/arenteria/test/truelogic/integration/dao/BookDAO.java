package com.arenteria.test.truelogic.integration.dao;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.domain.entity.BookEntity;
import java.sql.Date;
import java.util.List;

public interface BookDAO {

    List<BookEntity> fetchByIsbn(String... values);

    BookEntity fetchOneByIsbn(String value);

    List<BookEntity> fetchByTitle(String... values);

    List<BookEntity> fetchBySubtitle(String... values);

    List<BookEntity> fetchByPublished(Date... values);

    List<BookEntity> fetchByPublisher(String... values);

    List<BookEntity> fetchByPages(Integer... values);

    List<BookEntity> fetchByDescription(String... values);

    List<BookEntity> fetchByInstock(Boolean... values);

    void save(BookEntity o) throws DaoException;

    List<BookEntity> fetchAll();

}
