package com.jaykorhonen.foodtracker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Ingredient extends NamedEntity {

    private double fat;
    private double carbs;
    private double protein;
    private double servingSize;

    static double CalculateCalories(Ingredient ingredient, double weight) {
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
