package edu.taipp.controller;

import edu.taipp.model.Comment;
import edu.taipp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping
  public List<Comment> getAllComments() {
    return commentService.getAllComments();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
    return ResponseEntity.ok(commentService.getCommentById(id));
  }

  @PostMapping
  public ResponseEntity<Comment> createComment(
          @RequestParam Long recipeId,
          @RequestParam Long userId,
          @RequestParam String content) {
    return ResponseEntity.ok(commentService.createComment(recipeId, userId, content));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestParam String content) {
    return ResponseEntity.ok(commentService.updateComment(id, content));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
    commentService.deleteComment(id);
    return ResponseEntity.noContent().build();
  }
}