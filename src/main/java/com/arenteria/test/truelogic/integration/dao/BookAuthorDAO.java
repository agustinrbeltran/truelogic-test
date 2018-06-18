package com.arenteria.test.truelogic.integration.dao;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.domain.entity.BookAuthorEntity;

import java.util.List;

public interface BookAuthorDAO {

    List<BookAuthorEntity> fetchByBookIsbn(String... values);

    List<BookAuthorEntity> fetchByAuthorId(Integer... values);

    List<BookAuthorEntity> fetchAll();

    void save(BookAuthorEntity o) throws DaoException;

}
