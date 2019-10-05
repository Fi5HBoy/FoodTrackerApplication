package com.jaykorhonen.foodtracker.model.ingredient.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Food already exists")
public class FoodAlreadyExistsException extends Exception {
    public FoodAlreadyExistsException(Object o){
        super("FoodAlreadyExistsException: " + o.toString());
    }
}
