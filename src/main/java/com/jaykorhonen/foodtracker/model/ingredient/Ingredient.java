package com.jaykorhonen.foodtracker.model.ingredient;

public class Ingredient extends IngredientBase {

    public Ingredient(){
        super();
    }

    public Ingredient(String name, double fat, double carbs, double protein, double servingSize) {
        this.name = name;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
        this.servingSize = servingSize;
    }
}
