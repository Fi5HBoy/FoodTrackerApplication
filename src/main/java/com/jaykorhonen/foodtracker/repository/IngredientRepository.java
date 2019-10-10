package com.jaykorhonen.foodtracker.repository;

import com.jaykorhonen.foodtracker.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ingredients", path = "ingredients")
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    List<Ingredient> findByName(@Param("name") String name);
    boolean existsByName(@Param("name") String name);
    List<Ingredient> findAll();
    <I extends com.jaykorhonen.foodtracker.model.Ingredient> I save(I saved);
}