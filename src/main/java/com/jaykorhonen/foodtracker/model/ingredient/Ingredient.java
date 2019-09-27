package com.jaykorhonen.foodtracker.model.ingredient;

import com.jaykorhonen.foodtracker.model.food.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Ingredient {

    @Id
    private Long id;
    private double weight;
    private Food food;

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
