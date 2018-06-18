package com.arenteria.test.truelogic.integration.dao.impl;

import com.arenteria.test.truelogic.core.exception.DaoException;
import com.arenteria.test.truelogic.db.tables.BookAuthor;
import com.arenteria.test.truelogic.db.tables.records.BookAuthorRecord;
import com.arenteria.test.truelogic.domain.entity.BookAuthorEntity;
import com.arenteria.test.truelogic.integration.dao.BookAuthorDAO;
import org.jooq.Configuration;
import org.jooq.Record2;
import org.jooq.impl.DAOImpl;
import java.util.List;


@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class BookAuthorDAOImpl extends DAOImpl<BookAuthorRecord,BookAuthorEntity, Record2<String, Integer>> implements BookAuthorDAO {


    public BookAuthorDAOImpl() {
        super(BookAuthor.BOOK_AUTHOR, BookAuthorEntity.class);
    }

    public BookAuthorDAOImpl(Configuration configuration) {
        super(BookAuthor.BOOK_AUTHOR, BookAuthorEntity.class, configuration);
    }

    @Override
    protected Record2<String, Integer> getId(BookAuthorEntity object) {
        return compositeKeyRecord(object.getBookIsbn(), object.getAuthorId());
    }

    public List<BookAuthorEntity> fetchByBookIsbn(String... values) {
        return fetch(BookAuthor.BOOK_AUTHOR.BOOK_ISBN, values);
    }


    public List<BookAuthorEntity> fetchByAuthorId(Integer... values) {
        return fetch(BookAuthor.BOOK_AUTHOR.AUTHOR_ID, values);
    }

    @Override
    public List<BookAuthorEntity> fetchAll() {
        return findAll();
    }

    @Override
    public void save(BookAuthorEntity o) throws DaoException {
        try{
            insert(o);
        }catch (Exception e){
            throw new DaoException();
        }
    }
}
