package edu.icet.service;

import edu.icet.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookByIsbn(String isbn);

    boolean isBookAvailable(String isbn);
}
