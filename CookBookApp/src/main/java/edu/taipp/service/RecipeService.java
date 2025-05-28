package edu.taipp.service;

import edu.taipp.model.Recipe;
import edu.taipp.model.User;
import edu.taipp.model.Category;
import edu.taipp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
  private final RecipeRepository recipeRepository;
  private final UserService userService;
  private final CategoryService categoryService;

  @Autowired
  public RecipeService(RecipeRepository recipeRepository, UserService userService, CategoryService categoryService) {
    this.recipeRepository = recipeRepository;
    this.userService = userService;
    this.categoryService = categoryService;
  }

  public List<Recipe> getAllRecipes() {
    return recipeRepository.findAll();
  }

  public Recipe getRecipeById(Long id) {
    return recipeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Recipe not found with id: " + id));
  }

  public Recipe createRecipe(Long userId, Long categoryId, Recipe recipe) {
    User user = userService.getUserById(userId);
    Category category = categoryService.getCategoryById(categoryId);
    recipe.setUser(user);
    recipe.setCategory(category);
    return recipeRepository.save(recipe);
  }

  public Recipe updateRecipe(Long id, Long userId, Long categoryId, Recipe recipe) {
    Recipe existingRecipe = getRecipeById(id);
    if (!existingRecipe.getUser().getId().equals(userId)) {
      throw new RuntimeException("Only the owner can update this recipe");
    }
    Category category = categoryService.getCategoryById(categoryId);
    existingRecipe.setTitle(recipe.getTitle());
    existingRecipe.setDescription(recipe.getDescription());
    existingRecipe.setInstructions(recipe.getInstructions());
    existingRecipe.setImageUrl(recipe.getImageUrl());
    existingRecipe.setCategory(category);
    return recipeRepository.save(existingRecipe);
  }

  public void deleteRecipe(Long id, Long userId) {
    Recipe recipe = getRecipeById(id);
    if (!recipe.getUser().getId().equals(userId)) {
      throw new RuntimeException("Only the owner can delete this recipe");
    }
    recipeRepository.deleteById(id);
  }



  public List<Recipe> getSuggestedRecipes(Long recipeId) {
    Recipe currentRecipe = getRecipeById(recipeId);
    Long categoryId = currentRecipe.getCategory().getId(); // Giả sử Recipe có getter này

    // Lấy tất cả công thức cùng danh mục, trừ công thức hiện tại
    List<Recipe> similarRecipes = recipeRepository.findAll()
            .stream()
            .filter(recipe -> !recipe.getId().equals(recipeId) && recipe.getCategory().getId().equals(categoryId))
            .collect(Collectors.toList());

    // Nếu không đủ 4 công thức, bổ sung ngẫu nhiên từ các công thức khác
    if (similarRecipes.size() < 4) {
      List<Recipe> otherRecipes = recipeRepository.findAll()
              .stream()
              .filter(recipe -> !recipe.getId().equals(recipeId) && !recipe.getCategory().getId().equals(categoryId))
              .collect(Collectors.toList());
      similarRecipes.addAll(otherRecipes);
    }

    // Xáo trộn và lấy tối đa 4 công thức
    Collections.shuffle(similarRecipes);
    return similarRecipes.stream()
            .limit(4)
            .collect(Collectors.toList());
  }
}