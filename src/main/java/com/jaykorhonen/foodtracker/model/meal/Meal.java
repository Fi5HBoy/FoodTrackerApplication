package com.jaykorhonen.foodtracker.model.meal;

import com.jaykorhonen.foodtracker.model.menuitem.MenuItem;

import java.util.Date;
import java.util.List;

public class Meal {
    private Date mealDate;
    private String mealType;
    private List<MenuItem> mealItems;
    private double totalCalories;

    Meal(Date mealDate, String mealType, List<MenuItem> mealItems, double totalCalories) {
        this.mealType = mealType;
        this.mealItems = mealItems;
        this.mealDate = mealDate;
        this.totalCalories = totalCalories;
    }

    String getMealType() {
        return mealType;
    }

    List<MenuItem> getMealItems() {
        return mealItems;
    }

    Date getMealDate() {
        return mealDate;
    }

    double getTotalCalories() {
        return totalCalories;
    }
}
