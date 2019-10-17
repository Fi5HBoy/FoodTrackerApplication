package com.jaykorhonen.foodtracker.utilities;

import com.jaykorhonen.foodtracker.model.Ingredient;

public final class Utilities {

    static double CalculateCalories(Ingredient ingredient, double totalWeight) {
        if (ingredient == null) {
            return 0;
        }

        double servingSize = ingredient.getServingSize();
        double servings = totalWeight / servingSize;
        return servings * ingredient.getCalories();
    }
}
