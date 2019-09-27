package com.jaykorhonen.foodtracker.model.exceptions;

public class CorruptedFileException extends Exception{
    CorruptedFileException(String message) {
        super(message);
    }
}
