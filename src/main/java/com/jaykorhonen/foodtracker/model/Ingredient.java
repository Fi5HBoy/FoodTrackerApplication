package com.jaykorhonen.foodtracker.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class Ingredient extends NamedEntity {

    private double fat;
    private double carbs;
    private double protein;
    private double servingSize;

    public double getCalories() {
        return (9*fat) + 4*(carbs + protein);
    }
}
