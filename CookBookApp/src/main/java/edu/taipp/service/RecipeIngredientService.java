package edu.taipp.service;

import edu.taipp.model.RecipeIngredient;
import edu.taipp.model.Recipe;
import edu.taipp.model.Ingredient;
import edu.taipp.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeIngredientService {
  private final RecipeIngredientRepository recipeIngredientRepository;
  private final RecipeService recipeService; // Giả sử đã có
  private final IngredientService ingredientService; // Giả sử đã có

  @Autowired
  public RecipeIngredientService(RecipeIngredientRepository recipeIngredientRepository,
                                 RecipeService recipeService,
                                 IngredientService ingredientService) {
    this.recipeIngredientRepository = recipeIngredientRepository;
    this.recipeService = recipeService;
    this.ingredientService = ingredientService;
  }

  public List<RecipeIngredient> getAllRecipeIngredients() {
    return recipeIngredientRepository.findAll();
  }

  public RecipeIngredient getRecipeIngredientById(Long id) {
    return recipeIngredientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("RecipeIngredient not found with id: " + id));
  }

  public RecipeIngredient createRecipeIngredient(Long recipeId, Long ingredientId, String quantity) {
    Recipe recipe = recipeService.getRecipeById(recipeId);
    Ingredient ingredient = ingredientService.getIngredientById(ingredientId);
    RecipeIngredient recipeIngredient = new RecipeIngredient();
    recipeIngredient.setRecipe(recipe);
    recipeIngredient.setIngredient(ingredient);
    recipeIngredient.setQuantity(quantity);
    return recipeIngredientRepository.save(recipeIngredient);
  }

  public RecipeIngredient updateRecipeIngredient(Long id, String quantity) {
    RecipeIngredient existingRecipeIngredient = getRecipeIngredientById(id);
    existingRecipeIngredient.setQuantity(quantity);
    return recipeIngredientRepository.save(existingRecipeIngredient);
  }

  public void deleteRecipeIngredient(Long id) {
    RecipeIngredient recipeIngredient = getRecipeIngredientById(id);
    recipeIngredientRepository.delete(recipeIngredient);
  }
}