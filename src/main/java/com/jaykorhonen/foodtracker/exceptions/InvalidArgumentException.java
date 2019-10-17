package com.jaykorhonen.foodtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid argument")
public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String argument){
        super("InvalidArgumentException: " + argument);
    }
}
