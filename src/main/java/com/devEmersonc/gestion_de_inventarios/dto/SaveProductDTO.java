package com.devEmersonc.gestion_de_inventarios.dto;

import com.devEmersonc.gestion_de_inventarios.model.Category;
import com.devEmersonc.gestion_de_inventarios.model.Supplier;
import com.devEmersonc.gestion_de_inventarios.model.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SaveProductDTO {
    @NotNull(message = "El nombre no puede puede ser nulo.")
    @NotBlank(message = "El nombre es obligatorio.")
    private String name;
    @NotNull(message = "La descripción no puede puede ser nulo.")
    @NotBlank(message = "La descripción es obligatoria.")
    private String description;
    @NotNull(message = "El precio no puede puede ser nulo.")
    @Column(
            nullable = false, //No puede ser null
            precision = 15,   //Máximo 15 dígitos totales
            scale = 0         //No se permiten decimales
    )
    private BigDecimal price;
    @NotNull(message = "El stock no puede puede ser nulo.")
    private int stock;
    private User user;
    private Category category;
    private Supplier supplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
