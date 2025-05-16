package edu.icet.service.impl;

import edu.icet.dto.BorrowDTO;
import edu.icet.dto.IssueBookRequestDTO;
import edu.icet.dto.ReturnBookRequestDTO;
import edu.icet.entity.Book;
import edu.icet.entity.Borrow;
import edu.icet.entity.User;
import edu.icet.repository.BookRepository;
import edu.icet.repository.BorrowRepository;
import edu.icet.repository.UserRepository;
import edu.icet.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public List<BorrowDTO> getAllBorrows() {
        return borrowRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BorrowDTO> getActiveUserBorrows(Integer userId) {
        return borrowRepository.findActiveUserBorrows(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowDTO issueBook(IssueBookRequestDTO request) {
        List<Borrow> activeBorrows = borrowRepository.findActiveBookBorrows(request.getBookIsbn());
        if (!activeBorrows.isEmpty()) {
            throw new RuntimeException("Book is already borrowed and not yet returned");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + request.getUserId()));

        Book book = bookRepository.findById(request.getBookIsbn())
                .orElseThrow(() -> new RuntimeException("Book not found with ISBN: " + request.getBookIsbn()));

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setBorrowedAt(request.getBorrowedAt());
        borrow.setDueDate(request.getDueDate());
        borrow.setReturnedAt(null);

        Borrow savedBorrow = borrowRepository.save(borrow);
        return convertToDTO(savedBorrow);
    }

    @Override
    public BorrowDTO returnBook(ReturnBookRequestDTO request) {
        Borrow borrow = borrowRepository.findById(request.getBorrowId())
                .orElseThrow(() -> new RuntimeException("Borrow record not found with ID: " + request.getBorrowId()));

        if (borrow.getReturnedAt() != null) {
            throw new RuntimeException("Book is already returned");
        }

        borrow.setReturnedAt(request.getReturnedAt());
        Borrow savedBorrow = borrowRepository.save(borrow);

        return convertToDTO(savedBorrow);
    }

    private BorrowDTO convertToDTO(Borrow borrow) {
        return new BorrowDTO(
                borrow.getId(),
                borrow.getUser().getUserId(),
                borrow.getUser().getName(),
                borrow.getBook().getIsbn(),
                borrow.getBook().getTitle(),
                borrow.getBorrowedAt(),
                borrow.getDueDate(),
                borrow.getReturnedAt()
        );
    }
}
