package edu.icet.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
}
