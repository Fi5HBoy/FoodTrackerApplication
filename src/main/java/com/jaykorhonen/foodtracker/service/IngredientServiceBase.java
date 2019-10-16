package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;

import java.util.List;

interface IngredientServiceBase extends ServiceBase<IngredientDTO> {
    @Override
    IngredientDTO create(IngredientDTO dto);

    @Override
    IngredientDTO delete(String id);

    @Override
    List<IngredientDTO> findAll();

    @Override
    IngredientDTO findById(String id);

    @Override
    IngredientDTO update(IngredientDTO dto);
}
