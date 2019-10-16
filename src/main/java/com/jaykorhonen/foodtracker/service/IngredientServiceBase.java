package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.exceptions.IngredientAlreadyExistsException;
import com.jaykorhonen.foodtracker.exceptions.IngredientNotFoundException;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.util.List;

interface IngredientServiceBase extends ServiceBase<IngredientDTO> {
    @Override
    IngredientDTO create(IngredientDTO dto) throws IngredientAlreadyExistsException, InvalidAttributeIdentifierException;

    @Override
    IngredientDTO delete(Long id);

    @Override
    List<IngredientDTO> findAll();

    @Override
    IngredientDTO findById(Long id);

    @Override
    IngredientDTO update(IngredientDTO dto) throws IngredientNotFoundException;
}
