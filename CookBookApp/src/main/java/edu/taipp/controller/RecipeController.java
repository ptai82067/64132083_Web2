package edu.taipp.controller;

import edu.taipp.model.Recipe;
import edu.taipp.model.RecipeIngredient;
import edu.taipp.service.RecipeIngredientService;
import edu.taipp.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
  private final RecipeService recipeService;
  private final RecipeIngredientService recipeIngredientService;

  @Autowired
  public RecipeController(RecipeService recipeService, RecipeIngredientService recipeIngredientService) {
    this.recipeService = recipeService;
    this.recipeIngredientService = recipeIngredientService;
  }

  @GetMapping
  public List<Recipe> getAllRecipes() {
    return recipeService.getAllRecipes();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
    Recipe recipe = recipeService.getRecipeById(id);
    // Tải danh sách RecipeIngredient liên quan
    recipe.setRecipeIngredients(loadRecipeIngredients(recipe.getId()));
    return ResponseEntity.ok(recipe);
  }

  @PostMapping
  public ResponseEntity<Recipe> createRecipe(
          @RequestParam Long userId,
          @RequestParam Long categoryId,
          @Valid @RequestBody Recipe recipe) {
    return ResponseEntity.ok(recipeService.createRecipe(userId, categoryId, recipe));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Recipe> updateRecipe(
          @PathVariable Long id,
          @RequestParam Long userId,
          @RequestParam Long categoryId,
          @Valid @RequestBody Recipe recipe) {
    return ResponseEntity.ok(recipeService.updateRecipe(id, userId, categoryId, recipe));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRecipe(@PathVariable Long id, @RequestParam Long userId) {
    recipeService.deleteRecipe(id, userId);
    return ResponseEntity.noContent().build();
  }
  // Thêm nl vào công thức
  @PostMapping("/{recipeId}/ingredients")
  public ResponseEntity<RecipeIngredient> addIngredientToRecipe(
          @PathVariable Long recipeId,
          @RequestParam Long ingredientId,
          @RequestParam String quantity) {
    return ResponseEntity.ok(recipeIngredientService.createRecipeIngredient(recipeId, ingredientId, quantity));
  }
  //xóa nl khỏi công thức
  @DeleteMapping("/{recipeId}/ingredients/{ingredientId}")
  public ResponseEntity<Void> removeIngredientFromRecipe(
          @PathVariable Long recipeId,
          @PathVariable Long ingredientId) {
    // Tìm và xóa RecipeIngredient dựa trên recipeId và ingredientId
    List<RecipeIngredient> recipeIngredients = recipeIngredientService.getAllRecipeIngredients();
    RecipeIngredient toDelete = recipeIngredients.stream()
            .filter(ri -> ri.getRecipe().getId().equals(recipeId) && ri.getIngredient().getId().equals(ingredientId))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("RecipeIngredient not found"));
    recipeIngredientService.deleteRecipeIngredient(toDelete.getId());
    return ResponseEntity.noContent().build();
  }
  // Phương thức phụ để tải danh sách RecipeIngredient
  private List<RecipeIngredient> loadRecipeIngredients(Long recipeId) {
    return recipeIngredientService.getAllRecipeIngredients().stream()
            .filter(ri -> ri.getRecipe().getId().equals(recipeId))
            .toList();
  }
}