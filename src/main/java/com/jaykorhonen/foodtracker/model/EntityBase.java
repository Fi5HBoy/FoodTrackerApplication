package com.jaykorhonen.foodtracker.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

@Data
@SuperBuilder
@NoArgsConstructor
abstract class EntityBase {

    @Id
    String id;
}
