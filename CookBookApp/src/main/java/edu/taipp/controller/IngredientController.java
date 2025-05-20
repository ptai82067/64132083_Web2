package edu.taipp.controller;

import edu.taipp.model.Ingredient;
import edu.taipp.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
  private final IngredientService ingredientService;

  @Autowired
  public IngredientController(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping
  public List<Ingredient> getAllIngredients() {
    return ingredientService.getAllIngredients();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Ingredient> getIngredientById(@PathVariable Long id) {
    return ResponseEntity.ok(ingredientService.getIngredientById(id));
  }

  @PostMapping
  public ResponseEntity<Ingredient> createIngredient(@Valid @RequestBody Ingredient ingredient) {
    return ResponseEntity.ok(ingredientService.createIngredient(ingredient));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Ingredient> updateIngredient(@PathVariable Long id, @Valid @RequestBody Ingredient ingredient) {
    return ResponseEntity.ok(ingredientService.updateIngredient(id, ingredient));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
    ingredientService.deleteIngredient(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/name/{name}")
  public ResponseEntity<Ingredient> getIngredientByName(@PathVariable String name) {
    return ResponseEntity.ok(ingredientService.findByName(name));
  }
}