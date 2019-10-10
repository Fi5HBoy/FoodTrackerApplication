package com.jaykorhonen.foodtracker.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public final class IngredientDTO {

    private String id;

    @NotNull
    private String name;
    @NotNull
    private double fat;
    @NotNull
    private double carbs;
    @NotNull
    private double protein;
    @NotNull
    private double servingSize;

    private double calories;
}
