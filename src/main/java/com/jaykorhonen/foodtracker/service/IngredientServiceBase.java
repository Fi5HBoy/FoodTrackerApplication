package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;

import java.util.List;

public interface IngredientServiceBase {

    IngredientDTO create(IngredientDTO ingredientDTO);

    IngredientDTO delete(String id);

    List<IngredientDTO> findAll();

    IngredientDTO findById(String id);

    IngredientDTO update(IngredientDTO ingredientDTO);
}
