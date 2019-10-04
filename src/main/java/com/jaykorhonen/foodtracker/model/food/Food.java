package com.jaykorhonen.foodtracker.model.food;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Data
public class Food implements IFood {

    @Id
    private String id;

    @NonNull
    private String name;
    private double fat;
    private double carbs;
    private double protein;
    private double servingSize;

    public Food(){
        this.name = "name";
        this.fat = 0;
        this.carbs = 0;
        this.protein = 0;
        this.servingSize = 0;
    }

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

    public double getCalories() {
        return (9*fat) + 4*(carbs + protein);
    }

    public double getFat() {
        return fat;
    }

    void setFat(double fat) {
        this.fat = fat;
    }

    public double getCarbs() {
        return carbs;
    }

    void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProtein() {
        return protein;
    }

    void setProtein(double protein) {
        this.protein = protein;
    }

    double getServingSize() {
        return servingSize;
    }

    void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public String getId() {
        return id;
    }
}
