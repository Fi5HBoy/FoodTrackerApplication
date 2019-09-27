package com.jaykorhonen.foodtracker.model.food;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Food {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private double cals;
    private double fat;
    private double carbs;
    private double protein;
    private double servingSize;

    Food(String name, double cals, double fat, double carbs, double protein, double servingSize) {
        this.name = name;
        this.cals = cals;
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
        return cals;
    }

    void setCals(double cals) {
        this.cals = cals;
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
                cals + "\t" +
                fat + "\t" +
                carbs + "\t" +
                protein + "\t" +
                servingSize;
    }

    public Long getId() {
        return id;
    }
}
