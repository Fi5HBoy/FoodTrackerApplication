package com.jaykorhonen.foodtracker.exceptions;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String attribute){
        super("InvalidArgumentException: " + attribute);
    }
}
