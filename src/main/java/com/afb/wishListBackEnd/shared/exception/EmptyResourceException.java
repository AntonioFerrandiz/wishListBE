package com.afb.wishListBackEnd.shared.exception;

public class EmptyResourceException extends RuntimeException{
    public EmptyResourceException(String entity){
        super(String.format("Ya tienes este producto en tu wish list",entity));
    }
}
