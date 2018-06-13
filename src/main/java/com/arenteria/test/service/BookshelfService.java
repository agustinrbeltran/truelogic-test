package com.arenteria.test.service;

import com.arenteria.test.core.exception.ServiceException;
import com.arenteria.test.domain.dto.BookDTO;
import java.util.Collection;

public interface BookshelfService {

    Collection<BookDTO> findBookByTittle(String tittle, Integer pageSize, Integer pageNum);

    Collection<BookDTO> findBookByDescription(String description, Integer pageSize, Integer pageNum);

    Collection<BookDTO> findAllBooks(Integer pageSize, Integer pageNum);

    BookDTO findBookById(long id) throws ServiceException;

    void saveBook(BookDTO bookDTO) throws ServiceException;
}
