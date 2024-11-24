package com.devEmersonc.gestion_de_inventarios.service.userservice;

import com.devEmersonc.gestion_de_inventarios.dto.RegisterUserDTO;
import com.devEmersonc.gestion_de_inventarios.dto.UserDTO;
import com.devEmersonc.gestion_de_inventarios.model.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUser(Long id);
    void saveNormalUser(RegisterUserDTO registerUserDTO);
    void saveAdminUser(RegisterUserDTO registerUserDTO);
    void updateUser(Long id, RegisterUserDTO registerUserDTO);
    void deleteUser(Long id);
    User getCurrentUser(User currentUser);
    UserDTO convertEntityToDto(User user);
}
