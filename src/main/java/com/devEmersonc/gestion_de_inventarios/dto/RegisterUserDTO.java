package com.devEmersonc.gestion_de_inventarios.dto;

import com.devEmersonc.gestion_de_inventarios.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class RegisterUserDTO {
    @NotNull(message = "Nombre de usuario no puede ser null.")
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    @Size(min = 5, max = 20)
    private String username;
    @NotNull(message = "Contraseña no puede ser null.")
    @NotBlank(message = "La contraseña es obligatoria.")
    private String password;
    @Email(message = "Ingresa un email válido.")
    @NotNull(message = "Email no puede ser null.")
    @NotBlank(message = "El email es obligatorio.")
    private String email;
    @NotNull(message = "El nombre no puede ser null.")
    @NotBlank(message = "El nombre es obligatorio.")
    private String firstname;
    @NotNull(message = "El apellido no puede ser null.")
    @NotBlank(message = "El apellido es obligatorio.")
    private String lastname;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
