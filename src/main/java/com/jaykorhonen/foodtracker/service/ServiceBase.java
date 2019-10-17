package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.DTOBase;
import com.jaykorhonen.foodtracker.exceptions.IngredientAlreadyExistsException;
import com.jaykorhonen.foodtracker.model.EntityBase;

import javax.naming.directory.InvalidAttributeIdentifierException;
import java.util.List;

public interface ServiceBase<T extends DTOBase, E extends EntityBase> {

    T create(T dto) throws RuntimeException;

    T delete(Long id);

    List<T> findAll();

    T findById(Long id);

    T update(T dto) throws RuntimeException;
}
