package com.jaykorhonen.foodtracker.repository;

import com.jaykorhonen.foodtracker.model.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends MongoRepository<Ingredient, Long> {

    Ingredient findByName(@Param("name") String name);

    Long findIdByName(@Param("name") String name);

    @Override
    Optional<Ingredient> findById(Long id);

    List<Ingredient> findAll();

    @Override
    Page<Ingredient> findAll(Pageable pageable);

    <I extends Ingredient> I save(I saved);

    @Override
    boolean existsById(Long id);

    void deleteById(Long id);

    void deleteByName(@Param("name") String name);
}