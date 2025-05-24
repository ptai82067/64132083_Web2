package edu.taipp.controller.view;

import edu.taipp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/categories")
public class CategoryViewController {
  private final CategoryService categoryService;

  @Autowired
  public CategoryViewController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public String getAllCategories(Model model) {
    model.addAttribute("categories", categoryService.getAllCategorys());
    return "admin/categories/index"; // Tên file template (categories.html)
  }
}