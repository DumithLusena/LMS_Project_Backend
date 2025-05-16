package edu.icet.service;

import edu.icet.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUsers();
}
