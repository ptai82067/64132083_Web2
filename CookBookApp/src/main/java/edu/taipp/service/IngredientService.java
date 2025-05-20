package edu.taipp.service;

import edu.taipp.model.Ingredient;
import edu.taipp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
  private final IngredientRepository ingredientRepository;

  @Autowired
  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public List<Ingredient> getAllIngredients() {
    return ingredientRepository.findAll();
  }

  public Ingredient getIngredientById(Long id) {
    return ingredientRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ingredient not found with id: " + id));
  }

  public Ingredient createIngredient(Ingredient ingredient) {
    if (ingredientRepository.findByName(ingredient.getName()).isPresent()) {
      throw new RuntimeException("Ingredient with name '" + ingredient.getName() + "' already exists");
    }
    return ingredientRepository.save(ingredient);
  }

  public Ingredient updateIngredient(Long id, Ingredient ingredient) {
    Ingredient existingIngredient = getIngredientById(id);
    existingIngredient.setName(ingredient.getName());
    return ingredientRepository.save(existingIngredient);
  }

  public void deleteIngredient(Long id) {
    Ingredient ingredient = getIngredientById(id);
    ingredientRepository.delete(ingredient);
  }

  // Phương thức tìm theo tên (tùy chọn)
  public Ingredient findByName(String name) {
    return ingredientRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("Ingredient not found with name: " + name));
  }
}