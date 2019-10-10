package com.jaykorhonen.foodtracker.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
abstract class IngredientBase extends NamedEntity {

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
