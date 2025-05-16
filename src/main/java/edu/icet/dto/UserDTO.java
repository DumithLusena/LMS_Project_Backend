package edu.icet.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
//    private LocalDate createdAt;
}
