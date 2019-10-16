package com.jaykorhonen.foodtracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Ingredient not found")
public class IngredientNotFoundException extends RuntimeException {
    public IngredientNotFoundException(String name){
        super("IngredientNotFoundException: " + name + " does not exist");
    }

    public IngredientNotFoundException(Long id){
        super("IngredientNotFoundException: ingredient with id: " + id + " does not exist");
    }
}
