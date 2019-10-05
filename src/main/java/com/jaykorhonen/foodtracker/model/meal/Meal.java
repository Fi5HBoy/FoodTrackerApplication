package com.jaykorhonen.foodtracker.model.meal;

import com.jaykorhonen.foodtracker.model.serving.Serving;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
public class Meal {

    @Id
    private String id;

    @NotNull
    private Date mealDate;
    private String mealType;
    private double totalCalories;

    @DBRef
    private List<Serving> servings;

    Meal(Date mealDate, String mealType, List<Serving> servings, double totalCalories) {
        this.mealType = mealType;
        this.servings = servings;
        this.mealDate = mealDate;
        this.totalCalories = totalCalories;
    }
}
