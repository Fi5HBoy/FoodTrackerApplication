package com.jaykorhonen.foodtracker.model.menuitem;

import com.jaykorhonen.foodtracker.model.ingredient.*;
import com.jaykorhonen.foodtracker.model.food.*;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class MenuItem {

    @Id
    private String id;

    @NonNull
    private String name;
    private double totalCalories;
    private List<Ingredient> ingredients;

    MenuItem(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        totalCalories = 0;
        for(Ingredient ingredient : ingredients) {
            Food food = ingredient.getFood();
            double weight = ingredient.getWeight();
            this.totalCalories += IFood.CalculateCalories(food, weight);
        }
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    List<Ingredient> getIngredients() {
        return ingredients;
    }

    Ingredient getIngredientByName(String ingredientName) {
        ingredientName = ingredientName.trim();
        for (Ingredient ingredient : this.ingredients) {
            if (ingredient.getFood().getName().equalsIgnoreCase(ingredientName)) {
                return ingredient;
            }
        }

        return null;
    }

    void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        Food food = ingredient.getFood();
        double weight = ingredient.getWeight();
        this.totalCalories += IFood.CalculateCalories(food, weight);
    }

    void removeIngredient(Ingredient ingredient) {
        Food food;
        double weight;
        food = ingredient.getFood();
        weight = ingredient.getWeight();

        //This will never return false the way it is currently used, but may if this method is used a different way later.
        if (this.ingredients.remove(ingredient)) {
            this.totalCalories -= IFood.CalculateCalories(food, weight);
        }

    }

    void updateIngredient(Ingredient ingredient, double weight) {
        //This will never return false the way it is currently used, but may if this method is used a different way later.
        if (this.ingredients.contains(ingredient)) {
            //This will make sure that the total calories stay up to date
            this.removeIngredient(ingredient);
            ingredient.setWeight(weight);
            this.addIngredient(ingredient);
        }

    }

    double getTotalCalories() { return totalCalories; }

    public void setTotalCalories(double totalCalories) { this.totalCalories = totalCalories; }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(name + ":\t");
        for (Ingredient ingredient : ingredients) {
            s.append(ingredient.getFood().getName()).append(" ").append(ingredient.getWeight()).append("g, ");
        }
        s = new StringBuilder(s.substring(0, s.length() - 2));
        s.append(" | ").append(totalCalories).append(" calories");
        return s.toString();
    }

    public String getId() {
        return id;
    }
}
