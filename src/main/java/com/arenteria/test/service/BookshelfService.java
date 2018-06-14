package com.arenteria.test.service;

import com.arenteria.test.core.exception.ServiceException;
import com.arenteria.test.domain.dto.BookDTO;
import java.util.Collection;

public interface BookshelfService {

    Collection<BookDTO> findBookByTittle(String tittle);

    Collection<BookDTO> findBookByDescription(String description);

    Collection<BookDTO> findAllBooks();

    BookDTO findBookById(Integer id) throws ServiceException;

    void saveBook(BookDTO bookDTO) throws ServiceException;
}
