package edu.taipp.controller;

import edu.taipp.model.Rating;
import edu.taipp.service.RatingService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
  private final RatingService ratingService;

  @Autowired
  public RatingController(RatingService ratingService) {
    this.ratingService = ratingService;
  }

  @GetMapping
  public List<Rating> getAllRatings() {
    return ratingService.getAllRatings();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Rating> getRatingById(@PathVariable Long id) {
    return ResponseEntity.ok(ratingService.getRatingById(id));
  }

  @PostMapping
  public ResponseEntity<Rating> createRating(
          @RequestParam Long userId,
          @RequestParam Long recipeId,
          @RequestParam @Min(1) @Max(5) Integer score) {
    return ResponseEntity.ok(ratingService.createRating(userId, recipeId, score));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Rating> updateRating(
          @PathVariable Long id,
          @RequestParam @Min(1) @Max(5) Integer score) {
    return ResponseEntity.ok(ratingService.updateRating(id, score));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRating(@PathVariable Long id) {
    ratingService.deleteRating(id);
    return ResponseEntity.noContent().build();
  }
}