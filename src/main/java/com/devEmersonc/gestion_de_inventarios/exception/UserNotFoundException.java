package com.devEmersonc.gestion_de_inventarios.exception;

public class UserNotFoundException extends ResourceNotFoundException{

    public UserNotFoundException() {
        super("No se ha encontrado al usuario ingresado.");
    }
}
