package com.jaykorhonen.foodtracker.model.ingredient;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

        import java.util.List;

@RepositoryRestResource(collectionResourceRel = "ingredients", path = "ingredients")
interface IngredientRepository extends MongoRepository<IngredientBase, String> {
    List<IngredientBase> findByName(@Param("name") String name);
    boolean existsByName(@Param("name") String name);
}