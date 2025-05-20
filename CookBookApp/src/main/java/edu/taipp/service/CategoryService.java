package edu.taipp.service;

import edu.taipp.model.Category;
import edu.taipp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }
  public String createCategory(Category category){
    categoryRepository.save(category);
    return "Success";
  }
  public String updateCategory(Category category){
    categoryRepository.save(category);
    return "Success";
  }
  public String deleteCategoryById(Long categoryId){
    categoryRepository.deleteById(categoryId);
    return "Success";
  }
  public Category getCategoryById(Long categoryId){
    return categoryRepository.findById(categoryId).get();
  }
  public List<Category> getAllCategorys(){

    return categoryRepository.findAll();
  }
}
