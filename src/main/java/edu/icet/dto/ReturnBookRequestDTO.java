package edu.icet.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReturnBookRequestDTO {
    private Integer borrowId;
    private LocalDateTime returnedAt;
}
