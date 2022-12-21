package com.afb.wishListBackEnd.shared.validation;


import com.afb.wishListBackEnd.shared.exception.EmptyResourceException;
import com.afb.wishListBackEnd.shared.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationErrorHandler {

    @ResponseStatus(code = HttpStatus.ACCEPTED)
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleNotFound(ResourceNotFoundException exception){
        return exception.getMessage();
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmptyResourceException.class)
    public String handleNotFound(EmptyResourceException exception){
        return exception.getMessage();
    }

}
