package edu.icet.controller;

import edu.icet.dto.BorrowDTO;
import edu.icet.dto.IssueBookRequestDTO;
import edu.icet.dto.ReturnBookRequestDTO;
import edu.icet.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
@RequiredArgsConstructor
@CrossOrigin
public class BorrowController {

    private final BorrowService borrowService;

    @GetMapping
    public ResponseEntity<List<BorrowDTO>> getAllBorrows() {
        List<BorrowDTO> borrows = borrowService.getAllBorrows();
        return ResponseEntity.ok(borrows);
    }

    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<BorrowDTO>> getActiveUserBorrows(@PathVariable Integer userId) {
        List<BorrowDTO> borrows = borrowService.getActiveUserBorrows(userId);
        return ResponseEntity.ok(borrows);
    }

    @PostMapping("/issue")
    public ResponseEntity<BorrowDTO> issueBook(@RequestBody IssueBookRequestDTO request) {
        try {
            BorrowDTO borrowDTO = borrowService.issueBook(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(borrowDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/return")
    public ResponseEntity<BorrowDTO> returnBook(@RequestBody ReturnBookRequestDTO request) {
        try {
            BorrowDTO borrowDTO = borrowService.returnBook(request);
            return ResponseEntity.ok(borrowDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
