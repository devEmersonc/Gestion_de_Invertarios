package com.devEmersonc.gestion_de_inventarios.service.serviceImpl.userServiceImpl;

import com.devEmersonc.gestion_de_inventarios.dto.RegisterUserDTO;
import com.devEmersonc.gestion_de_inventarios.dto.UserDTO;
import com.devEmersonc.gestion_de_inventarios.exception.UserNotFoundException;
import com.devEmersonc.gestion_de_inventarios.model.User;
import com.devEmersonc.gestion_de_inventarios.repository.RoleRepository;
import com.devEmersonc.gestion_de_inventarios.repository.UserRepository;
import com.devEmersonc.gestion_de_inventarios.service.userservice.UserService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        return convertEntityToDto(user);
    }

    @Override
    public void saveNormalUser(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setUsername(registerUserDTO.getUsername());
        user.setEmail(registerUserDTO.getEmail());
        user.setFirstname(registerUserDTO.getFirstname());
        user.setLastname(registerUserDTO.getLastname());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }

    @Override
    public void saveAdminUser(RegisterUserDTO registerUserDTO) {
        User user = new User();
        user.setUsername(registerUserDTO.getUsername());
        user.setEmail(registerUserDTO.getEmail());
        user.setFirstname(registerUserDTO.getFirstname());
        user.setLastname(registerUserDTO.getLastname());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void updateUser(Long id, RegisterUserDTO registerUserDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        user.setUsername(registerUserDTO.getUsername());
        user.setEmail(registerUserDTO.getEmail());
        user.setFirstname(registerUserDTO.getFirstname());
        user.setLastname(registerUserDTO.getLastname());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        userRepository.save(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
        userRepository.deleteById(user.getId());
    }

    @Override
    public User getCurrentUser(User currentUser) {
        User user = userRepository.findByUsername(currentUser.getUsername());
        return user;
    }

    @Override
    public UserDTO convertEntityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        return userDTO;
    }
}
