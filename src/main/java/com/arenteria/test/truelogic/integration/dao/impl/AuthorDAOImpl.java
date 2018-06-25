package com.arenteria.test.truelogic.integration.dao.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.db.tables.Author;
import com.arenteria.test.truelogic.db.tables.records.AuthorRecord;
import com.arenteria.test.truelogic.domain.entity.AuthorEntity;
import com.arenteria.test.truelogic.integration.dao.AuthorDAO;
import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import java.util.List;

@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthorDAOImpl extends DAOImpl<AuthorRecord, AuthorEntity, Integer> implements AuthorDAO {

    public AuthorDAOImpl() {
        super(Author.AUTHOR, AuthorEntity.class);
    }

    public AuthorDAOImpl(Configuration configuration) {
        super(Author.AUTHOR, AuthorEntity.class, configuration);
    }

    @Override
    protected Integer getId(AuthorEntity object) {
        return object.getId();
    }

    public List<AuthorEntity> fetchById(Integer... values) {
        return fetch(Author.AUTHOR.ID, values);
    }

    public AuthorEntity fetchOneById(Integer value) {
        return fetchOne(Author.AUTHOR.ID, value);
    }

    public List<AuthorEntity> fetchByFullName(String... values) {
        return fetch(Author.AUTHOR.FULL_NAME, values);
    }

    @Override
    public List<AuthorEntity> fetchAll() {
        return findAll();
    }


    @Override
    public void save(AuthorEntity a) throws DaoException {
        try{
            insert(a);
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }
}
