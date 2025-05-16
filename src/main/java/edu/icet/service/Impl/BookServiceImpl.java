package edu.icet.service.Impl;

import edu.icet.dto.BookDTO;
import edu.icet.entity.Book;
import edu.icet.entity.Borrow;
import edu.icet.repository.BookRepository;
import edu.icet.repository.BorrowRepository;
import edu.icet.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BorrowRepository borrowRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookByIsbn(String isbn) {
        Book book = bookRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found with ISBN: " + isbn));
        return convertToDTO(book);
    }

    @Override
    public boolean isBookAvailable(String isbn) {
        List<Borrow> activeBorrows = borrowRepository.findActiveBookBorrows(isbn);
        return activeBorrows.isEmpty();
    }

    private BookDTO convertToDTO(Book book) {
        boolean isAvailable = isBookAvailable(book.getIsbn());
        return new BookDTO(book.getIsbn(), book.getTitle(), book.getAuthor(), isAvailable);
    }
}
