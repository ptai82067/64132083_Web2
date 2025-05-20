package edu.taipp.repository;

import edu.taipp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
  Optional<Rating> findByUserIdAndRecipeId(Long userId, Long recipeId);
}
