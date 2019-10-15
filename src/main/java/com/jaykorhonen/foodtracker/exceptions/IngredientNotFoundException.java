package com.jaykorhonen.foodtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Ingredient not found")
public class IngredientNotFoundException extends Exception {
    public IngredientNotFoundException(String message){
        super("IngredientNotFoundException: " + message);
    }
}
