package com.jaykorhonen.foodtracker.model.serving;

import com.jaykorhonen.foodtracker.model.ingredient.IngredientBase;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Serving {

    @Id
    private String id;

    @DBRef
    private IngredientBase ingredient;

    @NonNull
    private double weight;

    Serving(double weight, IngredientBase ingredient) {
        this.ingredient = ingredient;
        this.weight = weight;
    }
}
