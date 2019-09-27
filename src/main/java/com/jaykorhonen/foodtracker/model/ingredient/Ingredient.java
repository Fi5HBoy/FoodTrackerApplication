package com.jaykorhonen.foodtracker.model.ingredient;

import com.jaykorhonen.foodtracker.model.food.*;

public class Ingredient {
    private final Food food;
    private double weight;

    Ingredient(Food food, double weight) {
        this.food = food;
        this.weight = weight;
    }

    public Food getFood() {
        return food;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return food + "\t" + weight;
    }
}
