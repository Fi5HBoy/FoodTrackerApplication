package com.jaykorhonen.foodtracker.model.meal;

import java.util.Date;

//TODO: this is wrong
public interface MealRepositoryCustom {
    Meal findByDateAndType(Date mealDate, String mealType);
}
