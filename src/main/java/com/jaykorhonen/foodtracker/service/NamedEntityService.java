package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.NamedDTO;
import com.jaykorhonen.foodtracker.model.EntityBase;
import com.jaykorhonen.foodtracker.model.NamedEntity;

import java.util.List;

public interface NamedEntityService<T extends NamedDTO> extends ServiceBase<T, EntityBase> {

    T findByName(String name) throws RuntimeException;

    T deleteByName(String name);
}
