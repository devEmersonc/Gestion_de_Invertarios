package com.devEmersonc.gestion_de_inventarios.exception;

public class CategoryNotFoundException extends ResourceNotFoundException{

    public CategoryNotFoundException() {
        super("Categoría ingresada no fue encontrada.");
    }
}
