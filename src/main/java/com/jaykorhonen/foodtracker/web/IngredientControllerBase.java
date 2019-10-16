package com.jaykorhonen.foodtracker.web;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.exceptions.IngredientAlreadyExistsException;
import com.jaykorhonen.foodtracker.exceptions.IngredientNotFoundException;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.util.List;

public interface IngredientControllerBase {

    IngredientDTO create(IngredientDTO dto) throws IngredientAlreadyExistsException, InvalidAttributeIdentifierException;

    IngredientDTO delete(Long id);

    List<IngredientDTO> findAll();

    IngredientDTO findById(Long id);

    IngredientDTO update(IngredientDTO dto) throws IngredientNotFoundException;
}
