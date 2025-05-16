package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

}
