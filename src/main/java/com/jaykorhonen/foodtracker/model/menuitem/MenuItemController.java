package com.jaykorhonen.foodtracker.model.menuitem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MenuItemController {

    private final Logger log = LoggerFactory.getLogger(MenuItemController.class);
    private MenuItemRepository menuItemRepository;

    public MenuItemController(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @GetMapping("/menuItems")
    List<MenuItem> menuItems() {
        return menuItemRepository.findAll();
    }

    @GetMapping("/menuItem/{id}")
    ResponseEntity<?> getMenuItem(@PathVariable String id) {
        Optional<MenuItem> menuItem = menuItemRepository.findById(id);
        return menuItem.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/menuItem")
    ResponseEntity<MenuItem> createMenuItem(@Valid @RequestBody MenuItem menuItem) throws URISyntaxException {
        log.info("Request to create menuItem: {}", menuItem);
        MenuItem result = menuItemRepository.save(menuItem);
        return ResponseEntity.created(new URI("/api/menuItem/" + result.getId()))
                .body(result);
    }

    @PutMapping("/menuItem/{id}")
    ResponseEntity<MenuItem> updateMenuItem(@Valid @RequestBody MenuItem menuItem) {
        log.info("Request to update menuItem: {}", menuItem);
        MenuItem result = menuItemRepository.save(menuItem);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/menuItem/{id}")
    public ResponseEntity<?> deleteMenuItem(@PathVariable String id) {
        log.info("Request to delete menuItem: {}", id);
        menuItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
