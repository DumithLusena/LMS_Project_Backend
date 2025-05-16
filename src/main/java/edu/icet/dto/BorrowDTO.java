package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BorrowDTO {
    private Integer id;
    private Integer userId;
    private String userName;
    private String bookIsbn;
    private String bookTitle;
    private LocalDateTime borrowedAt;
    private LocalDateTime dueDate;
    private LocalDateTime returnedAt;

}
