package com.arenteria.test.truelogic.service;

import com.arenteria.test.truelogic.core.exception.ServiceException;
import com.arenteria.test.truelogic.domain.dto.BookDTO;
import java.util.List;

public interface BookshelfService {

    List<BookDTO> findBookByTitle(String title) throws ServiceException;

    List<BookDTO> findBookByDescription(String description) throws ServiceException;

    List<BookDTO> findAllBooks() throws ServiceException;

    BookDTO findBookByIsbn(String isbn) throws ServiceException;

    void saveBook(BookDTO bookDTO) throws ServiceException;
}
