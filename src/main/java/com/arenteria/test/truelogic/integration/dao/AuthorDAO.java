package com.arenteria.test.truelogic.integration.dao;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.domain.entity.AuthorEntity;
import java.util.List;

public interface AuthorDAO {

    List<AuthorEntity> fetchById(Integer... values);

    AuthorEntity fetchOneById(Integer value);

    List<AuthorEntity> fetchByFullName(String... values);

    List<AuthorEntity> fetchAll();

    void save(AuthorEntity a) throws DaoException;

}
