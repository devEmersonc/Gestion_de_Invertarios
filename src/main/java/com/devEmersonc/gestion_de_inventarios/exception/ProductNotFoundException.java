package com.devEmersonc.gestion_de_inventarios.exception;

public class ProductNotFoundException extends ResourceNotFoundException{

    public ProductNotFoundException() {
        super("El producto ingresado no se encontró en la base de datos.");
    }
}
