package edu.taipp.controller.view;

import edu.taipp.model.Recipe;
import edu.taipp.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/admin/ratings")
public class RatingViewController {
  private final RatingService ratingService;

  @Autowired
  public RatingViewController(RatingService ratingService) {
    this.ratingService = ratingService;
  }

  @GetMapping("/statistics")
  public String getRatingStatistics(Model model) {
    Map<Recipe, Double> averageRatings = ratingService.getAverageRatingByRecipe();
    model.addAttribute("averageRatings", averageRatings);
    return "admin/ratings/statistics";
  }
}