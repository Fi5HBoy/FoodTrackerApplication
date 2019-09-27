package com.jaykorhonen.foodtracker.model.menuitem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuItemRepository extends MongoRepository<MenuItem, Long> {
    MenuItem findByName(String name);
}
