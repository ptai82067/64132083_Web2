package edu.taipp.controller.view;

import edu.taipp.model.Recipe;
import edu.taipp.service.CategoryService;
import edu.taipp.service.IngredientService;
import edu.taipp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeViewController {
  private final CategoryService categoryService;
  private final IngredientService ingredientService;
  private final RecipeService recipeService;

  @Autowired
  public HomeViewController(CategoryService categoryService, IngredientService ingredientService, RecipeService recipeService) {
    this.categoryService = categoryService;
    this.ingredientService = ingredientService;
    this.recipeService = recipeService;
  }
  @GetMapping("/")
  public String getHomePage(Model model) {
    model.addAttribute("categories", categoryService.getAllCategorys());
    model.addAttribute("ingredients", ingredientService.getAllIngredients());
    model.addAttribute("activeTab", "categories");
    model.addAttribute("recipes", recipeService.getAllRecipes());
    return "user/index";
  }

  @GetMapping("/menu")
  public String getMenuPage(@RequestParam(value = "type", defaultValue = "categories") String type, Model model) {
    model.addAttribute("categories", categoryService.getAllCategorys());
    model.addAttribute("ingredients", ingredientService.getAllIngredients());
    model.addAttribute("activeTab", type);
    return "user/index";
  }
  @GetMapping("/recipe-detail/{id}")
  public String recipe(@PathVariable Long id, Model model){



      model.addAttribute("categories", categoryService.getAllCategorys());
      model.addAttribute("ingredients", ingredientService.getAllIngredients());
      model.addAttribute("activeTab", "categories");
      model.addAttribute("recipe", recipeService.getRecipeById(id));
      return "user/recipe_detail";
  }

}
