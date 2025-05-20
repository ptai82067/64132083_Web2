package edu.taipp.service;

import edu.taipp.model.Comment;
import edu.taipp.model.Recipe;
import edu.taipp.model.User;
import edu.taipp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
  private final CommentRepository commentRepository;
  private final RecipeService recipeService; // Giả sử đã có
  private final UserService userService;    // Giả sử đã có

  @Autowired
  public CommentService(CommentRepository commentRepository, RecipeService recipeService, UserService userService) {
    this.commentRepository = commentRepository;
    this.recipeService = recipeService;
    this.userService = userService;
  }

  public List<Comment> getAllComments() {
    return commentRepository.findAll();
  }

  public Comment getCommentById(Long id) {
    return commentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
  }

  public Comment createComment(Long recipeId, Long userId, String content) {
    Recipe recipe = recipeService.getRecipeById(recipeId);
    User user = userService.getUserById(userId);
    Comment comment = new Comment(content, user, recipe);
    return commentRepository.save(comment);
  }

  public Comment updateComment(Long id, String content) {
    Comment existingComment = getCommentById(id);
    existingComment.setContent(content);
    return commentRepository.save(existingComment);
  }

  public void deleteComment(Long id) {
    commentRepository.deleteById(id);
  }
}