package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
}
