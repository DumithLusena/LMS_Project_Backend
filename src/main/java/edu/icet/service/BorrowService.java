package edu.icet.service;

import edu.icet.dto.BorrowDTO;
import edu.icet.dto.IssueBookRequestDTO;
import edu.icet.dto.ReturnBookRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BorrowService {
    List<BorrowDTO> getAllBorrows();

    List<BorrowDTO> getActiveUserBorrows(Integer userId);

    BorrowDTO issueBook(IssueBookRequestDTO request);

    BorrowDTO returnBook(ReturnBookRequestDTO request);
}
