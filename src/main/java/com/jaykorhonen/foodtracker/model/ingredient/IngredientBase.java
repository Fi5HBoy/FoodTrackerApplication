package com.jaykorhonen.foodtracker.model.ingredient;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
public abstract class IngredientBase {

    public IngredientBase(){
        this.name = "name";
        this.fat = 0;
        this.carbs = 0;
        this.protein = 0;
        this.servingSize = 0;
    }

    @Id
    private String id;

    @NonNull String name;
    double fat;
    double carbs;
    double protein;
    double servingSize;

    static double CalculateCalories(IngredientBase ingredient, double weight) {
        if (ingredient == null) {
            return 0;
        }

        double servingSize = ingredient.getServingSize();
        double servings = weight / servingSize;
        return servings * ingredient.getCalories();
    }

    public double getCalories() {
        return (9*fat) + 4*(carbs + protein);
    }
}
