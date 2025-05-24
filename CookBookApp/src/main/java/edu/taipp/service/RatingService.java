package edu.taipp.service;

import edu.taipp.model.Rating;
import edu.taipp.model.Recipe;
import edu.taipp.model.User;
import edu.taipp.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService {
  private final RatingRepository ratingRepository;
  private final UserService userService; // Giả sử đã có
  private final RecipeService recipeService; // Giả sử đã có

  @Autowired
  public RatingService(RatingRepository ratingRepository, UserService userService, RecipeService recipeService) {
    this.ratingRepository = ratingRepository;
    this.userService = userService;
    this.recipeService = recipeService;
  }

  public List<Rating> getAllRatings() {
    return ratingRepository.findAll();
  }

  public Rating getRatingById(Long id) {
    return ratingRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Rating not found with id: " + id));
  }

  public Rating createRating(Long userId, Long recipeId, Integer score) {
    if (score < 1 || score > 5) {
      throw new RuntimeException("Score must be between 1 and 5");
    }
    User user = userService.getUserById(userId);
    Recipe recipe = recipeService.getRecipeById(recipeId);
    // Kiểm tra xem người dùng đã đánh giá công thức này chưa
    if (ratingRepository.findByUserIdAndRecipeId(userId, recipeId).isPresent()) {
      throw new RuntimeException("User has already rated this recipe");
    }
    Rating rating = new Rating();
    rating.setUser(user);
    rating.setRecipe(recipe);
    rating.setScore(score);
    return ratingRepository.save(rating);
  }

  public Rating updateRating(Long id, Integer score) {
    if (score < 1 || score > 5) {
      throw new RuntimeException("Score must be between 1 and 5");
    }
    Rating existingRating = getRatingById(id);
    existingRating.setScore(score);
    return ratingRepository.save(existingRating);
  }

  public void deleteRating(Long id) {
    Rating rating = getRatingById(id);
    ratingRepository.delete(rating);
  }

  // Phương thức tìm theo userId và recipeId (tùy chỉnh)
  public Optional<Rating> findByUserIdAndRecipeId(Long userId, Long recipeId) {
    return ratingRepository.findByUserIdAndRecipeId(userId, recipeId);
  }
  // Thêm phương thức tính điểm trung bình theo Recipe
  public Map<Recipe, Double> getAverageRatingByRecipe() {
    List<Rating> ratings = ratingRepository.findAll();
    // Nhóm ratings theo Recipe và tính điểm trung bình
    Map<Recipe, List<Rating>> groupedByRecipe = ratings.stream()
            .collect(Collectors.groupingBy(Rating::getRecipe));

    Map<Recipe, Double> averageRatings = new HashMap<>();
    for (Map.Entry<Recipe, List<Rating>> entry : groupedByRecipe.entrySet()) {
      Recipe recipe = entry.getKey();
      List<Rating> recipeRatings = entry.getValue();
      double average = recipeRatings.stream()
              .mapToInt(Rating::getScore)
              .average()
              .orElse(0.0);
      averageRatings.put(recipe, average);
    }
    return averageRatings;
  }
}