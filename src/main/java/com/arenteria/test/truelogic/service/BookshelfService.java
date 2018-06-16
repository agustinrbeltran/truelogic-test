package com.arenteria.test.truelogic.service;

import com.arenteria.test.truelogic.core.exception.ServiceException;
import com.arenteria.test.truelogic.domain.dto.BookDTO;
import java.util.Collection;

public interface BookshelfService {

    Collection<BookDTO> findBookByTittle(String tittle);

    Collection<BookDTO> findBookByDescription(String description);

    Collection<BookDTO> findAllBooks();

    BookDTO findBookById(Integer id);

    void saveBook(BookDTO bookDTO) throws ServiceException;
}
