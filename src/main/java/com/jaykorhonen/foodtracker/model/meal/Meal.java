package com.jaykorhonen.foodtracker.model.meal;

import com.jaykorhonen.foodtracker.model.menuitem.MenuItem;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class Meal {

    @Id
    private Long id;

    @NotNull
    private Date mealDate;
    private String mealType;
    private double totalCalories;
    private List<MenuItem> mealItems;

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

    public Long getId() {
        return this.id;
    }
}
