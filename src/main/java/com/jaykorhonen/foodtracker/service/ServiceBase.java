package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.NamedDTO;
import com.jaykorhonen.foodtracker.exceptions.IngredientAlreadyExistsException;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.util.List;

public interface ServiceBase<T extends NamedDTO> {

    T create(T dto) throws IngredientAlreadyExistsException, InvalidAttributeIdentifierException;

    T delete(Long id);

    List<T> findAll();

    T findById(Long id);

    T update(T dto);
}
