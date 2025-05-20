package edu.taipp.service;

import edu.taipp.model.Category;
import edu.taipp.repository.CategoryRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }
  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }
  public Category updateCategory(Long id, Category category) {
    Category existingCategory = getCategoryById(id);
    existingCategory.setName(category.getName());
    return categoryRepository.save(existingCategory);
  }
  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
  public Category getCategoryById(Long id) {
    return categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
  }
  public List<Category> getAllCategorys(){

    return categoryRepository.findAll();
  }
}
