package com.jaykorhonen.foodtracker.web;

import com.jaykorhonen.foodtracker.dto.IngredientDTO;
import com.jaykorhonen.foodtracker.exceptions.InvalidArgumentException;
import com.jaykorhonen.foodtracker.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

//TODO: ControllerAdvice
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
        try {
            return service.create(IngredientEntry);
        } catch (InvalidArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    IngredientDTO delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    List<IngredientDTO> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    IngredientDTO findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    IngredientDTO update(@RequestBody @Valid IngredientDTO IngredientEntry) {
        return service.update(IngredientEntry);
    }
}
