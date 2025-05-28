package edu.taipp.repository;

import edu.taipp.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  List<Comment> findByRecipeId(Long recipeId);
}
