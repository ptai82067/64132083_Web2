package edu.taipp.repository;

import edu.taipp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
  Optional<Rating> findByUserIdAndRecipeId(Long userId, Long recipeId);
  List<Rating> findByRecipeId(Long recipeId);
  Long countByRecipeId(Long recipeId);
}
