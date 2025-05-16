package edu.icet.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IssueBookRequestDTO {
    private Integer userId;
    private String bookIsbn;
    private LocalDateTime borrowedAt;
    private LocalDateTime dueDate;
}
