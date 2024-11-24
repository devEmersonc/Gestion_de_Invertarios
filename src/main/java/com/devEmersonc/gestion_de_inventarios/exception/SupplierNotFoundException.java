package com.devEmersonc.gestion_de_inventarios.exception;

public class SupplierNotFoundException extends ResourceNotFoundException{

    public SupplierNotFoundException() {
        super("El proveedor ingresado no se ha encontrado.");
    }
}
