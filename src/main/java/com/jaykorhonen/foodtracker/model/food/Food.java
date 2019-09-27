package com.jaykorhonen.foodtracker.model.food;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Food {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private double fat;
    private double carbs;
    private double protein;
    private double servingSize;

    public Food(String name, double fat, double carbs, double protein, double servingSize) {
        this.name = name;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
        this.servingSize = servingSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private double getCals() {
        return CalculateCalories(this, this.servingSize);
    }

    double getFat() {
        return fat;
    }

    void setFat(double fat) {
        this.fat = fat;
    }

    double getCarbs() {
        return carbs;
    }

    void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    double getProtein() {
        return protein;
    }

    void setProtein(double protein) {
        this.protein = protein;
    }

    private double getServingSize() {
        return servingSize;
    }

    void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public static double CalculateCalories(Food food, double weight) {
        if (food == null) {
            return 0;
        }

        double servingSize = food.getServingSize();
        double servings = weight / servingSize;
        return servings * food.getCals();
    }

    @Override
    public String toString() {
        return name + "\t" +
                this.getCals() + "\t" +
                fat + "\t" +
                carbs + "\t" +
                protein + "\t" +
                servingSize;
    }

    public Long getId() {
        return id;
    }
}
