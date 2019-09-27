package com.jaykorhonen.foodtracker.model.ingredient;

import com.jaykorhonen.foodtracker.model.food.*;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private Long id;
    private double weight;

    @OneToOne
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
