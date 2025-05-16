package edu.icet.service.Impl;

import edu.icet.dto.BorrowDTO;
import edu.icet.dto.IssueBookRequestDTO;
import edu.icet.dto.ReturnBookRequestDTO;
import edu.icet.repository.BookRepository;
import edu.icet.repository.BorrowRepository;
import edu.icet.repository.UserRepository;
import edu.icet.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {

    private final BorrowRepository borrowRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public List<BorrowDTO> getAllBorrows() {
        return List.of();
    }

    @Override
    public List<BorrowDTO> getActiveUserBorrows(Integer userId) {
        return List.of();
    }

    @Override
    public BorrowDTO issueBook(IssueBookRequestDTO request) {
        return null;
    }

    @Override
    public BorrowDTO returnBook(ReturnBookRequestDTO request) {
        return null;
    }
}
