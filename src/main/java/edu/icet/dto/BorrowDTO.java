package edu.icet.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BorrowDTO {
    private Integer id;
    private Integer userId;
    private String bookId;
    private LocalDateTime borrowedAt;
    private LocalDateTime dueDate;
    private LocalDateTime returnedAt;
}
