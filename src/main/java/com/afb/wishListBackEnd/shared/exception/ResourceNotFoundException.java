package com.afb.wishListBackEnd.shared.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id){
        super(String.format("Las id de usuario no coinciden %s", id));
    }
    public ResourceNotFoundException(String entity, Long id) {
        super(String.format("%s con id %d no existe.", entity, id));
    }

    public ResourceNotFoundException(String username) {
        super(String.format("Username %s no existe.", username));
    }
}
