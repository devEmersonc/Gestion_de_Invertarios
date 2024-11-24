package com.devEmersonc.gestion_de_inventarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaveSupplierDTO {
    @NotNull(message = "El nombre no puede ser nulo.")
    @NotBlank(message = "El nombre es obligatorio.")
    private String name;
    @NotNull(message = "El teléfono no puede ser nulo.")
    @NotBlank(message = "El teléfono es obligatorio.")
    private String phone;
    @Email(message = "Ingresa un email válido.")
    @NotNull(message = "El email no puede ser nulo.")
    @NotBlank(message = "El email es obligatorio.")
    private String email;
    @NotNull(message = "La dirección no puede ser nulo.")
    @NotBlank(message = "La dirección es obligatoria.")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
