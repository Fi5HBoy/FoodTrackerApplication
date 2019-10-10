package com.jaykorhonen.foodtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Ingredient already exists")
public class IngredientAlreadyExistsException extends Exception {
    public IngredientAlreadyExistsException(Object o){
        super("IngredientAlreadyExistsException: " + o.toString());
    }
}
