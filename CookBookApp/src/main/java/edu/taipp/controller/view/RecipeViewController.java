package edu.taipp.controller.view;

import edu.taipp.model.Recipe;
import edu.taipp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/recipes")
public class RecipeViewController {
  private final RecipeService recipeService;

  @Autowired
  public RecipeViewController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping
  public String getAllRecipes(Model model) {
    model.addAttribute("recipes", recipeService.getAllRecipes());
    return "admin/recipes/index";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("recipe", new Recipe());
    return "admin/recipes/recipe-form";
  }

  @PostMapping("/create")
  public String createRecipe(@ModelAttribute("recipe") Recipe recipe,
                             @RequestParam("userId") Long userId,
                             @RequestParam("categoryId") Long categoryId) {
    recipeService.createRecipe(userId, categoryId, recipe);
    return "redirect:/admin/recipes";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Recipe recipe = recipeService.getRecipeById(id);
    model.addAttribute("recipe", recipe);
    return "admin/recipes/recipe-form";
  }

  @PostMapping("/edit/{id}")
  public String updateRecipe(@PathVariable Long id,
                             @RequestParam("userId") Long userId,
                             @RequestParam("categoryId") Long categoryId,
                             @ModelAttribute("recipe") Recipe recipe) {
    recipeService.updateRecipe(id, userId, categoryId, recipe);
    return "redirect:/admin/recipes";
  }

  @GetMapping("/delete/{id}")
  public String deleteRecipe(@PathVariable Long id,
                             @RequestParam("userId") Long userId) {
    recipeService.deleteRecipe(id, userId);
    return "redirect:/admin/recipes";
  }
}