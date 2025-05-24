package edu.taipp.controller.view;

import edu.taipp.model.Category;
import edu.taipp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
  // Hiển thị form tạo danh mục mới
  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("category", new Category());
    return "admin/categories/category-form";
  }

  // Xử lý tạo danh mục mới
  @PostMapping("/create")
  public String createCategory(@ModelAttribute("category") Category category) {
    categoryService.createCategory(category);
    return "redirect:/admin/categories";
  }

  // Hiển thị form chỉnh sửa danh mục
  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Category category = categoryService.getCategoryById(id);
    model.addAttribute("category", category);
    return "admin/categories/category-form";
  }

  // Xử lý chỉnh sửa danh mục
  @PostMapping("/edit/{id}")
  public String updateCategory(@PathVariable Long id, @ModelAttribute("category") Category category) {
    categoryService.updateCategory(id, category);
    return "redirect:/admin/categories";
  }

  @GetMapping("/delete/{id}")
  public String deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return "redirect:/admin/categories";
  }
}