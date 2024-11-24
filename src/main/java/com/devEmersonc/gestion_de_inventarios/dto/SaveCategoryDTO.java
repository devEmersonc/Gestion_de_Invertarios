package com.devEmersonc.gestion_de_inventarios.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SaveCategoryDTO {
    @NotNull(message = "El nombre no puede ser nulo.")
    @NotBlank(message = "El nombre es obligatorio.")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
