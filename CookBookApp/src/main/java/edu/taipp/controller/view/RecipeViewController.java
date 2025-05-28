package edu.taipp.controller.view;

import edu.taipp.model.Comment;
import edu.taipp.model.Rating;
import edu.taipp.model.Recipe;
import edu.taipp.service.CommentService;
import edu.taipp.service.RatingService;
import edu.taipp.service.RecipeService;
import edu.taipp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("")
public class RecipeViewController {
  private final RecipeService recipeService;
  private final CommentService commentService;
  private final RatingService ratingService;
  private final UserService userService;

  // Đường dẫn thư mục lưu trữ ảnh trên server
  @Value("${upload.dir:src/main/resources/static/uploads/}")
  private String UPLOAD_DIR;

  @Autowired
  public RecipeViewController(RecipeService recipeService, CommentService commentService, RatingService ratingService, UserService userService ) {
    this.recipeService = recipeService;
    this.commentService = commentService;
    this.ratingService = ratingService;
    this.userService = userService;
  }


  @GetMapping("/admin/recipes")
  public String getAllRecipes(Model model) {
    model.addAttribute("recipes", recipeService.getAllRecipes());
    return "admin/recipes/index";
  }



  @GetMapping("/admin/recipes/create")
  public String showCreateForm(Model model) {
    model.addAttribute("recipe", new Recipe());
    return "admin/recipes/recipe-form";
  }

  @PostMapping("/admin/recipes/create")
  public String createRecipe(@ModelAttribute("recipe") Recipe recipe,
                             @RequestParam("userId") Long userId,
                             @RequestParam("categoryId") Long categoryId,
                             @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
    if (imageFile != null && !imageFile.isEmpty()) {
      try {
        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, imageFile.getBytes());
        recipe.setImageUrl("/uploads/" + fileName);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (recipe.getImageUrl() == null || recipe.getImageUrl().isEmpty()) {
      recipe.setImageUrl("");
    }
    recipeService.createRecipe(userId, categoryId, recipe);
    return "redirect:/admin/recipes";
  }

  @GetMapping("/admin/recipes/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Recipe recipe = recipeService.getRecipeById(id);
    model.addAttribute("recipe", recipe);
    return "admin/recipes/recipe-form";
  }

  @PostMapping("/admin/recipes/edit/{id}")
  public String updateRecipe(@PathVariable Long id,
                             @RequestParam("userId") Long userId,
                             @RequestParam("categoryId") Long categoryId,
                             @ModelAttribute("recipe") Recipe recipe,
                             @RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
    if (imageFile != null && !imageFile.isEmpty()) {
      try {
        String fileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        Path filePath = Paths.get(UPLOAD_DIR + fileName);
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, imageFile.getBytes());
        recipe.setImageUrl("/uploads/" + fileName);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (recipe.getImageUrl() == null || recipe.getImageUrl().isEmpty()) {
      Recipe existingRecipe = recipeService.getRecipeById(id);
      recipe.setImageUrl(existingRecipe.getImageUrl() != null ? existingRecipe.getImageUrl() : "");
    }
    recipeService.updateRecipe(id, userId, categoryId, recipe);
    return "redirect:/admin/recipes";
  }

  @GetMapping("/admin/recipes/delete/{id}")
  public String deleteRecipe(@PathVariable Long id,
                             @RequestParam("userId") Long userId) {
    // Xóa file ảnh nếu có
    Recipe recipe = recipeService.getRecipeById(id);
    if (recipe.getImageUrl() != null && !recipe.getImageUrl().startsWith("http")) {
      try {
        Files.deleteIfExists(Paths.get(UPLOAD_DIR + recipe.getImageUrl().substring("/uploads/".length())));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    recipeService.deleteRecipe(id, userId);
    return "redirect:/admin/recipes";
  }
  @PostMapping("/comment")
  public String addComment(@RequestParam("recipeId") Long recipeId,
                           @RequestParam("content") String content,
                           @RequestParam("score") Integer score,
                           @RequestParam("userId") Long userId) {
    commentService.createComment(recipeId, userId, content); // Lưu comment
    if (score != null && score >= 1 && score <= 5) {
      ratingService.createRating(userId, recipeId,score); // Lưu rating
    }
    return "redirect:/recipe-detail/" + recipeId;
  }
}