package com.jaykorhonen.foodtracker.service;

import com.jaykorhonen.foodtracker.dto.NamedDTO;

import java.util.List;

public interface ServiceBase<T extends NamedDTO> {

    T create(T dto);

    T delete(String id);

    List<T> findAll();

    T findById(String id);

    T update(T dto);
}
