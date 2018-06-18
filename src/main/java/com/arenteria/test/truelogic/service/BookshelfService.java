package com.arenteria.test.truelogic.service;

import com.arenteria.test.truelogic.core.exception.ServiceException;
import com.arenteria.test.truelogic.domain.dto.BookDTO;
import java.util.List;

public interface BookshelfService {

    List<BookDTO> findBookByTittle(String tittle);

    List<BookDTO> findBookByDescription(String description);

    List<BookDTO> findAllBooks();

    BookDTO findBookByIsbn(String isbn);

    void saveBook(BookDTO bookDTO) throws ServiceException;
}
