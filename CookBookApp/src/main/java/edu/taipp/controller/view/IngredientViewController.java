package edu.taipp.controller.view;

import edu.taipp.model.Ingredient;
import edu.taipp.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/ingredients")
public class IngredientViewController {
  private final IngredientService ingredientService;

  @Autowired
  public IngredientViewController(IngredientService ingredientService) {
    this.ingredientService = ingredientService;
  }

  @GetMapping
  public String getAllIngredients(Model model) {
    model.addAttribute("ingredients", ingredientService.getAllIngredients());
    return "admin/ingredients/index";
  }

  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("ingredient", new Ingredient());
    return "admin/ingredients/ingredient-form";
  }

  @PostMapping("/create")
  public String createIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
    ingredientService.createIngredient(ingredient);
    return "redirect:/admin/ingredients";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Ingredient ingredient = ingredientService.getIngredientById(id);
    model.addAttribute("ingredient", ingredient);
    return "admin/ingredients/ingredient-form";
  }

  @PostMapping("/edit/{id}")
  public String updateIngredient(@PathVariable Long id, @ModelAttribute("ingredient") Ingredient ingredient) {
    ingredientService.updateIngredient(id, ingredient);
    return "redirect:/admin/ingredients";
  }

  @GetMapping("/delete/{id}")
  public String deleteIngredient(@PathVariable Long id) {
    ingredientService.deleteIngredient(id);
    return "redirect:/admin/ingredients";
  }
}