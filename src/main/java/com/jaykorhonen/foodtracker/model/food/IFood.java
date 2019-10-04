package com.jaykorhonen.foodtracker.model.food;

public interface IFood {
    double getCalories();

    static double CalculateCalories(Food food, double weight) {
        if (food == null) {
            return 0;
        }

        double servingSize = food.getServingSize();
        double servings = weight / servingSize;
        return servings * food.getCalories();
    }
}
