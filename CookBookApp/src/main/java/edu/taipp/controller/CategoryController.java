package edu.taipp.controller;

import edu.taipp.model.Category;
import edu.taipp.service.CategoryService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
  CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping()
  public List<Category> getAllCategoryDetails(){
    return categoryService.getAllCategorys();
  }

  @GetMapping("{categoryId}")
  public Category getCategoryDetails(@PathVariable("categoryId") Long categoryId){
    return categoryService.getCategoryById(categoryId);
  }

  @PostMapping
  public String createCategoryDetails(@RequestBody Category category){
    categoryService.createCategory(category);
    return "Category created successfully";
  }

  @PutMapping
  public String updateCategoryDetails(@RequestBody Category category){
    categoryService.updateCategory(category);
    return "Category updated successfully";
  }
  @DeleteMapping("{categoryId}")
  public String deleteCategoryDetails(@PathVariable("categoryId") Long categoryId){
    categoryService.deleteCategoryById(categoryId);
    return "Category deleted successfully";
  }

}
