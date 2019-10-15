package com.jaykorhonen.foodtracker.web;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.exceptions.IngredientNotFoundException;
import com.jaykorhonen.foodtracker.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private final IngredientService service;

    @Autowired
    IngredientController(IngredientService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    IngredientDTO create(@RequestBody @Valid IngredientDTO IngredientEntry) {
        return service.create(IngredientEntry);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    IngredientDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<IngredientDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    IngredientDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    IngredientDTO update(@RequestBody @Valid IngredientDTO IngredientEntry) {
        return service.update(IngredientEntry);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(IngredientNotFoundException ex) {
    }
}
